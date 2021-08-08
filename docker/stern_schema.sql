CREATE SCHEMA IF NOT EXISTS stern;

CREATE TABLE stern.feed_ll84_bbl (
	id serial NOT NULL,
	bbl text NOT NULL,
	nyc_bin text NOT NULL,
	property_id text NULL,
	property_name text NULL,
	parent_property_id text NULL,
	is_standalone_property int4 NULL,
	is_parent_property int4 NULL,
	is_child_property int4 NULL,
	city_building text NULL,
	email text NULL,
	address_line_1 text NULL,
	address_line_2 text NULL,
	postal_code int8 NULL,
	borough text NULL,
	dof_gross_floor_area numeric(24,2) NULL,
	self_reported_gross_floor_area numeric(24,2) NULL,
	property_use_types text NULL,
	largest_property_use_type text NULL,
	largest_property_use_type_gross_floor_area numeric(24,2) NULL,
	second_largest_property_use_type text NULL,
	second_largest_property_use_type_gross_floor_area numeric(24,2) NULL,
	third_largest_property_use_type text NULL,
	third_largest_property_use_type_gross_floor_area numeric(24,2) NULL,
	year_built int4 NULL,
	number_of_buildings int4 NULL,
	occupancy int4 NULL,
	latitude_longitude_coordinates point NULL,
	community_board text NULL,
	council_district text NULL,
	census_tract text NULL,
	nta text NULL,
	fuel_oil_1_use numeric(24,2) NULL,
	fuel_oil_2_use numeric(24,2) NULL,
	fuel_oil_4_use numeric(24,2) NULL,
	fuel_oil_5_6_use numeric(24,2) NULL,
	diesel_2_use numeric(24,2) NULL,
	propane_use numeric(24,2) NULL,
	district_steam_use numeric(24,2) NULL,
	district_chilledwater_use numeric(24,2) NULL,
	naturalgas_use_kbtu numeric(24,2) NULL,
	electricity_use_grid_purchase_kwh numeric(24,2) NULL,
	total_ghg_emissions_metric_ton_co2 numeric(24,2) NULL,
	energy_star_score int4 NULL,
	site_eui numeric(24,2) NULL,
	generation_date timestamp NULL,
	street_number text NULL,
	street_name text NULL,
	list_of_property_types text NULL,
	metered_areas text NULL,
	kerosene_use numeric(24,2) NULL,
	naturalgas_use_therms numeric(24,2) NULL,
	direct_ghg_emissions_metric_ton_co2 numeric(24,2) NULL,
	indirect_ghg_emissions_metric_ton_co2 numeric(24,2) NULL,
	parent_property_name text NULL
);


-- stern.feed_rent_stab_info definition

-- Drop table

-- DROP TABLE stern.feed_rent_stab_info;

CREATE TABLE stern.feed_rent_stab_info (
	bbl text NULL,
	mp_version text NULL,
	mp_res_units int4 NULL,
	dof_stab_units_2018 int4 NULL,
	dof_stab_units_2019 int4 NULL,
	stab_unit_pct numeric NULL
);


-- stern.feed_soana definition

-- Drop table

-- DROP TABLE stern.feed_soana;

CREATE TABLE stern.feed_soana (
	bbl text NULL,
	mail_sequence text NULL,
	mail_recipient_type text NULL,
	borough text NULL,
	block text NULL,
	lot text NULL,
	easement text NULL,
	tax_class text NULL,
	building_class text NULL,
	owner_name_1 text NULL,
	owner_name_2 text NULL,
	prop_housenum text NULL,
	prop_street text NULL,
	prop_unit text NULL,
	prop_city text NULL,
	prop_state text NULL,
	prop_zip text NULL,
	prop_chg_date text NULL,
	mortgage_service_co text NULL,
	govt_owned text NULL,
	mail_recipient_name text NULL,
	mail_careof text NULL,
	mail_address_1 text NULL,
	mail_address_2 text NULL,
	mail_city text NULL,
	mail_state text NULL,
	mail_zip text NULL,
	mail_country text NULL,
	mail_country_cd text NULL,
	recip_chg_date text NULL,
	mail_chg_date text NULL,
	own_chg_date text NULL,
	own2_chg_date text NULL,
	phone text NULL,
	email text NULL,
	usps_verified text NULL,
	returned_mail text NULL,
	usps_address text NULL
);


