SELECT
id,
bbl,
power_generation,
city_building,
data_nycha,
rent_stab_1_to_35,
rent_stab_gt_35,
house_of_worship,
hdfc,
mitchell_lama,
prog_j51,
prog_421a,
prog_421a_aff,
prog_202_8,
prog_prac_202,
prog_proj8,
prog_rad
FROM stern.derived_penalty_exception;


SELECT
bbl as "BBL - 10 digits",
nyc_bin as "NYC Building Identification Number (BIN)",
property_name as "Property Name",
"Standalone,Parent,Child",
parent_property_name as "Parent Property Name",
city_building as "City Building",
address_line_1 as "Address 1 (self-reported)",
postal_code as "Postal Code",
street_number as "Street Number",
street_name as "Street Name",
borough as "Borough",
latitude as "latitude",
longitude as "longitude",
community_board as "Community Board",
council_district as "Council District",
census_tract as "Census Tract",
nta as "NTA",
qct as "Quarter Census Tract",
generation_date as "Generation Date",
dof_gross_floor_area as "DOF Gross Floor Area (sqft)",
property_use_types as "List of All Property Use Types at Property",
largest_property_use_type as "Largest Property Use Type",
largest_property_use_type_gross_floor_area as "Largest Property Use Type - Gross Floor Area (sqft)",
second_largest_property_use_type as "2nd Largest Property Use Type",
second_largest_property_use_type_gross_floor_area as "2nd Largest Property Use - Gross Floor Area (sqft)",
third_largest_property_use_type as "3rd Largest Property Use Type",
third_largest_property_use_type_gross_floor_area as "3rd Largest Property Use Type - Gross Floor Area (sqft)",
year_built as "Year Built",
number_of_buildings as "Number of Buildings",
occupancy as "Occupancy",
metered_areas as "Metered Areas (Energy)",
energy_star_score as "Energy Star Score",
energy_grade as "Energy Grade",
site_eui as "Site EUI (kBtu/sqft)",
fuel_oil_acr1_use as "Fuel Oil #1 Use (kBtu)",
fuel_oil_acr2_use as "Fuel Oil #2 Use (kBtu)",
fuel_oil_acr4_use as "Fuel Oil #4 Use (kBtu)",
fuel_oil_acr5_acr6_use as "Fuel Oil #5 & 6 Use (kBtu)",
diesel_acr2_use as "Diesel #2 Use (kBtu)",
kerosene_use as "Kerosene Use (kBtu)",
propane_use as "Propane Use (kBtu)",
district_steam_use as "District Steam Use (kBtu)",
naturalgas_use_kbtu as "Natural Gas Use (kBtu)",
naturalgas_use_therms as "Natural Gas Use (therms)",
electricity_use_grid_purchase_kwh as "Electricity Use - Grid Purchase (kWh)",
total_ghg_emissions_metric_ton_co2 as "LL84 Total GHG Emissions (Metric Tons CO2e)",
direct_ghg_emissions_metric_ton_co2 as "LL84 Direct GHG Emissions (Metric Tons CO2e)",
indirect_ghg_emissions_metric_ton_co2 as "LL84 Indirect GHG Emissions (Metric Tons CO2e)",
is_penalty_applicable_in_2024 as "Compliance Starting in 2024",
exception_type as "Terms of Exception",
exception_name as "Excepted Building Category",
total_carbon_emission_threshold_2024_2029 as "LL97 Total Carbon Emission Threshold 2024_2029",
total_carbon_emission_threshold_2030_2034 as "LL97 Total Carbon Emission Threshold 2030_2034",
total_actual_emission as "LL97 Total emissions (Metric Tons CO2e)",
emission_excess_2024_2029 as "LL97 excess emissions 2024-2029 Metric Tons CO2e)",
emission_excess_2030_2034 as "LL97 excess emissions 2030-2034 Metric Tons CO2e)",
emission_penalty_2024_2029 as "LL97 penalty for 2024-2029 (USD)",
emission_penalty_2030_2034 as "LL97 penalty for 2030-2034 (USD)",
owner_name_1,
owner_name_2,
securitization_type,
mail_recipient_name,
mail_careof as "Portfolio owner or Agent",
mail_city,
mail_state,
usps_address,
ownerpluto,
"Owner-CorporationNameHDP"
FROM stern.consolidated_report;
