
create table stern.feed_qct
(
    id         serial not null,
    geoid      text,
    bbl        text,
    address    text,
    bin        text
);




create table stern.feed_hdfc
(
    id       serial not null,
    bbl      text
);




create table stern.derived_penalty_exception
(
    id                                serial not null,
    bbl                               text,
    qct                               text,
    power_generation                  text,
    city_building                     text,
    nycha                             text,
    rent_stablized_aptmt              text,
    house_of_worship                  text,
    hdfc                              text,
    project_based_fed_housing_program text,
    penalty_exempt_flag               text
);



create table stern.derived_penalty_variables
(
    id                                        serial        not null,
    bbl                                       text,
    nyc_bin                                   text,
    parent_property_id                        text,
    property_id                               text,
    largest_property_use_type                 text,
    generation_date                           timestamp,
    total_carbon_emission_threshold_202acr4_2029 numeric(24, 2),
    total_carbon_emission_threshold_2030_2034 numeric(24, 2),
    total_actual_emission                     numeric(24, 2),
    emission_excess_202acr4_2029                 numeric(24, 2),
    emission_excess_2030_2034                 numeric(24, 2),
    emission_penalty_202acr4_2029                numeric(24, 2),
    emission_penalty_2030_2034                numeric(24, 2)
);


create table stern.feed_acris_mortgage_info
(
    id                          serial         not null,
    bbl                         text   not null,
    document_id                 text   not null,
    document_type               text   not null,
    document_amount             numeric(24, 2) not null,
    document_recorded_timestamp timestamp,
    party_type                  text,
    name                        text,
    address_1                   text,
    zipcode                     text
);




create table stern.feed_ll84_bbl
(
    id                                                serial not null,
    bbl                                               text   not null,
    nyc_bin                                           text   not null,
    property_id                                       text,
    property_name                                     text,
    parent_property_id                                text,
    parent_property_name                              text,
    is_standalone_property                            integer,
    is_parent_property                                integer,
    is_child_property                                 integer,
    city_building                                     text,
    email                                             text,
    address_line_1                                    text,
    address_line_2                                    text,
    postal_code                                       bigint,
    borough                                           text,
    dof_gross_floor_area                              numeric(24, 2),
    self_reported_gross_floor_area                    numeric(24, 2),
    property_use_types                                text,
    largest_property_use_type                         text,
    largest_property_use_type_gross_floor_area        numeric(24, 2),
    second_largest_property_use_type                  text,
    second_largest_property_use_type_gross_floor_area numeric(24, 2),
    third_largest_property_use_type                   text,
    third_largest_property_use_type_gross_floor_area  numeric(24, 2),
    year_built                                        integer,
    number_of_buildings                               integer,
    occupancy                                         integer,
    latitude_longitude_coordinates                    point,
    community_board                                   text,
    council_district                                  text,
    census_tract                                      text,
    nta                                               text,
    fuel_oil_acr1_use                                    numeric(24, 2),
    fuel_oil_acr2_use                                    numeric(24, 2),
    fuel_oil_acr4_use                                    numeric(24, 2),
    fuel_oil_acr5_acr6_use                                  numeric(24, 2),
    diesel_acr2_use                                      numeric(24, 2),
    propane_use                                       numeric(24, 2),
    district_steam_use                                numeric(24, 2),
    district_chilledwater_use                         numeric(24, 2),
    naturalgas_use_kbtu                               numeric(24, 2),
    electricity_use_grid_purchase_kwh                 numeric(24, 2),
    total_ghg_emissions_metric_ton_co2                numeric(24, 2),
    energy_star_score                                 integer,
    site_eui                                          numeric(24, 2),
    generation_date                                   timestamp,
    street_number                                     text,
    street_name                                       text,
    list_of_property_types                            text,
    metered_areas                                     text,
    kerosene_use                                      numeric(24, 2),
    naturalgas_use_therms                             numeric(24, 2),
    direct_ghg_emissions_metric_ton_co2               numeric(24, 2),
    indirect_ghg_emissions_metric_ton_co2             numeric(24, 2)
);


create table stern.feed_nycha_info
(
    id          serial not null,
    development text   not null,
    bbl         text   not null
        constraint feed_nycha_info_pkey
            primary key
);


