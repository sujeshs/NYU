package edu.nyu.sdg.penalties.inputstream.file;

import static com.google.common.base.Charsets.UTF_8;
import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkState;
import static java.util.Objects.requireNonNull;
import static org.apache.commons.lang3.StringUtils.*;

import edu.nyu.sdg.penalties.controller.FlowOrchestrator;
import edu.nyu.sdg.penalties.model.QCTFeedData;
import java.io.File;
import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class QCTFileLoader {

  private static final Logger LOG = LoggerFactory.getLogger(QCTFileLoader.class);

  private final Clock clock;
  private final CSVFormat csvFormat;
  private final ExecutorService threadPool;
  private final FlowOrchestrator flowOrchestrator;

  public QCTFileLoader(Clock clock, ExecutorService threadPool, FlowOrchestrator flowOrchestrator) {
    this.clock = requireNonNull(clock, "clock is required and missing.");
    this.threadPool = requireNonNull(threadPool, "threadPool is required and missing.");
    this.flowOrchestrator =
        requireNonNull(flowOrchestrator, "flowOrchestrator is required and missing.");

    String csvHeader = "geoid,bbl,address,bin";

    csvFormat = CSVFormat.RFC4180.withHeader(csvHeader.split(",")).withSkipHeaderRecord();
  }

  public void loadCSV(String sourceFile) throws Exception {
    checkArgument(isNotBlank(sourceFile), "sourceFile is required and missing.");

    File csvDataFile = new File(sourceFile);
    CSVParser csvParser = CSVParser.parse(csvDataFile, UTF_8, csvFormat);
    csvParser.getHeaderMap();

    AtomicInteger errorCounter = new AtomicInteger(0);
    AtomicInteger lineCounter = new AtomicInteger(0);

    LOG.info("Started loading file {}", csvDataFile.getName());
    Instant startTime = clock.instant();

    for (CSVRecord record : csvParser) {
      if (null != record) {

        threadPool.submit(
            () -> {
              Instant recordStartTime = clock.instant();

              lineCounter.getAndIncrement();
              QCTFeedData qctFeedData = null;

              try {

                qctFeedData =
                    new QCTFeedData(
                        parseIntoString(record, "geoid"),
                        parseIntoString(record, "bbl"),
                        parseIntoString(record, "address"),
                        parseIntoString(record, "bin"));

                flowOrchestrator.loadQCTData(qctFeedData);

              } catch (Exception excp) {
                errorCounter.getAndIncrement();
                LOG.error(
                    "Exception while processing BBL:{}:{}",
                    null == qctFeedData ? null : qctFeedData.getBbl(),
                    excp.getMessage());
              }
            });
      }
    }

    LOG.info(
        "Hydration complete. {}/{} rows loaded successfully in {} seconds",
        (lineCounter.get() - errorCounter.get()),
        lineCounter,
        Duration.between(startTime, clock.instant()).getSeconds());
  }

  private static String parseIntoString(CSVRecord record, String columnName) {
    requireNonNull(record, "record is required and missing.");
    checkState(isNotEmpty(columnName), "columnName is required and missing.");

    return trim(record.get(columnName));
  }
}
