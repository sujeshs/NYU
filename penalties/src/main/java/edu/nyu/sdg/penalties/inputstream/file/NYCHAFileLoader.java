package edu.nyu.sdg.penalties.inputstream.file;

import static com.google.common.base.Charsets.UTF_8;
import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkState;
import static java.util.Objects.requireNonNull;
import static org.apache.commons.lang3.StringUtils.*;

import edu.nyu.sdg.penalties.controller.FlowOrchestrator;
import edu.nyu.sdg.penalties.model.NYCHAFeedData;
import io.micrometer.core.instrument.Timer;
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

public final class NYCHAFileLoader {

  private static final Logger LOG = LoggerFactory.getLogger(NYCHAFileLoader.class);

  private final Clock clock;
  private final CSVFormat csvFormat;
  private final ExecutorService threadPool;
  private final FlowOrchestrator flowOrchestrator;
  private final Timer timer;

  public NYCHAFileLoader(
      Clock clock, Timer timer, ExecutorService threadPool, FlowOrchestrator flowOrchestrator) {
    this.clock = requireNonNull(clock, "clock is required and missing.");
    this.timer = requireNonNull(timer, "timer is required and missing.");
    this.threadPool = requireNonNull(threadPool, "threadPool is required and missing.");
    this.flowOrchestrator =
        requireNonNull(flowOrchestrator, "flowOrchestrator is required and missing.");

    String csvHeader = "development,borough,bbl";

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
              NYCHAFeedData nychaFeedData = new NYCHAFeedData();

              try {

                nychaFeedData.setBBL(parseIntoString(record, "bbl"));
                nychaFeedData.setDevelopment(parseIntoString(record, "development"));

                flowOrchestrator.loadNYCHAData(nychaFeedData);

              } catch (Exception excp) {
                errorCounter.getAndIncrement();
                LOG.error(
                    "Exception while processing BBL:{}:{}",
                    nychaFeedData.getBBL(),
                    excp.getMessage());
              }
              timer.record(Duration.between(recordStartTime, clock.instant()));
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
