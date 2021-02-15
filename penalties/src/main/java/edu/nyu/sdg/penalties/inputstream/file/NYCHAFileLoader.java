package edu.nyu.sdg.penalties.inputstream.file;

import static com.google.common.base.Charsets.UTF_8;
import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkState;
import static java.util.Objects.requireNonNull;
import static org.apache.commons.lang3.StringUtils.*;

import edu.nyu.sdg.penalties.controller.FlowOrchestrator;
import edu.nyu.sdg.penalties.model.NYCHAFeedData;
import java.io.File;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class NYCHAFileLoader {

  private static final Logger LOG = LoggerFactory.getLogger(NYCHAFileLoader.class);

  private final FlowOrchestrator flowOrchestrator;
  private static CSVFormat csvFormat;

  public NYCHAFileLoader(FlowOrchestrator flowOrchestrator) {
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

    int lineCounter = 0;
    int errorCounter = 0;

    LOG.info("Started loading file:{}", csvDataFile.getName());

    for (CSVRecord record : csvParser) {
      if (null != record) {

        lineCounter++;
        NYCHAFeedData nychaFeedData = new NYCHAFeedData();

        try {

          nychaFeedData.setBBL(parseIntoString(record, "bbl"));
          nychaFeedData.setDevelopment(parseIntoString(record, "development"));

          flowOrchestrator.loadNYCHAData(nychaFeedData);

        } catch (Exception excp) {
          errorCounter++;
          LOG.error("Exception while processing BBL:{}", nychaFeedData.getBBL(), excp);
        }
      }
    }

    LOG.info(
        "Hydration complete. {}/{} rows loaded successfully",
        (lineCounter - errorCounter),
        lineCounter);
  }

  private static String parseIntoString(CSVRecord record, String columnName) {
    requireNonNull(record, "record is required and missing.");
    checkState(isNotEmpty(columnName), "columnName is required and missing.");

    return trim(record.get(columnName));
  }
}