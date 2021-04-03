package edu.nyu.sdg.penalties.dao.postgres.sql

object PACESql {

  const val GET_CARBONLIMIT_DATA = """
SELECT
  id,
  occupancy_grp,
  carbon_limit_2024_2029,
  carbon_limit_2030_2034
FROM stern.lookup_carbon_limit
"""

  const val GET_ENERGYSRCGHCOEFF_DATA = """
SELECT
  id,
  energy_source,
  ghg_coefficient,
  ghg_coefficient_unit
FROM stern.lookup_energy_src_ghg_coeff
"""

  const val GET_OCCUPANCY_SPACEUSE_DATA = """
SELECT
  occupancy_grp,
space_use
FROM stern.lookup_occupancy_spaceuse_mapping
"""

  const val PUT_DERIVED_VARS_DATA = """
INSERT INTO stern.derived_penalty_variables(
  bbl,
  nyc_bin,
  parent_property_id,
  property_id,
  largest_property_use_type,
  generation_date,
  total_carbon_emission_threshold_2024_2029,
  total_carbon_emission_threshold_2030_2034,
  total_actual_emission ,
  emission_excess_2024_2029 ,
  emission_excess_2030_2034 ,
  emission_penalty_2024_2029,
  emission_penalty_2030_2034,
  phase1_penalty,
  phase2_penalty
)
VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
"""

  const val PUT_FEED_ACRIS_DATA = """
INSERT INTO stern.feed_acris_mortgage_info(
  bbl,
  document_id,
  document_type,
  document_amount,
  document_recorded_timestamp,
  party_type,
  name,
  address_1,
  zipcode
)
VALUES (?,?,?,?,?,?,?,?,?)
"""

  const val PUT_FEED_LL84_DATA = """
INSERT INTO stern.feed_ll84_bbl(
  bbl,
  nyc_bin,
  property_id,
  property_name,
  parent_property_id,
  city_building,
  email,
  address_line_1,
  address_line_2,
  postal_code,
  borough,
  dof_gross_floor_area,
  self_reported_gross_floor_area,
  property_use_types,
  largest_property_use_type,
  largest_property_use_type_gross_floor_area,
  second_largest_property_use_type,
  second_largest_property_use_type_gross_floor_area,
  third_largest_property_use_type,
  third_largest_property_use_type_gross_floor_area,
  year_built,
  number_of_buildings,
  occupancy,
  generation_date,
  latitude_longitude_coordinates,
  community_board,
  council_district,
  census_tract,
  nta,
  fuel_oil_1_use,
  fuel_oil_2_use,
  fuel_oil_4_use,
  fuel_oil_5_6_use,
  diesel_2_use,
  propane_use,
  district_steam_use,
  district_chilledwater_use,
  naturalgas_use_kbtu,
  electricity_use_grid_purchase_kwh,
  total_ghg_emissions_metric_ton_co2,
  energy_star_score,
  site_eui
)
VALUES ( ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,point(?,?),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)
"""

  const val PUT_FEED_NYCHA_DATA = """
INSERT INTO stern.feed_nycha_info(
  bbl,
  development
)
VALUES (?,?)
"""

  const val PUT_FEED_RENT_STABILIZED_UNITS_DATA = """
INSERT INTO stern.feed_rent_stabilized_units_info(
  bbl,
  mp_version,
  mp_res_units,
  dof_stab_units_2018,
  dof_stab_units_2019,
  stab_unit_pct
)
VALUES (?,?,?,?,?,?)
"""

  const val PUT_FEED_SOANA_DATA = """
INSERT INTO stern.feed_soana (
  bbl,
  mail_sequence,
  mail_recipient_type,
  borough,
  block,
  lot,
  easement,
  tax_class,
  building_class,
  owner_name_1,
  owner_name_2,
  prop_housenum,
  prop_street,
  prop_unit,
  prop_city,
  prop_state,
  prop_zip,
  prop_chg_date,
  mortgage_service_co,
  govt_owned,
  mail_recipient_name,
  mail_careof,
  mail_address_1,
  mail_address_2,
  mail_city,
  mail_state,
  mail_zip,
  mail_country,
  mail_country_cd,
  recip_chg_date,
  mail_chg_date,
  own_chg_date,
  own2_chg_date,
  phone,
  email,
  usps_verified,
  returned_mail,
  usps_address
)
VALUES  (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
""""""

  const val READ_LL84_DATA = """
SELECT
  *
FROM stern.feed_ll84_bbl
"""
}