-- stern.consolidated_report definition

-- Drop table

-- DROP TABLE stern.consolidated_report;

CREATE TABLE stern.consolidated_report (
	id serial NOT NULL,
	bbl text NOT NULL,
	nyc_bin text NOT NULL,
	property_id text NULL,
	property_name text NULL,
	parent_property_id text NULL,
	is_standalone_property int4 NULL,
	is_parent_property int4 NULL,
	is_child_property int4 NULL,
	city_building text NULL,
	email text NULL,
	address_line_1 text NULL,
	address_line_2 text NULL,
	postal_code int8 NULL,
	borough text NULL,
	dof_gross_floor_area numeric(24,2) NULL,
	self_reported_gross_floor_area numeric(24,2) NULL,
	property_use_types text NULL,
	largest_property_use_type text NULL,
	largest_property_use_type_gross_floor_area numeric(24,2) NULL,
	second_largest_property_use_type text NULL,
	second_largest_property_use_type_gross_floor_area numeric(24,2) NULL,
	third_largest_property_use_type text NULL,
	third_largest_property_use_type_gross_floor_area numeric(24,2) NULL,
	year_built int4 NULL,
	number_of_buildings int4 NULL,
	occupancy int4 NULL,
	latitude_longitude_coordinates point NULL,
	community_board text NULL,
	council_district text NULL,
	census_tract text NULL,
	nta text NULL,
	fuel_oil_acr1_use numeric(24,2) NULL,
	fuel_oil_acr2_use numeric(24,2) NULL,
	fuel_oil_acr4_use numeric(24,2) NULL,
	fuel_oil_acr5_acr6_use numeric(24,2) NULL,
	diesel_acr2_use numeric(24,2) NULL,
	propane_use numeric(24,2) NULL,
	district_steam_use numeric(24,2) NULL,
	district_chilledwater_use numeric(24,2) NULL,
	naturalgas_use_kbtu numeric(24,2) NULL,
	electricity_use_grid_purchase_kwh numeric(24,2) NULL,
	total_ghg_emissions_metric_ton_co2 numeric(24,2) NULL,
	energy_star_score int4 NULL,
	site_eui numeric(24,2) NULL,
	generation_date timestamp NULL,
	street_number text NULL,
	street_name text NULL,
	list_of_property_types text NULL,
	metered_areas text NULL,
	kerosene_use numeric(24,2) NULL,
	naturalgas_use_therms numeric(24,2) NULL,
	direct_ghg_emissions_metric_ton_co2 numeric(24,2) NULL,
	indirect_ghg_emissions_metric_ton_co2 numeric(24,2) NULL,
	total_carbon_emission_threshold_2024_2029 numeric(24,2) NULL,
	total_carbon_emission_threshold_2030_2034 numeric(24,2) NULL,
	total_actual_emission numeric(24,2) NULL,
	emission_excess_2024_2029 numeric(24,2) NULL,
	emission_excess_2030_2034 numeric(24,2) NULL,
	emission_penalty_2024_2029 numeric(24,2) NULL,
	emission_penalty_2030_2034 numeric(24,2) NULL,
	owner_name_1 text NULL,
	owner_name_2 text NULL,
	mail_recipient_name text NULL,
	mail_careof text NULL,
	mail_city text NULL,
	mail_state text NULL,
	usps_address text NULL,
	energy_grade text NULL,
	"Standalone,Parent,Child" text NULL,
	is_penalty_applicable_in_2024 text NULL,
	exception_name text NULL,
	qct text NULL,
	parent_property_name text NULL,
	exception_type text NULL,
	latitude text NULL,
	longitude text NULL,
	ownerpluto text NULL
);


-- stern.derived_penalty_exception definition

-- Drop table

-- DROP TABLE stern.derived_penalty_exception;