create table stern.feed_rent_stab_info
(
    id                  serial not null,
    bbl                 text,
    mp_version          text,
    mp_res_units        integer,
    dof_stab_units_2018 integer,
    dof_stab_units_2019 integer,
    stab_unit_pct       numeric(20, 20)
);


create table stern.feed_soana
(
    bbl                 text,
    mail_sequence       text,
    mail_recipient_type text,
    borough             text,
    block               text,
    lot                 text,
    easement            text,
    tax_class           text,
    building_class      text,
    owner_name_1        text,
    owner_name_2        text,
    prop_housenum       text,
    prop_street         text,
    prop_unit           text,
    prop_city           text,
    prop_state          text,
    prop_zip            text,
    prop_chg_date       text,
    mortgage_service_co text,
    govt_owned          text,
    mail_recipient_name text,
    mail_careof         text,
    mail_address_1      text,
    mail_address_2      text,
    mail_city           text,
    mail_state          text,
    mail_zip            text,
    mail_country        text,
    mail_country_cd     text,
    recip_chg_date      text,
    mail_chg_date       text,
    own_chg_date        text,
    ownacr2_chg_date       text,
    phone               text,
    email               text,
    usps_verified       text,
    returned_mail       text,
    usps_address        text
);


create table stern.lookup_carbon_limit
(
    id                     serial        not null,
    occupancy_grp          text   not null
        constraint lookup_carbon_limit_pkey
            primary key,
    carbon_limit_202acr4_2029 numeric(4, 2) not null,
    carbon_limit_2030_2034 numeric(4, 2) not null
);


create table stern.lookup_occupancy_spaceuse_mapping
(
    id            serial       not null,
    occupancy_grp text  not null,
    space_use     text not null
);

create table stern.lookup_energy_src_ghg_coeff
(
    id                   serial      not null,
    energy_source        text not null,
    ghg_coefficient      numeric(12, 12) not null,
    ghg_coefficient_unit text not null,
    primary key (energy_source)
);

