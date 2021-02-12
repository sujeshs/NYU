package edu.nyu.sdg.penalties.dao.postgres.impl;

import edu.nyu.sdg.penalties.dao.contract.SDGDataInsertDAO;
import edu.nyu.sdg.penalties.dao.postgres.sql.LoadSql;
import edu.nyu.sdg.penalties.model.DerivedVariables;
import edu.nyu.sdg.penalties.model.LL84Data;
import org.springframework.jdbc.core.JdbcTemplate;

import static java.util.Objects.requireNonNull;

public final class SDGDataInsertPostgresImpl implements SDGDataInsertDAO {

  private final JdbcTemplate template;

  public SDGDataInsertPostgresImpl(JdbcTemplate template) {
    this.template = template;
  }

  @Override
  public void writePenaltyInfo(LL84Data ll84Data, DerivedVariables derivedVariables) {
    requireNonNull(ll84Data, "ll84Data is required and missing.");
    requireNonNull(derivedVariables, "derivedVariables is required and missing.");

    template.update(
        LoadSql.PUT_DERIVED_VARS_DATA,
        ll84Data.getBBL10Digits(),
        ll84Data.getNYCBIN(),
        derivedVariables.getCarbonLimits().getCarbonLimitPhase1(),
        derivedVariables.getCarbonLimits().getCarbonLimitPhase2(),
        derivedVariables.getTotalActualEmissions(),
        derivedVariables.getExcessEmissionPhase1(),
        derivedVariables.getExcessEmissionPhase2(),
        derivedVariables.getPenalties().getPhase1PenaltiesUSD(),
        derivedVariables.getPenalties().getPhase2PenaltiesUSD());
  }

  @Override
  public void writeLL84Data(LL84Data ll84Data) {
    requireNonNull(ll84Data, "ll84Data is required and missing.");

    template.update(LoadSql.PUT_FEED_LL84_DATA,
      ll84Data.getBBL10Digits(),
      ll84Data.getNYCBIN(),
      ll84Data.getPropertyId(),
      ll84Data.getPropertyName(),
      ll84Data.getCityBuilding(),
      ll84Data.getEmail(),
      ll84Data.getAddress1SelfReported(),
      ll84Data.getAddress2SelfReported(),
      ll84Data.getPostalCode(),
      ll84Data.getBorough(),
      ll84Data.getDofGrossFloorArea(),
      ll84Data.getSelfReportedGrossFloorArea(),
      ll84Data.getListOfAllPropertyUseTypes(),
      ll84Data.getLargestPropertyUseType(),
      ll84Data.getLargestPropertyUseTypeGrossFloorArea(),
      ll84Data.getSecondLargestPropertyUseType(),
      ll84Data.getSecondLargestPropertyUseTypeGrossFloorArea(),
      ll84Data.getThirdLargestPropertyUseType(),
      ll84Data.getThirdLargestPropertyUseTypeGrossFloorArea(),
      ll84Data.getYearBuilt(),
      ll84Data.getNumberOfBuildings(),
      ll84Data.getOccupancy(),
      ll84Data.getLatitude(),
      ll84Data.getLongitude(),
      ll84Data.getCommunityBoard(),
      ll84Data.getCouncilDistrict(),
      ll84Data.getCensusTract(),
      ll84Data.getNta(),
      ll84Data.getFuelOil1Use(),
      ll84Data.getFuelOil2Use(),
      ll84Data.getFuelOil4Use(),
      ll84Data.getFuelOil5_6Use(),
      ll84Data.getDiesel2Use(),
      ll84Data.getPropaneUse(),
      ll84Data.getDistrictSteamUse(),
      ll84Data.getDistrictChilledWaterUse(),
      ll84Data.getNaturalGasUsekBTU(),
      ll84Data.getElectricityGridPurchasekWh(),
      ll84Data.getTotalGHGEmissions(),
      ll84Data.getEnergyStarScore(),
      ll84Data.getSiteEUI()
      );

  }


}