CREATE TABLE stern.derived_penalty_exception (
	id serial NOT NULL,
	bbl text NULL,
	qct text NULL,
	power_generation text NULL,
	city_building text NULL,
	data_nycha text NULL,
	rent_stab_1_to_35 text NULL,
	house_of_worship text NULL,
	hdfc text NULL,
	mitchell_lama text NULL,
	prog_j51 text NULL,
	prog_421a text NULL,
	prog_421a_aff text NULL,
	prog_202_8 text NULL,
	prog_prac_202 text NULL,
	prog_proj8 text NULL,
	prog_rad text NULL,
	rent_stab_gt_35 text NULL
);


-- stern.derived_penalty_variables definition

-- Drop table

-- DROP TABLE stern.derived_penalty_variables;

CREATE TABLE stern.derived_penalty_variables (
	id serial NOT NULL,
	bbl text NULL,
	nyc_bin text NULL,
	parent_property_id text NULL,
	property_id text NULL,
	largest_property_use_type text NULL,
	generation_date timestamp NULL,
	total_carbon_emission_threshold_2024_2029 numeric(24,2) NULL,
	total_carbon_emission_threshold_2030_2034 numeric(24,2) NULL,
	total_actual_emission numeric(24,2) NULL,
	emission_excess_2024_2029 numeric(24,2) NULL,
	emission_excess_2030_2034 numeric(24,2) NULL,
	emission_penalty_2024_2029 numeric(24,2) NULL,
	emission_penalty_2030_2034 numeric(24,2) NULL
);


-- stern.feed_acris_mortgage_info definition

-- Drop table

-- DROP TABLE stern.feed_acris_mortgage_info;

CREATE TABLE stern.feed_acris_mortgage_info (
	id serial NOT NULL,
	bbl text NOT NULL,
	document_id text NOT NULL,
	document_type text NOT NULL,
	document_amount numeric(24,2) NOT NULL,
	document_recorded_timestamp timestamp NULL,
	party_type text NULL,
	"name" text NULL,
	address_1 text NULL,
	zipcode text NULL
);


-- stern.feed_fc_shd_bbl_analysis definition

-- Drop table

-- DROP TABLE stern.feed_fc_shd_bbl_analysis;

CREATE TABLE stern.feed_fc_shd_bbl_analysis (
	bbl text NULL,
	standard_address text NULL,
	city_id text NULL,
	city_name text NULL,
	boro_id text NULL,
	boro_name text NULL,
	cd_id text NULL,
	cd_name text NULL,
	sba_id text NULL,
	sba_name text NULL,
	ccd_id text NULL,
	ccd_name text NULL,
	tract_10 text NULL,
	res_units text NULL,
	year_built text NULL,
	buildings text NULL,
	assessed_value text NULL,
	owner_name text NULL,
	ser_violation text NULL,
	tax_delinquency text NULL,
	latitude text NULL,
	longitude text NULL,
	data_dof text NULL,
	data_hcrlihtc text NULL,
	data_hpd text NULL,
	data_hudcon text NULL,
	data_hudfin text NULL,
	data_hudlihtc text NULL,
	data_ml text NULL,
	data_nycha text NULL,
	sub_fin text NULL,
	sub_prog text NULL,
	sub_tax text NULL,
	sub_zone text NULL,
	prog_202_8 text NULL,
	start_202_8 text NULL,
	end_202_8 text NULL,
	prog_221d text NULL,
	start_221d text NULL,
	end_221d text NULL,
	prog_223 text NULL,
	start_223 text NULL,
	end_223 text NULL,
	prog_420c text NULL,
	start_420c text NULL,
	end_420c text NULL,
	prog_421a text NULL,
	start_421a text NULL,
	end_421a text NULL,
	prog_421a_aff text NULL,
	start_421a_aff text NULL,
	end_421a_aff text NULL,
	prog_421g text NULL,
	start_421g text NULL,
	end_421g text NULL,
	prog_8a text NULL,
	start_8a text NULL,
	end_8a text NULL,
	prog_hpd_oth text NULL,
	start_hpd_oth text NULL,
	end_hpd_oth text NULL,
	prog_hud_fin_oth text NULL,
	start_hud_fin_oth text NULL,
	end_hud_fin_oth text NULL,
	prog_hud_proj_oth text NULL,
	start_hud_proj_oth text NULL,
	end_hud_proj_oth text NULL,
	prog_inclus_hous text NULL,
	start_inclus_hous text NULL,
	end_inclus_hous text NULL,
	prog_j51 text NULL,
	start_j51 text NULL,
	end_j51 text NULL,
	prog_lamp text NULL,
	start_lamp text NULL,
	end_lamp text NULL,
	prog_lihtc4 text NULL,
	start_lihtc4 text NULL,
	end_lihtc4 text NULL,
	prog_lihtc9 text NULL,
	start_lihtc9 text NULL,
	end_lihtc9 text NULL,
	prog_lmsa text NULL,
	start_lmsa text NULL,
	end_lmsa text NULL,
	prog_mfp text NULL,
	start_mfp text NULL,
	end_mfp text NULL,
	prog_ml text NULL,
	start_ml text NULL,
	end_ml text NULL,
	prog_nep text NULL,
	start_nep text NULL,
	end_nep text NULL,
	prog_nrp text NULL,
	start_nrp text NULL,
	end_nrp text NULL,
	prog_nycha_mix text NULL,
	start_nycha_mix text NULL,
	end_nycha_mix text NULL,
	prog_nycha_ph text NULL,
	start_nycha_ph text NULL,
	end_nycha_ph text NULL,
	prog_plp text NULL,
	start_plp text NULL,
	end_plp text NULL,
	prog_prac_202 text NULL,
	start_prac_202 text NULL,
	end_prac_202 text NULL,
	prog_proj8 text NULL,
	start_proj8 text NULL,
	end_proj8 text NULL,
	prog_rad text NULL,
	start_rad text NULL,
	end_rad text NULL,
	prog_tpt text NULL,
	start_tpt text NULL,
	end_tpt text NULL,
	prog_year15 text NULL,
	start_year15 text NULL,
	end_year15 text NULL
);


