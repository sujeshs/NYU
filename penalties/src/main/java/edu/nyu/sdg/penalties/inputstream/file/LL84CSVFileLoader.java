package edu.nyu.sdg.penalties.inputstream.file;

import static com.google.common.base.Charsets.UTF_8;
import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkState;
import static java.util.Objects.requireNonNull;
import static org.apache.commons.lang3.StringUtils.isNotBlank;
import static org.apache.commons.lang3.StringUtils.isNotEmpty;
import static org.apache.commons.lang3.StringUtils.trim;

import com.google.common.collect.ImmutableList;
import edu.nyu.sdg.penalties.CSVConstants;
import edu.nyu.sdg.penalties.controller.FlowOrchestrator;
import edu.nyu.sdg.penalties.model.AcrisEntry;
import edu.nyu.sdg.penalties.model.LL84FeedData;
import java.io.File;
import java.math.BigDecimal;
import java.text.ParseException;
import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.validator.routines.BigDecimalValidator;
import org.apache.commons.validator.routines.DateValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class LL84CSVFileLoader {

  private static final Logger LOG = LoggerFactory.getLogger(LL84CSVFileLoader.class);

  private final Clock clock;
  private final CSVFormat csvFormat;
  private final ExecutorService threadPool;
  private final FlowOrchestrator flowOrchestrator;

  private static final BigDecimalValidator BIGDECIMAL_VALIDATOR = new BigDecimalValidator();
  private static final DateValidator DATE_VALIDATOR = new DateValidator();

  private static final String DATE_PATTERN = "MM/dd/yy";
  private static final String DATE_GENERATION_PATTERN = "MM/dd/yy";
  private static final String DATE_ACRIS_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSS";

  public LL84CSVFileLoader(
      Clock clock, ExecutorService threadPool, FlowOrchestrator flowOrchestrator) {
    this.clock = requireNonNull(clock, "clock is required and missing.");
    this.threadPool = requireNonNull(threadPool, "threadPool is required and missing.");
    this.flowOrchestrator =
        requireNonNull(flowOrchestrator, "flowOrchestrator is required and missing.");

    csvFormat = CSVFormat.RFC4180.withHeader(CSVConstants.LAYOUT_LL84.split(",")).withSkipHeaderRecord();
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
              lineCounter.getAndIncrement();
              LL84FeedData ll84FeedData = new LL84FeedData();

              try {

                ll84FeedData.setOrder(parseIntoInt(record, "Order"));
                ll84FeedData.setPropertyId(parseIntoString(record, "Property Id"));
                ll84FeedData.setPropertyName(parseIntoString(record, "Property Name"));
                ll84FeedData.setParentPropertyId(parseIntoString(record, "Parent Property Id"));
                ll84FeedData.setParentPropertyName(parseIntoString(record, "Parent Property Name"));
                ll84FeedData.setCityBuilding(parseIntoString(record, "City Building"));
                ll84FeedData.setEmail(parseIntoString(record, "Email"));
                ll84FeedData.setBBL10Digits(parseIntoString(record, "BBL - 10 digits"));
                ll84FeedData.setNYCBBLSelfReported(
                    parseIntoString(record, "NYC Borough Block and Lot (BBL) self-reported"));
                ll84FeedData.setNYCBIN(
                    parseIntoString(record, "NYC Building Identification Number (BIN)"));
                ll84FeedData.setAddress1SelfReported(
                    parseIntoString(record, "Address 1 (self-reported)"));
                ll84FeedData.setAddress2SelfReported(
                    parseIntoString(record, "Address 2 (self reported)"));
                ll84FeedData.setPostalCode(parseIntoInt(record, "Postal Code"));
                ll84FeedData.setStreetNumber(parseIntoString(record, "Street Number"));
                ll84FeedData.setStreetName(parseIntoString(record, "Street Name"));
                ll84FeedData.setBorough(parseIntoString(record, "Borough"));
                ll84FeedData.setDofGrossFloorArea(
                    parseIntoBigDecimal(record, "DOF Gross Floor Area (ft¬≤)"));
                ll84FeedData.setSelfReportedGrossFloorArea(
                    parseIntoBigDecimal(record, "Self-Reported Gross Floor Area (ft¬≤)"));
                ll84FeedData.setPrimaryPropertyTypeSelfSelected(
                    parseIntoString(record, "Primary Property Type - Self Selected"));
                ll84FeedData.setListOfAllPropertyUseTypes(
                    parseIntoString(record, "List of All Property Use Types at Property"));
                ll84FeedData.setLargestPropertyUseType(
                    parseIntoString(record, "Largest Property Use Type"));
                ll84FeedData.setLargestPropertyUseTypeGrossFloorArea(
                    parseIntoBigDecimal(
                        record, "Largest Property Use Type - Gross Floor Area (ft¬≤)"));
                ll84FeedData.setSecondLargestPropertyUseType(
                    parseIntoString(record, "2nd Largest Property Use Type"));
                ll84FeedData.setSecondLargestPropertyUseTypeGrossFloorArea(
                    parseIntoBigDecimal(
                        record, "2nd Largest Property Use - Gross Floor Area (ft¬≤)"));
                ll84FeedData.setThirdLargestPropertyUseType(
                    parseIntoString(record, "3rd Largest Property Use Type"));
                ll84FeedData.setThirdLargestPropertyUseTypeGrossFloorArea(
                    parseIntoBigDecimal(
                        record, "3rd Largest Property Use Type - Gross Floor Area (ft¬≤)"));
                ll84FeedData.setYearBuilt(parseIntoInt(record, "Year Built"));
                ll84FeedData.setNumberOfBuildings(parseIntoInt(record, "Number of Buildings"));
                ll84FeedData.setOccupancy(parseIntoInt(record, "Occupancy"));
                ll84FeedData.setEnergyMeteredAreas(
                    parseIntoString(record, "Metered Areas (Energy)"));
                ll84FeedData.setWaterMeteredAreas(parseIntoString(record, "Metered Areas (Water)"));
                ll84FeedData.setEnergyStarScore(parseIntoInt(record, "ENERGY STAR Score"));
                ll84FeedData.setSourceEUI(parseIntoBigDecimal(record, "Source EUI (kBtu/ft¬≤)"));
                ll84FeedData.setWeatherNormalizedSiteEUI(
                    parseIntoBigDecimal(record, "Weather Normalized Site EUI (kBtu/ft¬≤)"));
                ll84FeedData.setSiteEUI(parseIntoBigDecimal(record, "Site EUI (kBtu/ft¬≤)"));
                ll84FeedData.setWeatherNormalizedSourceEUI(
                    parseIntoBigDecimal(record, "Weather Normalized Source EUI (kBtu/ft¬≤)"));
                ll84FeedData.setWeatherNormalizedSiteElectricity(
                    parseIntoBigDecimal(
                        record, "Weather Normalized Site Electricity Intensity (kWh/ft¬≤)"));
                ll84FeedData.setWeatherNormalizedNaturalGasIntensity(
                    parseIntoBigDecimal(
                        record, "Weather Normalized Site Natural Gas Intensity (therms/ft¬≤)"));
                ll84FeedData.setFuelOil1Use(parseIntoBigDecimal(record, "Fuel Oil #1 Use (kBtu)"));
                ll84FeedData.setFuelOil2Use(parseIntoBigDecimal(record, "Fuel Oil #2 Use (kBtu)"));
                ll84FeedData.setFuelOil4Use(parseIntoBigDecimal(record, "Fuel Oil #4 Use (kBtu)"));
                ll84FeedData.setFuelOil5_6Use(
                    parseIntoBigDecimal(record, "Fuel Oil #5 & 6 Use (kBtu)"));
                ll84FeedData.setDiesel2Use(parseIntoBigDecimal(record, "Diesel #2 Use (kBtu)"));
                ll84FeedData.setKeroseneUse(parseIntoBigDecimal(record, "Kerosene Use (kBtu)"));
                ll84FeedData.setPropaneUse(parseIntoBigDecimal(record, "Propane Use (kBtu)"));
                ll84FeedData.setDistrictSteamUse(
                    parseIntoBigDecimal(record, "District Steam Use (kBtu)"));
                ll84FeedData.setDistrictHotWaterUse(
                    parseIntoBigDecimal(record, "District Hot Water Use (kBtu)"));
                ll84FeedData.setDistrictChilledWaterUse(
                    parseIntoBigDecimal(record, "District Chilled Water Use (kBtu)"));
                ll84FeedData.setNaturalGasUsekBTU(
                    parseIntoBigDecimal(record, "Natural Gas Use (kBtu)"));
                ll84FeedData.setNaturalGasUseTherms(
                    parseIntoBigDecimal(record, "Natural Gas Use (therms)"));
                ll84FeedData.setWeatherNormalizedSiteNaturalGasUseTherms(
                    parseIntoBigDecimal(
                        record, "Weather Normalized Site Natural Gas Use (therms)"));
                ll84FeedData.setElectricityGridPurchasekBTU(
                    parseIntoBigDecimal(record, "Electricity Use - Grid Purchase (kBtu)"));
                ll84FeedData.setElectricityGridPurchasekWh(
                    parseIntoBigDecimal(record, "Electricity Use - Grid Purchase (kWh)"));
                ll84FeedData.setWeatherNormalizedSiteElectricity(
                    parseIntoBigDecimal(record, "Weather Normalized Site Electricity (kWh)"));
                ll84FeedData.setAnnualMaximumDemandkW(
                    parseIntoBigDecimal(record, "Annual Maximum Demand (kW)"));
                ll84FeedData.setAnnualMaximumDemandDate(
                    parseIntoDate(record, "Annual Maximum Demand (MM/YYYY)"));
                ll84FeedData.setAnnualMaximumDemandMeterIDName(
                    parseIntoString(record, "Annual Maximum Demand (Meter Name (Meter ID))"));
                ll84FeedData.setTotalGHGEmissions(
                    parseIntoBigDecimal(record, "Total GHG Emissions (Metric Tons CO2e)"));
                ll84FeedData.setDirectGHGEmissions(
                    parseIntoBigDecimal(record, "Direct GHG Emissions (Metric Tons CO2e)"));
                ll84FeedData.setIndirectGHGEmissions(
                    parseIntoBigDecimal(record, "Indirect GHG Emissions (Metric Tons CO2e)"));
                ll84FeedData.setWaterUseAllSources(
                    parseIntoBigDecimal(record, "Water Use (All Water Sources) (kgal)"));
                ll84FeedData.setWaterUseIntensityAllSources(
                    parseIntoBigDecimal(
                        record, "Water Use Intensity (All Water Sources) (gal/ft¬≤)"));
                ll84FeedData.setWaterRequired(parseIntoString(record, "Water Required"));
                ll84FeedData.setGenerationDate(parseGenerationDate(record, "Generation Date"));
                ll84FeedData.setLatitude(parseIntoBigDecimal(record, "Latitude"));
                ll84FeedData.setLongitude(parseIntoBigDecimal(record, "Longitude"));
                ll84FeedData.setCommunityBoard(parseIntoString(record, "Community Board"));
                ll84FeedData.setCouncilDistrict(parseIntoString(record, "Council District"));
                ll84FeedData.setCensusTract(parseIntoString(record, "Census Tract"));
                ll84FeedData.setNta(parseIntoString(record, "NTA"));

                ImmutableList.Builder<AcrisEntry> acrisBuilder =
                    new ImmutableList.Builder<AcrisEntry>();
                acrisBuilder.add(constructAcrisEntry(record, 1));
                acrisBuilder.add(constructAcrisEntry(record, 2));
                acrisBuilder.add(constructAcrisEntry(record, 3));
                acrisBuilder.add(constructAcrisEntry(record, 4));
                acrisBuilder.add(constructAcrisEntry(record, 5));
                acrisBuilder.add(constructAcrisEntry(record, 6));
                acrisBuilder.add(constructAcrisEntry(record, 7));
                acrisBuilder.add(constructAcrisEntry(record, 8));
                acrisBuilder.add(constructAcrisEntry(record, 9));
                acrisBuilder.add(constructAcrisEntry(record, 10));

                ll84FeedData.setAcrisEntries(acrisBuilder.build());

                flowOrchestrator.loadLL84AndAcrisData(ll84FeedData);

              } catch (Exception excp) {
                errorCounter.getAndIncrement();
                LOG.error(
                    "Exception while processing BBL:{}:{}",
                    ll84FeedData.getBBL10Digits(),
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

  private AcrisEntry constructAcrisEntry(CSVRecord record, int iteration) throws ParseException {

    return new AcrisEntry(
        parseIntoString(record, "BBL - 10 digits"),
        parseIntoString(record, iteration + " document_id"),
        parseIntoString(record, iteration + " doc_type"),
        parseIntoBigDecimal(record, iteration + " document_amt"),
        parseAcrisDate(record, iteration + " recorded_datetime"),
        iteration <= 5 ? "1" : "2",
        parseIntoString(record, iteration + " name"),
        parseIntoString(record, iteration + " address_1"),
        parseIntoString(record, iteration + " zip"));
  }

  private static BigDecimal parseIntoBigDecimal(CSVRecord record, String columnName) {
    requireNonNull(record, "record is required and missing.");
    checkState(isNotEmpty(columnName), "columnName is required and missing.");

    String data = trim(record.get(columnName));
    return BIGDECIMAL_VALIDATOR.isValid(data) ? new BigDecimal(data) : BigDecimal.ZERO;
  }

  private static int parseIntoInt(CSVRecord record, String columnName) {
    requireNonNull(record, "record is required and missing.");
    checkState(isNotEmpty(columnName), "columnName is required and missing.");

    String data = trim(record.get(columnName));
    return StringUtils.isNumeric(data) ? NumberUtils.createInteger(data) : 0;
  }

  private static String parseIntoString(CSVRecord record, String columnName) {
    requireNonNull(record, "record is required and missing.");
    checkState(isNotEmpty(columnName), "columnName is required and missing.");

    return trim(record.get(columnName));
  }

  private static Date parseIntoDate(CSVRecord record, String columnName) throws ParseException {
    requireNonNull(record, "record is required and missing.");
    checkState(isNotEmpty(columnName), "columnName is required and missing.");

    String data = trim(record.get(columnName));
    return DATE_VALIDATOR.validate(data, DATE_PATTERN);
  }

  private static Date parseGenerationDate(CSVRecord record, String columnName)
      throws ParseException {
    requireNonNull(record, "record is required and missing.");
    checkState(isNotEmpty(columnName), "columnName is required and missing.");

    String data = trim(record.get(columnName));
    return DATE_VALIDATOR.validate(data, DATE_GENERATION_PATTERN);
  }

  private static Date parseAcrisDate(CSVRecord record, String columnName) throws ParseException {
    requireNonNull(record, "record is required and missing.");
    checkState(isNotEmpty(columnName), "columnName is required and missing.");

    String data = trim(record.get(columnName));
    return DATE_VALIDATOR.validate(data, DATE_ACRIS_PATTERN);
  }
}
