package edu.nyu.sdg.penalties.inputstream.file;

import static com.google.common.base.Charsets.UTF_8;
import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkState;
import static java.util.Objects.requireNonNull;
import static org.apache.commons.lang3.StringUtils.*;

import edu.nyu.sdg.penalties.controller.FlowOrchestrator;
import edu.nyu.sdg.penalties.model.RentStabilizedBBLFeedData;
import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.validator.routines.BigDecimalValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class RentStabilizedFileLoader {

  private static final BigDecimalValidator BIGDECIMAL_VALIDATOR = new BigDecimalValidator();
  private static final Logger LOG = LoggerFactory.getLogger(RentStabilizedFileLoader.class);

  private final Clock clock;
  private final ExecutorService threadPool;
  private final FlowOrchestrator flowOrchestrator;
  private static CSVFormat csvFormat;

  public RentStabilizedFileLoader(
      Clock clock, ExecutorService threadPool, FlowOrchestrator flowOrchestrator) {
    this.clock = requireNonNull(clock, "clock is required and missing.");
    this.threadPool = requireNonNull(threadPool, "threadPool is required and missing.");
    this.flowOrchestrator =
        requireNonNull(flowOrchestrator, "flowOrchestrator is required and missing.");

    String csvHeader =
        "bbl,mp_version,mp_res_units,dof_stab_units_2018,dof_stab_units_2019,stab_unit_pct";

    csvFormat = CSVFormat.RFC4180.withHeader(csvHeader.split(",")).withSkipHeaderRecord();
  }

  public void loadCSV(String sourceFile) throws Exception {
    checkArgument(isNotBlank(sourceFile), "sourceFile is required and missing.");

    File csvDataFile = new File(sourceFile);
    CSVParser csvParser = CSVParser.parse(csvDataFile, UTF_8, csvFormat);
    csvParser.getHeaderMap();

    AtomicInteger errorCounter = new AtomicInteger(0);
    AtomicInteger lineCounter = new AtomicInteger(0);

    LOG.info("Started loading file:{}", csvDataFile.getName());
    Instant startTime = clock.instant();

    for (CSVRecord record : csvParser) {
      if (null != record) {

        threadPool.submit(
            () -> {
              lineCounter.getAndIncrement();
              RentStabilizedBBLFeedData rentStabilizedBBLFeedData = new RentStabilizedBBLFeedData();

              try {

                rentStabilizedBBLFeedData.setBBL(parseIntoString(record, "bbl"));
                rentStabilizedBBLFeedData.setMpVersion(parseIntoString(record, "mp_version"));
                rentStabilizedBBLFeedData.setMpResidentialUnits(
                    parseIntoInt(record, "mp_res_units"));
                rentStabilizedBBLFeedData.setStabilizedUnits2018(
                    parseIntoInt(record, "dof_stab_units_2018"));
                rentStabilizedBBLFeedData.setStabilizedUnits2019(
                    parseIntoInt(record, "dof_stab_units_2019"));
                rentStabilizedBBLFeedData.setStabilizedUnitPercentage(
                    parseIntoBigDecimal(record, "stab_unit_pct"));

                flowOrchestrator.loadRentStabilizedUnitsData(rentStabilizedBBLFeedData);

              } catch (Exception excp) {
                errorCounter.getAndIncrement();
                LOG.error(
                    "Exception while processing BBL:{}:{}",
                    rentStabilizedBBLFeedData.getBBL(),
                    excp.getMessage());
              }
            });
      }
    }

    LOG.info(
        "Hydration complete. {}/{} rows loaded successfully in {}",
        (lineCounter.get() - errorCounter.get()),
        lineCounter,
        Duration.between(startTime, clock.instant()));
  }

  private static String parseIntoString(CSVRecord record, String columnName) {
    requireNonNull(record, "record is required and missing.");
    checkState(isNotEmpty(columnName), "columnName is required and missing.");

    return trim(record.get(columnName));
  }

  private static int parseIntoInt(CSVRecord record, String columnName) {
    requireNonNull(record, "record is required and missing.");
    checkState(isNotEmpty(columnName), "columnName is required and missing.");

    String data = trim(record.get(columnName));
    return StringUtils.isNumeric(data) ? NumberUtils.createInteger(data) : 0;
  }

  private static BigDecimal parseIntoBigDecimal(CSVRecord record, String columnName) {
    requireNonNull(record, "record is required and missing.");
    checkState(isNotEmpty(columnName), "columnName is required and missing.");

    String data = trim(record.get(columnName));
    return BIGDECIMAL_VALIDATOR.isValid(data)
        ? new BigDecimal(data).setScale(2, RoundingMode.DOWN)
        : BigDecimal.ZERO;
  }
}
