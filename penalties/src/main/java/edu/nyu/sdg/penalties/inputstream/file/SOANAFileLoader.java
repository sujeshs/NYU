package edu.nyu.sdg.penalties.inputstream.file;

import static com.google.common.base.Charsets.UTF_8;
import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkState;
import static java.util.Objects.requireNonNull;
import static org.apache.commons.lang3.StringUtils.*;

import edu.nyu.sdg.penalties.controller.FlowOrchestrator;
import edu.nyu.sdg.penalties.model.SoanaFeedData;
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

public final class SOANAFileLoader {

  private static final Logger LOG = LoggerFactory.getLogger(SOANAFileLoader.class);

  private final Clock clock;
  private final CSVFormat csvFormat;
  private final ExecutorService threadPool;
  private final FlowOrchestrator flowOrchestrator;
  private final Timer timer;

  public SOANAFileLoader(
      Clock clock, Timer timer, ExecutorService threadPool, FlowOrchestrator flowOrchestrator) {
    this.clock = requireNonNull(clock, "clock is required and missing.");
    this.timer = requireNonNull(timer, "timer is required and missing.");
    this.threadPool = requireNonNull(threadPool, "threadPool is required and missing.");
    this.flowOrchestrator =
        requireNonNull(flowOrchestrator, "flowOrchestrator is required and missing.");

    String csvHeader =
        "BBL,Mail_Sequence,Mail_Recipient_Type,Borough,Block,Lot,Easement,Tax_Class,Building_Class,Owner_Name_1,Owner_Name_2,Prop_Housenum,Prop_Street,Prop_Unit,Prop_City,Prop_State,Prop_Zip,Prop_Chg_Date,Mortgage_Service_Co,Govt_Owned,Mail_Recipient_Name,Mail_CareOf,Mail_Address_1,Mail_Address_2,Mail_City,Mail_State,Mail_Zip,Mail_Country,Mail_Country_CD,Recip_Chg_Date,Mail_Chg_Date,Own_Chg_Date,Own2_Chg_Date,Phone,Email,USPS_Verified,Returned_Mail,USPS_Address";

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
              Instant recordStartTime = clock.instant();

              lineCounter.getAndIncrement();
              SoanaFeedData soanaFeedData = new SoanaFeedData();

              try {

                soanaFeedData.setBBL(parseIntoString(record, "BBL"));
                soanaFeedData.setMail_Sequence(parseIntoString(record, "Mail_Sequence"));
                soanaFeedData.setMail_Recipient_Type(
                    parseIntoString(record, "Mail_Recipient_Type"));
                soanaFeedData.setBorough(parseIntoString(record, "Borough"));
                soanaFeedData.setBlock(parseIntoString(record, "Block"));
                soanaFeedData.setLot(parseIntoString(record, "Lot"));
                soanaFeedData.setEasement(parseIntoString(record, "Easement"));
                soanaFeedData.setTax_Class(parseIntoString(record, "Tax_Class"));
                soanaFeedData.setBuilding_Class(parseIntoString(record, "Building_Class"));
                soanaFeedData.setOwner_Name_1(parseIntoString(record, "Owner_Name_1"));
                soanaFeedData.setOwner_Name_2(parseIntoString(record, "Owner_Name_2"));
                soanaFeedData.setProp_Housenum(parseIntoString(record, "Prop_Housenum"));
                soanaFeedData.setProp_Street(parseIntoString(record, "Prop_Street"));
                soanaFeedData.setProp_Unit(parseIntoString(record, "Prop_Unit"));
                soanaFeedData.setProp_City(parseIntoString(record, "Prop_City"));
                soanaFeedData.setProp_State(parseIntoString(record, "Prop_State"));
                soanaFeedData.setProp_Zip(parseIntoString(record, "Prop_Zip"));
                soanaFeedData.setProp_Chg_Date(parseIntoString(record, "Prop_Chg_Date"));
                soanaFeedData.setMortgage_Service_Co(
                    parseIntoString(record, "Mortgage_Service_Co"));
                soanaFeedData.setGovt_Owned(parseIntoString(record, "Govt_Owned"));
                soanaFeedData.setMail_Recipient_Name(
                    parseIntoString(record, "Mail_Recipient_Name"));
                soanaFeedData.setMail_CareOf(parseIntoString(record, "Mail_CareOf"));
                soanaFeedData.setMail_Address_1(parseIntoString(record, "Mail_Address_1"));
                soanaFeedData.setMail_Address_2(parseIntoString(record, "Mail_Address_2"));
                soanaFeedData.setMail_City(parseIntoString(record, "Mail_City"));
                soanaFeedData.setMail_State(parseIntoString(record, "Mail_State"));
                soanaFeedData.setMail_Zip(parseIntoString(record, "Mail_Zip"));
                soanaFeedData.setMail_Country(parseIntoString(record, "Mail_Country"));
                soanaFeedData.setMail_Country_CD(parseIntoString(record, "Mail_Country_CD"));
                soanaFeedData.setRecip_Chg_Date(parseIntoString(record, "Recip_Chg_Date"));
                soanaFeedData.setMail_Chg_Date(parseIntoString(record, "Mail_Chg_Date"));
                soanaFeedData.setOwn_Chg_Date(parseIntoString(record, "Own_Chg_Date"));
                soanaFeedData.setOwn2_Chg_Date(parseIntoString(record, "Own2_Chg_Date"));
                soanaFeedData.setPhone(parseIntoString(record, "Phone"));
                soanaFeedData.setEmail(parseIntoString(record, "Email"));
                soanaFeedData.setUSPS_Verified(parseIntoString(record, "USPS_Verified"));
                soanaFeedData.setReturned_Mail(parseIntoString(record, "Returned_Mail"));
                soanaFeedData.setUSPS_Address(parseIntoString(record, "USPS_Address"));

                flowOrchestrator.loadSoanaData(soanaFeedData);

              } catch (Exception excp) {
                errorCounter.getAndIncrement();
                LOG.error(
                    "Exception while processing BBL:{}:{}",
                    soanaFeedData.getBBL(),
                    excp.getMessage());
              }

              timer.record(Duration.between(recordStartTime, clock.instant()));
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
}
