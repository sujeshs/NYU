package edu.nyu.sdg.penalties.inputstream.file;

import edu.nyu.sdg.penalties.controller.FlowOrchestrator;
import edu.nyu.sdg.penalties.model.LL84Data;
import edu.nyu.sdg.penalties.model.Penalties;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.validator.routines.BigDecimalValidator;
import org.apache.commons.validator.routines.DateValidator;

import java.io.File;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.google.common.base.Charsets.UTF_8;
import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkState;
import static java.util.Objects.requireNonNull;
import static org.apache.commons.lang3.StringUtils.isNotBlank;
import static org.apache.commons.lang3.StringUtils.isNotEmpty;
import static org.apache.commons.lang3.StringUtils.trim;

public final class CSVFileLoader {

  private final FlowOrchestrator flowOrchestrator;

  private static CSVFormat csvFormat;
  private static final BigDecimalValidator BIGDECIMAL_VALIDATOR = new BigDecimalValidator();
  private static final DateValidator DATE_VALIDATOR = new DateValidator();

  private static final String DATE_PATTERN = "MM/dd/yy";

  public CSVFileLoader(FlowOrchestrator flowOrchestrator) {
    this.flowOrchestrator = requireNonNull(flowOrchestrator, "flowOrchestrator is required and missing.");

    String csvHeader =
      ",Order,Property Id,Property Name,Parent Property Id,Parent Property Name,City Building,Email,BBL - 10 digits,NYC Borough Block and Lot (BBL) self-reported,NYC Building Identification Number (BIN),Address 1 (self-reported),Address 2 (self reported),Postal Code,Street Number,Street Name,Borough,DOF Gross Floor Area (ft¬≤),Self-Reported Gross Floor Area (ft¬≤),Primary Property Type - Self Selected,List of All Property Use Types at Property,Largest Property Use Type,Largest Property Use Type - Gross Floor Area (ft¬≤),2nd Largest Property Use Type,2nd Largest Property Use - Gross Floor Area (ft¬≤),3rd Largest Property Use Type,3rd Largest Property Use Type - Gross Floor Area (ft¬≤),Year Built,Number of Buildings,Occupancy,Metered Areas (Energy),Metered Areas (Water),ENERGY STAR Score,Source EUI (kBtu/ft¬≤),Weather Normalized Site EUI (kBtu/ft¬≤),Site EUI (kBtu/ft¬≤),Weather Normalized Source EUI (kBtu/ft¬≤),Weather Normalized Site Electricity Intensity (kWh/ft¬≤),Weather Normalized Site Natural Gas Intensity (therms/ft¬≤),Fuel Oil #1 Use (kBtu),Fuel Oil #2 Use (kBtu),Fuel Oil #4 Use (kBtu),Fuel Oil #5 & 6 Use (kBtu),Diesel #2 Use (kBtu),Kerosene Use (kBtu),Propane Use (kBtu),District Steam Use (kBtu),District Hot Water Use (kBtu),District Chilled Water Use (kBtu),Natural Gas Use (kBtu),Natural Gas Use (therms),Weather Normalized Site Natural Gas Use (therms),Electricity Use - Grid Purchase (kBtu),Electricity Use - Grid Purchase (kWh),Weather Normalized Site Electricity (kWh),Annual Maximum Demand (kW),Annual Maximum Demand (MM/YYYY),Annual Maximum Demand (Meter Name (Meter ID)),Total GHG Emissions (Metric Tons CO2e),Direct GHG Emissions (Metric Tons CO2e),Indirect GHG Emissions (Metric Tons CO2e),Water Use (All Water Sources) (kgal),Water Use Intensity (All Water Sources) (gal/ft¬≤),Water Required,Generation Date,Latitude,Longitude,Community Board,Council District,Census Tract,NTA";

    csvFormat = CSVFormat.RFC4180.withHeader(csvHeader.split(",")).withSkipHeaderRecord();
  }


