package edu.nyu.sdg.penalties.dao.postgres.impl;

import static java.util.Objects.requireNonNull;

import edu.nyu.sdg.penalties.dao.contract.SDGDataInsertDAO;
import edu.nyu.sdg.penalties.dao.postgres.sql.LoadSql;
import edu.nyu.sdg.penalties.model.*;
import org.springframework.jdbc.core.JdbcTemplate;

public final class SDGDataInsertPostgresImpl implements SDGDataInsertDAO {

  private final JdbcTemplate template;

  public SDGDataInsertPostgresImpl(JdbcTemplate template) {
    this.template = template;
  }

  @Override
  public void writePenaltyInfo(LL84FeedData ll84FeedData, DerivedVariables derivedVariables) {
    requireNonNull(ll84FeedData, "ll84Data is required and missing.");
    requireNonNull(derivedVariables, "derivedVariables is required and missing.");

    template.update(
      LoadSql.PUT_DERIVED_VARS_DATA,
      ll84FeedData.getBBL10Digits(),
      ll84FeedData.getNYCBIN(),
      derivedVariables.getCarbonLimits().getCarbonLimitPhase1(),
      derivedVariables.getCarbonLimits().getCarbonLimitPhase2(),
      derivedVariables.getTotalActualEmissions(),
      derivedVariables.getExcessEmissionPhase1(),
      derivedVariables.getExcessEmissionPhase2(),
      derivedVariables.getPenalties().getPhase1PenaltiesUSD(),
      derivedVariables.getPenalties().getPhase2PenaltiesUSD(),
      derivedVariables.getPenalties().getPhase1Penalties(),
      derivedVariables.getPenalties().getPhase2Penalties()
    );
  }

  @Override
  public void writeLL84Data(LL84FeedData ll84FeedData) {
    requireNonNull(ll84FeedData, "ll84Data is required and missing.");

    template.update(
      LoadSql.PUT_FEED_LL84_DATA,
      ll84FeedData.getBBL10Digits(),
      ll84FeedData.getNYCBIN(),
      ll84FeedData.getPropertyId(),
      ll84FeedData.getPropertyName(),
      ll84FeedData.getCityBuilding(),
      ll84FeedData.getEmail(),
      ll84FeedData.getAddress1SelfReported(),
      ll84FeedData.getAddress2SelfReported(),
      ll84FeedData.getPostalCode(),
      ll84FeedData.getBorough(),
      ll84FeedData.getDofGrossFloorArea(),
      ll84FeedData.getSelfReportedGrossFloorArea(),
      ll84FeedData.getListOfAllPropertyUseTypes(),
      ll84FeedData.getLargestPropertyUseType(),
      ll84FeedData.getLargestPropertyUseTypeGrossFloorArea(),
      ll84FeedData.getSecondLargestPropertyUseType(),
      ll84FeedData.getSecondLargestPropertyUseTypeGrossFloorArea(),
      ll84FeedData.getThirdLargestPropertyUseType(),
      ll84FeedData.getThirdLargestPropertyUseTypeGrossFloorArea(),
      ll84FeedData.getYearBuilt(),
      ll84FeedData.getNumberOfBuildings(),
      ll84FeedData.getOccupancy(),
      ll84FeedData.getGenerationDate(),
      ll84FeedData.getLatitude(),
      ll84FeedData.getLongitude(),
      ll84FeedData.getCommunityBoard(),
      ll84FeedData.getCouncilDistrict(),
      ll84FeedData.getCensusTract(),
      ll84FeedData.getNta(),
      ll84FeedData.getFuelOil1Use(),
      ll84FeedData.getFuelOil2Use(),
      ll84FeedData.getFuelOil4Use(),
      ll84FeedData.getFuelOil5_6Use(),
      ll84FeedData.getDiesel2Use(),
      ll84FeedData.getPropaneUse(),
      ll84FeedData.getDistrictSteamUse(),
      ll84FeedData.getDistrictChilledWaterUse(),
      ll84FeedData.getNaturalGasUsekBTU(),
      ll84FeedData.getElectricityGridPurchasekWh(),
      ll84FeedData.getTotalGHGEmissions(),
      ll84FeedData.getEnergyStarScore(),
      ll84FeedData.getSiteEUI()
    );
  }

