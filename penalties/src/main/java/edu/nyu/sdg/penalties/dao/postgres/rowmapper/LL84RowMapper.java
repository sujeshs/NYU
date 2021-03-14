package edu.nyu.sdg.penalties.dao.postgres.rowmapper;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import edu.nyu.sdg.penalties.AppConstants;
import edu.nyu.sdg.penalties.model.LL84FeedData;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public final class LL84RowMapper
    implements ResultSetExtractor<List<LL84FeedData>> {

  @Override
  public List<LL84FeedData> extractData(ResultSet rs)
      throws SQLException, DataAccessException {

    ImmutableList.Builder builder = new ImmutableList.Builder();

    while (rs.next()) {

      LL84FeedData feedData = new LL84FeedData();
      feedData.setBBL10Digits(rs.getString("bbl"));
      feedData.setNYCBIN(rs.getString("nyc_bin"));
      feedData.setPropertyId(rs.getString("property_id"));
      feedData.setParentPropertyId(rs.getString("parent_property_id"));
      feedData.setDofGrossFloorArea(rs.getBigDecimal("dof_gross_floor_area"));
      feedData.setSelfReportedGrossFloorArea(rs.getBigDecimal("self_reported_gross_floor_area"));
      feedData.setListOfAllPropertyUseTypes(rs.getString("property_use_types"));
      feedData.setLargestPropertyUseType(rs.getString("largest_property_use_type"));
      feedData.setLargestPropertyUseTypeGrossFloorArea(rs.getBigDecimal("largest_property_use_type_gross_floor_area"));
      feedData.setSecondLargestPropertyUseType(rs.getString("second_largest_property_use_type"));
      feedData.setSecondLargestPropertyUseTypeGrossFloorArea(rs.getBigDecimal("second_largest_property_use_type_gross_floor_area"));
      feedData.setThirdLargestPropertyUseType(rs.getString("third_largest_property_use_type"));
      feedData.setThirdLargestPropertyUseTypeGrossFloorArea(rs.getBigDecimal("third_largest_property_use_type_gross_floor_area"));
      feedData.setFuelOil1Use(rs.getBigDecimal("fuel_oil_1_use"));
      feedData.setFuelOil2Use(rs.getBigDecimal("fuel_oil_2_use"));
      feedData.setFuelOil4Use(rs.getBigDecimal("fuel_oil_4_use"));
      feedData.setFuelOil5_6Use(rs.getBigDecimal("fuel_oil_5_6_use"));
      feedData.setDiesel2Use(rs.getBigDecimal("disel_2_use"));
      feedData.setPropaneUse(rs.getBigDecimal("propane_use"));
      feedData.setDistrictSteamUse(rs.getBigDecimal("district_steam_use"));
      feedData.setDistrictChilledWaterUse(rs.getBigDecimal("district_chilledwater_use"));
      feedData.setNaturalGasUsekBTU(rs.getBigDecimal("naturalgas_use_kbtu"));
      feedData.setElectricityGridPurchasekWh(rs.getBigDecimal("electricity_use_grid_purchase_kwh"));
      feedData.setTotalGHGEmissions(rs.getBigDecimal("total_ghg_emissions_metric_ton_co2"));
      feedData.setEnergyStarScore(rs.getInt("energy_star_score"));
      feedData.setSiteEUI(rs.getBigDecimal("site_eui"));
      feedData.setGenerationDate(rs.getTimestamp("generation_date"));

      builder.add(feedData);
    }

    return builder.build();
  }
}
