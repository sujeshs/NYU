package edu.nyu.sdg.penalties.inputstream.file;

import edu.nyu.sdg.penalties.model.LL84Data;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;

import static com.google.common.base.Charsets.UTF_8;
import static com.google.common.base.Preconditions.checkArgument;
import static org.apache.commons.lang3.StringUtils.isNotBlank;
import static org.apache.commons.lang3.StringUtils.trim;

public final class CSVFileLoader {

  private static CSVFormat csvFormat;

  public static void main(String... args) throws Exception {

    String sourceFile = "/Users/ssuku24/cas/personal/NYU/docs/samples/subset_ll84.csv";
    String csvHeader =
        ",Order,Property Id,Property Name,Parent Property Id,Parent Property Name,City Building,Email,BBL - 10 digits,\"NYC Borough, Block and Lot (BBL) self-reported\",NYC Building Identification Number (BIN),Address 1 (self-reported),Address 2 (self reported),Postal Code,Street Number,Street Name,Borough,DOF Gross Floor Area (ft¬≤),Self-Reported Gross Floor Area (ft¬≤),Primary Property Type - Self Selected,List of All Property Use Types at Property,Largest Property Use Type,Largest Property Use Type - Gross Floor Area (ft¬≤),2nd Largest Property Use Type,2nd Largest Property Use - Gross Floor Area (ft¬≤),3rd Largest Property Use Type,3rd Largest Property Use Type - Gross Floor Area (ft¬≤),Year Built,Number of Buildings,Occupancy,Metered Areas (Energy),Metered Areas (Water),ENERGY STAR Score,Source EUI (kBtu/ft¬≤),Weather Normalized Site EUI (kBtu/ft¬≤),Site EUI (kBtu/ft¬≤),Weather Normalized Source EUI (kBtu/ft¬≤),Weather Normalized Site Electricity Intensity (kWh/ft¬≤),Weather Normalized Site Natural Gas Intensity (therms/ft¬≤),Fuel Oil #1 Use (kBtu),Fuel Oil #2 Use (kBtu),Fuel Oil #4 Use (kBtu),Fuel Oil #5 & 6 Use (kBtu),Diesel #2 Use (kBtu),Kerosene Use (kBtu),Propane Use (kBtu),District Steam Use (kBtu),District Hot Water Use (kBtu),District Chilled Water Use (kBtu),Natural Gas Use (kBtu),Natural Gas Use (therms),Weather Normalized Site Natural Gas Use (therms),Electricity Use - Grid Purchase (kBtu),Electricity Use - Grid Purchase (kWh),Weather Normalized Site Electricity (kWh),Annual Maximum Demand (kW),Annual Maximum Demand (MM/YYYY),Annual Maximum Demand (Meter Name (Meter ID)),Total GHG Emissions (Metric Tons CO2e),Direct GHG Emissions (Metric Tons CO2e),Indirect GHG Emissions (Metric Tons CO2e),Water Use (All Water Sources) (kgal),Water Use Intensity (All Water Sources) (gal/ft¬≤),Water Required,Generation Date,Latitude,Longitude,Community Board,Council District,Census Tract,NTA,Characters in BIN column,# of times is the BIN in the table,Characters in BBL column,# of times is the BBL in the table,# of times Property ID in table,\"Standalone, Parent, Child\",Is the BIN in qct list?,Is the BBL in qct list?,BBL AND BIN in qct list?,\"(1, 'document_id')\",\"(1, 'doc_type')\",\"(1, 'document_amt')\",\"(1, 'recorded_datetime')\",\"(1, 'party_type')\",\"(1, 'name')\",\"(1, 'address_1')\",\"(1, 'zip')\",\"(2, 'document_id')\",\"(2, 'doc_type')\",\"(2, 'document_amt')\",\"(2, 'recorded_datetime')\",\"(2, 'party_type')\",\"(2, 'name')\",\"(2, 'address_1')\",\"(2, 'zip')\",\"(3, 'document_id')\",\"(3, 'doc_type')\",\"(3, 'document_amt')\",\"(3, 'recorded_datetime')\",\"(3, 'party_type')\",\"(3, 'name')\",\"(3, 'address_1')\",\"(3, 'zip')\",\"(4, 'document_id')\",\"(4, 'doc_type')\",\"(4, 'document_amt')\",\"(4, 'recorded_datetime')\",\"(4, 'party_type')\",\"(4, 'name')\",\"(4, 'address_1')\",\"(4, 'zip')\",\"(5, 'document_id')\",\"(5, 'doc_type')\",\"(5, 'document_amt')\",\"(5, 'recorded_datetime')\",\"(5, 'party_type')\",\"(5, 'name')\",\"(5, 'address_1')\",\"(5, 'zip')\",\"(6, 'document_id')\",\"(6, 'doc_type')\",\"(6, 'document_amt')\",\"(6, 'recorded_datetime')\",\"(6, 'party_type')\",\"(6, 'name')\",\"(6, 'address_1')\",\"(6, 'zip')\",\"(7, 'document_id')\",\"(7, 'doc_type')\",\"(7, 'document_amt')\",\"(7, 'recorded_datetime')\",\"(7, 'party_type')\",\"(7, 'name')\",\"(7, 'address_1')\",\"(7, 'zip')\",\"(8, 'document_id')\",\"(8, 'doc_type')\",\"(8, 'document_amt')\",\"(8, 'recorded_datetime')\",\"(8, 'party_type')\",\"(8, 'name')\",\"(8, 'address_1')\",\"(8, 'zip')\",\"(9, 'document_id')\",\"(9, 'doc_type')\",\"(9, 'document_amt')\",\"(9, 'recorded_datetime')\",\"(9, 'party_type')\",\"(9, 'name')\",\"(9, 'address_1')\",\"(9, 'zip')\",\"(10, 'document_id')\",\"(10, 'doc_type')\",\"(10, 'document_amt')\",\"(10, 'recorded_datetime')\",\"(10, 'party_type')\",\"(10, 'name')\",\"(10, 'address_1')\",\"(10, 'zip')\"";

    csvFormat = CSVFormat.RFC4180.withHeader(csvHeader.split(","));

    loadCSV(sourceFile);

  }

  public static void loadCSV(String sourceFile) throws Exception {
    checkArgument(isNotBlank(sourceFile), "sourceFile is required and missing.");

    File csvDataFile = new File(sourceFile);
    CSVParser csvParser = CSVParser.parse(csvDataFile, UTF_8, csvFormat);
    csvParser.getHeaderMap();

    for (CSVRecord record : csvParser) {
      if (null != record) {


        // TODO : finish this impl


      }
    }
  }

}
