package edu.nyu.sdg.penalties.dao.postgres.sql;

public class DerivedVariablesSql {

  public static final String PUT_DERIVED_VARS_DATA =
      "INSERT INTO PUBLIC.derived_penalty_variables ( bbl,nyc_bin,total_carbon_emission_threshold_2024_2029,total_carbon_emission_threshold_2030_2034,total_actual_emission ,emission_excess_2024_2029 ,emission_excess_2030_2034 ,emission_penalty_2024_2029,emission_penalty_2030_2034 ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
}