create table stern.consolidated_report
(
    id                                                serial not null,
    bbl                                               text   not null,
    nyc_bin                                           text   not null,
    property_id                                       text,
    property_name                                     text,
    parent_property_id                                text,
    is_standalone_property                            integer,
    is_parent_property                                integer,
    is_child_property                                 integer,
    city_building                                     text,
    email                                             text,
    address_line_1                                    text,
    address_line_2                                    text,
    postal_code                                       bigint,
    borough                                           text,
    dof_gross_floor_area                              numeric(24, 2),
    self_reported_gross_floor_area                    numeric(24, 2),
    property_use_types                                text,
    largest_property_use_type                         text,
    largest_property_use_type_gross_floor_area        numeric(24, 2),
    second_largest_property_use_type                  text,
    second_largest_property_use_type_gross_floor_area numeric(24, 2),
    third_largest_property_use_type                   text,
    third_largest_property_use_type_gross_floor_area  numeric(24, 2),
    year_built                                        integer,
    number_of_buildings                               integer,
    occupancy                                         integer,
    latitude_longitude_coordinates                    point,
    community_board                                   text,
    council_district                                  text,
    census_tract                                      text,
    nta                                               text,
    fuel_oil_acr1_use                                    numeric(24, 2),
    fuel_oil_acr2_use                                    numeric(24, 2),
    fuel_oil_acr4_use                                    numeric(24, 2),
    fuel_oil_acr5_acr6_use                                  numeric(24, 2),
    diesel_acr2_use                                      numeric(24, 2),
    propane_use                                       numeric(24, 2),
    district_steam_use                                numeric(24, 2),
    district_chilledwater_use                         numeric(24, 2),
    naturalgas_use_kbtu                               numeric(24, 2),
    electricity_use_grid_purchase_kwh                 numeric(24, 2),
    total_ghg_emissions_metric_ton_co2                numeric(24, 2),
    energy_star_score                                 integer,
    site_eui                                          numeric(24, 2),
    generation_date                                   timestamp,
    street_number                                     text,
    street_name                                       text,
    list_of_property_types                            text,
    metered_areas                                     text,
    kerosene_use                                      numeric(24, 2),
    naturalgas_use_therms                             numeric(24, 2),
    direct_ghg_emissions_metric_ton_co2               numeric(24, 2),
    indirect_ghg_emissions_metric_ton_co2             numeric(24, 2),
    total_carbon_emission_threshold_2024_2029         numeric(24, 2),
    total_carbon_emission_threshold_2030_2034         numeric(24, 2),
    total_actual_emission                             numeric(24, 2),
    emission_excess_2024_2029                         numeric(24, 2),
    emission_excess_2030_2034                         numeric(24, 2),
    emission_penalty_2024_2029                        numeric(24, 2),
    emission_penalty_2030_2034                        numeric(24, 2),
    owner_name_1                                      text,
    owner_name_2                                      text,
    mail_recipient_name                               text,
    mail_careof                                       text,
    mail_city                                         text,
    mail_state                                        text,
    usps_address                                      text,
    acr1_document_id                                     text,
    acr1_document_type                                   text  ,
    acr1_document_amount                                 numeric(24, 2) ,
    acr1_document_recorded_timestamp                     timestamp,
    acr1_party_type                                      text,
    acr1_name                                            text,
    acr1_address_1                                       text,
    acr1_zipcode                                         text,
    acr2_document_id                                     text,
    acr2_document_type                                   text  ,
    acr2_document_amount                                 numeric(24, 2) ,
    acr2_document_recorded_timestamp                     timestamp,
    acr2_party_type                                      text,
    acr2_name                                            text,
    acr2_address_1                                       text,
    acr2_zipcode                                         text,
    acr3_document_id                                     text,
    acr3_document_type                                   text  ,
    acr3_document_amount                                 numeric(24, 2) ,
    acr3_document_recorded_timestamp                     timestamp,
    acr3_party_type                                      text,
    acr3_name                                            text,
    acr3_address_1                                       text,
    acr3_zipcode                                         text,
    acr4_document_id                                     text,
    acr4_document_type                                   text  ,
    acr4_document_amount                                 numeric(24, 2) ,
    acr4_document_recorded_timestamp                     timestamp,
    acr4_party_type                                      text,
    acr4_name                                            text,
    acr4_address_1                                       text,
    acr4_zipcode                                         text,
    acr5_document_id                                     text,
    acr5_document_type                                   text  ,
    acr5_document_amount                                 numeric(24, 2) ,
    acr5_document_recorded_timestamp                     timestamp,
    acr5_party_type                                      text,
    acr5_name                                            text,
    acr5_address_1                                       text,
    acr5_zipcode                                         text,
    acr6_document_id                                     text,
    acr6_document_type                                   text  ,
    acr6_document_amount                                 numeric(24, 2) ,
    acr6_document_recorded_timestamp                     timestamp,
    acr6_party_type                                      text,
    acr6_name                                            text,
    acr6_address_1                                       text,
    acr6_zipcode                                         text,
    acr7_document_id                                     text,
    acr7_document_type                                   text  ,
    acr7_document_amount                                 numeric(24, 2) ,
    acr7_document_recorded_timestamp                     timestamp,
    acr7_party_type                                      text,
    acr7_name                                            text,
    acr7_address_1                                       text,
    acr7_zipcode                                         text,
    acr8_document_id                                     text,
    acr8_document_type                                   text  ,
    acr8_document_amount                                 numeric(24, 2) ,
    acr8_document_recorded_timestamp                     timestamp,
    acr8_party_type                                      text,
    acr8_name                                            text,
    acr8_address_1                                       text,
    acr8_zipcode                                         text,
    acr9_document_id                                     text,
    acr9_document_type                                   text  ,
    acr9_document_amount                                 numeric(24, 2) ,
    acr9_document_recorded_timestamp                     timestamp,
    acr9_party_type                                      text,
    acr9_name                                            text,
    acr9_address_1                                       text,
    acr9_zipcode                                         text,
    acr10_document_id                                    text,
    acr10_document_type                                  text  ,
    acr10_document_amount                                numeric(24, 2) ,
    acr10_document_recorded_timestamp                    timestamp,
    acr10_party_type                                     text,
    acr10_name                                           text,
    acr10_address_1                                      text,
    acr10_zipcode                                        text
);