-- stern.feed_hdfc definition

-- Drop table

-- DROP TABLE stern.feed_hdfc;

CREATE TABLE stern.feed_hdfc (
	id serial NOT NULL,
	bbl text NULL
);


-- stern.feed_nycha_info definition

-- Drop table

-- DROP TABLE stern.feed_nycha_info;

CREATE TABLE stern.feed_nycha_info (
	id serial NOT NULL,
	development text NOT NULL,
	bbl text NOT NULL
);


-- stern.feed_qct definition

-- Drop table

-- DROP TABLE stern.feed_qct;

CREATE TABLE stern.feed_qct (
	id serial NOT NULL,
	geoid text NULL,
	bbl text NULL,
	address text NULL,
	bin text NULL
);


-- stern.lookup_carbon_limit definition

-- Drop table

-- DROP TABLE stern.lookup_carbon_limit;

CREATE TABLE stern.lookup_carbon_limit (
	id serial NOT NULL,
	occupancy_grp text NOT NULL,
	carbon_limit_2024_2029 numeric(4,2) NOT NULL,
	carbon_limit_2030_2034 numeric(4,2) NOT NULL
);


-- stern.lookup_energy_src_ghg_coeff definition

-- Drop table

-- DROP TABLE stern.lookup_energy_src_ghg_coeff;

CREATE TABLE stern.lookup_energy_src_ghg_coeff (
	id serial NOT NULL,
	energy_source text NOT NULL,
	ghg_coefficient numeric(12,12) NOT NULL,
	ghg_coefficient_unit varchar(40) NOT NULL
);


-- stern.lookup_occupancy_spaceuse_mapping definition

-- Drop table

-- DROP TABLE stern.lookup_occupancy_spaceuse_mapping;

CREATE TABLE stern.lookup_occupancy_spaceuse_mapping (
	id serial NOT NULL,
	occupancy_grp text NOT NULL,
	space_use text NOT NULL
);


-- stern.pluto definition

-- Drop table

-- DROP TABLE stern.pluto;

CREATE TABLE stern.pluto (
	bbl text NULL,
	latitude text NULL,
	longitude text NULL,
	ownerpluto text NULL
);