  @Override
  public void writeAcrisData(LL84FeedData ll84FeedData) {
    requireNonNull(ll84FeedData, "ll84Data is required and missing.");

    ll84FeedData
      .getAcrisEntries()
      .forEach(
        entry ->
          template.update(
            LoadSql.PUT_FEED_ACRIS_DATA,
            entry.getBBL10Digits(),
            entry.getDocumentId(),
            entry.getDocumentType(),
            entry.getDocumentAmount(),
            entry.getDocumentRecordedTimestamp(),
            entry.getPartyType(),
            entry.getName(),
            entry.getAddress1(),
            entry.getZipCode())
      );
  }

  @Override
  public void writeNYCHAData(NYCHAFeedData nychaFeedData) {
    requireNonNull(nychaFeedData, "nychaFeedData is required and missing.");

    template.update(
      LoadSql.PUT_FEED_NYCHA_DATA,
      nychaFeedData.getBBL(),
      nychaFeedData.getDevelopment()
    );
  }

  @Override
  public void writeRentStabilizedUnitsData(RentStabilizedBBLFeedData rentStabilizedBBLFeedData) {
    requireNonNull(rentStabilizedBBLFeedData, "rentStabilizedBBLFeedData is required and missing.");

    template.update(
      LoadSql.PUT_FEED_RENT_STABILIZED_UNITS_DATA,
      rentStabilizedBBLFeedData.getBBL(),
      rentStabilizedBBLFeedData.getMpVersion(),
      rentStabilizedBBLFeedData.getMpResidentialUnits(),
      rentStabilizedBBLFeedData.getStabilizedUnits2018(),
      rentStabilizedBBLFeedData.getStabilizedUnits2019(),
      rentStabilizedBBLFeedData.getStabilizedUnitPercentage()
    );
  }

  @Override
  public void writeSoanaData(SoanaFeedData soanaFeedData) {
    requireNonNull(soanaFeedData,"soanaFeedData is required and missing.");

    template.update(
      LoadSql.PUT_FEED_SOANA_DATA,
      soanaFeedData.getBBL(),
      soanaFeedData.getMail_Sequence(),
      soanaFeedData.getMail_Recipient_Type(),
      soanaFeedData.getBorough(),
      soanaFeedData.getBlock(),
      soanaFeedData.getLot(),
      soanaFeedData.getEasement(),
      soanaFeedData.getTax_Class(),
      soanaFeedData.getBuilding_Class(),
      soanaFeedData.getOwner_Name_1(),
      soanaFeedData.getOwner_Name_2(),
      soanaFeedData.getProp_Housenum(),
      soanaFeedData.getProp_Street(),
      soanaFeedData.getProp_Unit(),
      soanaFeedData.getProp_City(),
      soanaFeedData.getProp_State(),
      soanaFeedData.getProp_Zip(),
      soanaFeedData.getProp_Chg_Date(),
      soanaFeedData.getMortgage_Service_Co(),
      soanaFeedData.getGovt_Owned(),
      soanaFeedData.getMail_Recipient_Name(),
      soanaFeedData.getMail_CareOf(),
      soanaFeedData.getMail_Address_1(),
      soanaFeedData.getMail_Address_2(),
      soanaFeedData.getMail_City(),
      soanaFeedData.getMail_State(),
      soanaFeedData.getMail_Zip(),
      soanaFeedData.getMail_Country(),
      soanaFeedData.getMail_Country_CD(),
      soanaFeedData.getRecip_Chg_Date(),
      soanaFeedData.getMail_Chg_Date(),
      soanaFeedData.getOwn_Chg_Date(),
      soanaFeedData.getOwn2_Chg_Date(),
      soanaFeedData.getPhone(),
      soanaFeedData.getEmail(),
      soanaFeedData.getUSPS_Verified(),
      soanaFeedData.getReturned_Mail(),
      soanaFeedData.getUSPS_Address()
    );
  }
}
