package edu.nyu.sdg.penalties.dao.postgres.sql;

public final class LoadSql {

  public static final String PUT_DERIVED_VARS_DATA =
      "INSERT INTO PUBLIC.derived_penalty_variables ( bbl,nyc_bin,total_carbon_emission_threshold_2024_2029,total_carbon_emission_threshold_2030_2034,total_actual_emission ,emission_excess_2024_2029 ,emission_excess_2030_2034 ,emission_penalty_2024_2029,emission_penalty_2030_2034 ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

  public static final String PUT_FEED_LL84_DATA =
      "INSERT INTO PUBLIC.feed_ll84_bbl ( bbl,nyc_bin,property_id,property_name,city_building,email,address_line_1,address_line_2,postal_code,borough,dof_gross_floor_area,self_reported_gross_floor_area,property_use_types,largest_property_use_type,largest_property_use_type_gross_floor_area,second_largest_property_use_type,second_largest_property_use_type_gross_floor_area,third_largest_property_use_type,third_largest_property_use_type_gross_floor_area,year_built,number_of_buildings,occupancy,latitude_longitude_coordinates,community_board,council_district,census_tract,nta,fuel_oil_1_use,fuel_oil_2_use,fuel_oil_4_use,fuel_oil_5_6_use,disel_2_use,propane_use,district_steam_use,district_chilledwater_use,naturalgas_use,electricity_use_grid_purchase_kwh,total_ghg_emissions_metric_ton_co2,energy_star_score,site_eui) VALUES ( ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,point(?,?),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
}