create table derived_penalty_exemption
(
    id                                serial        not null,
    bbl                               text not null,
    power_generation                  boolean,
    city_building                     boolean,
    nycha                             boolean,
    rent_stablized_aptmt              boolean,
    house_of_worship                  boolean,
    hdfc                              boolean,
    project_based_fed_housing_program boolean,
    penalty_exempt_flag               boolean
);


create table derived_penalty_variables
(
    id                                        serial        not null,
    bbl                                       text,
    nyc_bin                                   text,
    parent_property_id                        text,
    property_id                               text,
    largest_property_use_type                 text,
    generation_date                           timestamp,
    total_carbon_emission_threshold_2024_2029 numeric(24, 2),
    total_carbon_emission_threshold_2030_2034 numeric(24, 2),
    total_actual_emission                     numeric(24, 2),
    emission_excess_2024_2029                 numeric(24, 2),
    emission_excess_2030_2034                 numeric(24, 2),
    emission_penalty_2024_2029                text,
    emission_penalty_2030_2034                text,
    phase1_penalty                            numeric(24, 2),
    phase2_penalty                            numeric(24, 2)
);


create table feed_acris_mortgage_info
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


create table feed_ll84_bbl
(
    id                                                serial not null,
    bbl                                               text   not null,
    nyc_bin                                           text   not null,
    property_id                                       text,
    property_name                                     text,
    parent_property_id                                text,
    is_standalone_property                            boolean,
    is_parent_property                                boolean,
    is_child_property                                 boolean,
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
    fuel_oil_1_use                                    numeric(24, 2),
    fuel_oil_2_use                                    numeric(24, 2),
    fuel_oil_4_use                                    numeric(24, 2),
    fuel_oil_5_6_use                                  numeric(24, 2),
    disel_2_use                                       numeric(24, 2),
    propane_use                                       numeric(24, 2),
    district_steam_use                                numeric(24, 2),
    district_chilledwater_use                         numeric(24, 2),
    naturalgas_use_kbtu                               numeric(24, 2),
    electricity_use_grid_purchase_kwh                 numeric(24, 2),
    total_ghg_emissions_metric_ton_co2                numeric(24, 2),
    energy_star_score                                 integer,
    site_eui                                          numeric(24, 2),
    generation_date                                   timestamp
);


create table feed_nycha_info
(
    id          serial not null,
    development text   not null,
    bbl         text   not null
        constraint feed_nycha_info_pkey
            primary key
);


create table feed_rent_stabilized_units_info
(
    id                  serial not null,
    bbl                 text   not null
        constraint feed_rent_stabilized_units_info_pkey
            primary key,
    mp_version          text   not null,
    mp_res_units        integer,
    dof_stab_units_2018 integer,
    dof_stab_units_2019 integer,
    stab_unit_pct       numeric(4, 2)
);


create table feed_soana
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
    own2_chg_date       text,
    phone               text,
    email               text,
    usps_verified       text,
    returned_mail       text,
    usps_address        text
);


create table lookup_carbon_limit
(
    id                     serial        not null,
    occupancy_grp          text   not null
        constraint lookup_carbon_limit_pkey
            primary key,
    carbon_limit_2024_2029 numeric(4, 2) not null,
    carbon_limit_2030_2034 numeric(4, 2) not null
);


create table lookup_occupancy_spaceuse_mapping
(
    id            serial       not null,
    occupancy_grp text  not null,
    space_use     text not null
);

create table lookup_energy_src_ghg_coeff
(
    id                   serial      not null,
    energy_source        text not null,
    ghg_coefficient      numeric(12, 12) not null,
    ghg_coefficient_unit varchar(40) not null,
    primary key (energy_source)
);