  public void loadCSV(String sourceFile) throws Exception {
    checkArgument(isNotBlank(sourceFile), "sourceFile is required and missing.");

    File csvDataFile = new File(sourceFile);
    CSVParser csvParser = CSVParser.parse(csvDataFile, UTF_8, csvFormat);
    csvParser.getHeaderMap();

    for (CSVRecord record : csvParser) {
      if (null != record) {

        LL84Data ll84Data = new LL84Data();

        try {

          ll84Data.setOrder(parseIntoInt(record, "Order"));
          ll84Data.setPropertyId(parseIntoInt(record, "Property Id"));
          ll84Data.setPropertyName(parseIntoString(record, "Property Name"));
          ll84Data.setParentPropertyId(parseIntoString(record, "Parent Property Id"));
          ll84Data.setParentPropertyName(parseIntoString(record, "Parent Property Name"));
          ll84Data.setCityBuilding(parseIntoString(record, "City Building"));
          ll84Data.setEmail(parseIntoString(record, "Email"));
          ll84Data.setBBL10Digits(parseIntoString(record, "BBL - 10 digits"));
          ll84Data.setNYCBBLSelfReported(
            parseIntoString(record, "NYC Borough Block and Lot (BBL) self-reported"));
          ll84Data.setNYCBIN(parseIntoString(record, "NYC Building Identification Number (BIN)"));
          ll84Data.setAddress1SelfReported(parseIntoString(record, "Address 1 (self-reported)"));
          ll84Data.setAddress2SelfReported(parseIntoString(record, "Address 2 (self reported)"));
          ll84Data.setPostalCode(parseIntoInt(record, "Postal Code"));
          ll84Data.setStreetNumber(parseIntoInt(record, "Street Number"));
          ll84Data.setStreetName(parseIntoString(record, "Street Name"));
          ll84Data.setBorough(parseIntoString(record, "Borough"));
          ll84Data.setDofGrossFloorArea(parseIntoBigDecimal(record, "DOF Gross Floor Area (ft¬≤)"));
          ll84Data.setSelfReportedGrossFloorArea(parseIntoBigDecimal(record, "Self-Reported Gross Floor Area (ft¬≤)"));
          ll84Data.setPrimaryPropertyTypeSelfSelected(parseIntoString(record, "Primary Property Type - Self Selected"));
          ll84Data.setListOfAllPropertyUseTypes(parseIntoString(record, "List of All Property Use Types at Property"));
          ll84Data.setLargestPropertyUseType(parseIntoString(record, "Largest Property Use Type"));
          ll84Data.setLargestPropertyUseTypeGrossFloorArea(parseIntoBigDecimal(record, "Largest Property Use Type - Gross Floor Area (ft¬≤)"));
          ll84Data.setSecondLargestPropertyUseType(parseIntoString(record, "2nd Largest Property Use Type"));
          ll84Data.setSecondLargestPropertyUseTypeGrossFloorArea(parseIntoBigDecimal(record, "2nd Largest Property Use - Gross Floor Area (ft¬≤)"));
          ll84Data.setThirdLargestPropertyUseType(parseIntoString(record, "3rd Largest Property Use Type"));
          ll84Data.setThirdLargestPropertyUseTypeGrossFloorArea(parseIntoBigDecimal(record, "3rd Largest Property Use Type - Gross Floor Area (ft¬≤)"));
          ll84Data.setYearBuilt(parseIntoInt(record, "Year Built"));
          ll84Data.setNumberOfBuildings(parseIntoInt(record, "Number of Buildings"));
          ll84Data.setOccupancy(parseIntoInt(record, "Occupancy"));
          ll84Data.setEnergyMeteredAreas(parseIntoString(record, "Metered Areas (Energy)"));
          ll84Data.setWaterMeteredAreas(parseIntoString(record, "Metered Areas (Water)"));
          ll84Data.setEnergyStarScore(parseIntoInt(record, "ENERGY STAR Score"));
          ll84Data.setSourceEUI(parseIntoBigDecimal(record, "Source EUI (kBtu/ft¬≤)"));
          ll84Data.setWeatherNormalizedSiteEUI(parseIntoBigDecimal(record, "Weather Normalized Site EUI (kBtu/ft¬≤)"));
          ll84Data.setSiteEUI(parseIntoBigDecimal(record, "Site EUI (kBtu/ft¬≤)"));
          ll84Data.setWeatherNormalizedSourceEUI(parseIntoBigDecimal(record, "Weather Normalized Source EUI (kBtu/ft¬≤)"));
          ll84Data.setWeatherNormalizedSiteElectricity(parseIntoBigDecimal(record, "Weather Normalized Site Electricity Intensity (kWh/ft¬≤)"));
          ll84Data.setWeatherNormalizedNaturalGasIntensity(parseIntoBigDecimal(record, "Weather Normalized Site Natural Gas Intensity (therms/ft¬≤)"));
          ll84Data.setFuelOil1Use(parseIntoBigDecimal(record, "Fuel Oil #1 Use (kBtu)"));
          ll84Data.setFuelOil2Use(parseIntoBigDecimal(record, "Fuel Oil #2 Use (kBtu)"));
          ll84Data.setFuelOil4Use(parseIntoBigDecimal(record, "Fuel Oil #4 Use (kBtu)"));
          ll84Data.setFuelOil5_6Use(parseIntoBigDecimal(record, "Fuel Oil #5 & 6 Use (kBtu)"));
          ll84Data.setDiesel2Use(parseIntoBigDecimal(record, "Diesel #2 Use (kBtu)"));
          ll84Data.setKeroseneUse(parseIntoBigDecimal(record, "Kerosene Use (kBtu)"));
          ll84Data.setPropaneUse(parseIntoBigDecimal(record, "Propane Use (kBtu)"));
          ll84Data.setDistrictSteamUse(parseIntoBigDecimal(record, "District Steam Use (kBtu)"));
          ll84Data.setDistrictHotWaterUse(parseIntoBigDecimal(record, "District Hot Water Use (kBtu)"));
          ll84Data.setDistrictChilledWaterUse(parseIntoBigDecimal(record, "District Chilled Water Use (kBtu)"));
          ll84Data.setNaturalGasUsekBTU(parseIntoBigDecimal(record, "Natural Gas Use (kBtu)"));
          ll84Data.setNaturalGasUseTherms(parseIntoBigDecimal(record, "Natural Gas Use (therms)"));
          ll84Data.setWeatherNormalizedSiteNaturalGasUseTherms(parseIntoBigDecimal(record, "Weather Normalized Site Natural Gas Use (therms)"));
          ll84Data.setElectricityGridPurchasekBTU(parseIntoBigDecimal(record, "Electricity Use - Grid Purchase (kBtu)"));
          ll84Data.setElectricityGridPurchasekWh(parseIntoBigDecimal(record, "Electricity Use - Grid Purchase (kWh)"));
          ll84Data.setWeatherNormalizedSiteElectricity(parseIntoBigDecimal(record, "Weather Normalized Site Electricity (kWh)"));
          ll84Data.setAnnualMaximumDemandkW(parseIntoBigDecimal(record, "Annual Maximum Demand (kW)"));
          ll84Data.setAnnualMaximumDemandDate(parseIntoDate(record, "Annual Maximum Demand (MM/YYYY)"));
          ll84Data.setAnnualMaximumDemandMeterIDName(parseIntoString(record, "Annual Maximum Demand (Meter Name (Meter ID))"));
          ll84Data.setTotalGHGEmissions(parseIntoBigDecimal(record, "Total GHG Emissions (Metric Tons CO2e)"));
          ll84Data.setDirectGHGEmissions(parseIntoBigDecimal(record, "Direct GHG Emissions (Metric Tons CO2e)"));
          ll84Data.setIndirectGHGEmissions(parseIntoBigDecimal(record, "Indirect GHG Emissions (Metric Tons CO2e)"));
          ll84Data.setWaterUseAllSources(parseIntoBigDecimal(record, "Water Use (All Water Sources) (kgal)"));
          ll84Data.setWaterUseINtensityAllSources(parseIntoBigDecimal(record, "Water Use Intensity (All Water Sources) (gal/ft¬≤)"));
          ll84Data.setWaterRequired(parseIntoString(record, "Water Required"));
          ll84Data.setGenerationDate(parseIntoDate(record, "Generation Date"));
          ll84Data.setLatitude(parseIntoBigDecimal(record, "Latitude"));
          ll84Data.setLongitude(parseIntoBigDecimal(record, "Longitude"));

          flowOrchestrator.calculatePenalties(ll84Data);

        } catch (Exception excp) {
          System.err.println("Exception while processing BBL:" + ll84Data.getBBL10Digits() + " msg:" + excp);
        }

      }
    }
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


}
