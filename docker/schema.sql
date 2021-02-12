create table lookup_carbon_limit
(
    id                     serial      not null,
    occupancy_grp          varchar(40) not null,
    carbon_limit_2024_2029 numeric(4, 2) not null,
    carbon_limit_2030_2034 numeric(4, 2) not null,
    primary key (occupancy_grp)
);

create table lookup_energy_src_ghg_coeff
(
    id                   serial      not null,
    energy_source        varchar(40) not null,
    ghg_coefficient      numeric(12, 12) not null,
    ghg_coefficient_unit varchar(40) not null,
    primary key (energy_source)
);

create table lookup_occupancy_spaceuse_mapping
(
    id            serial       not null,
    occupancy_grp varchar(40)  not null,
    space_use     varchar(100) not null
);

create table derived_penalty_exemption
(
    id                                serial        not null,
    bbl                               varchar(1000) not null,
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
    bbl                                       varchar(1000) not null,
    nyc_bin                                   varchar(1000) not null,
    total_carbon_emission_threshold_2024_2029 numeric(24, 2),
    total_carbon_emission_threshold_2030_2034 numeric(24, 2),
    total_actual_emission                     numeric(24, 2),
    emission_excess_2024_2029                 numeric(24, 2),
    emission_excess_2030_2034                 numeric(24, 2),
    emission_penalty_2024_2029                varchar(100),
    emission_penalty_2030_2034                varchar(100),
    primary key (bbl, nyc_bin)
);

create table feed_acris_mortgage_info
(
    id                          serial         not null,
    bbl                         varchar(100)   not null,
    document_id                 varchar(100)   not null,
    document_type               varchar(100)   not null,
    document_amount             numeric(24, 2) not null,
    document_recorded_timestamp timestamp,
    party_type                  varchar(100),
    name                        varchar(1000),
    address_1                   varchar(1000),
    zipcode                     varchar(40)
);

create table feed_soana_ownership_info
(
    id               serial        not null,
    bbl              varchar(1000) not null,
    owner_1          varchar(1000),
    owner_2          varchar(1000),
    recipient_1      varchar(1000),
    recipient_2      varchar(1000),
    mailing_street_1 varchar(1000),
    mailing_street_2 varchar(1000),
    mailing_city_1   varchar(100),
    mailing_city_2   varchar(100),
    mailing_state_1  varchar(100),
    mailing_state_2  varchar(100),
    mailing_zip_1    varchar(40),
    mailing_zip_2    varchar(40),
    mailing_country  varchar(40),
    src              varchar(1000),
    easement         varchar(1000),
    primary key(bbl)
);

create table feed_ll84_bbl
(
    id                                                serial        not null,
    bbl                                               varchar(1000) not null,
    nyc_bin                                           varchar(1000) not null,
    property_id                                       varchar(40),
    property_name                                     varchar(40),
    city_building                                     varchar(4),
    email                                             varchar(60),
    address_line_1                                    varchar(100),
    address_line_2                                    varchar(100),
    postal_code                                       bigint,
    borough                                           varchar(50),
    dof_gross_floor_area                              numeric(24, 2),
    self_reported_gross_floor_area                    numeric(24, 2),
    property_use_types                                varchar(100),
    largest_property_use_type                         varchar(100),
    largest_property_use_type_gross_floor_area        numeric(24, 2),
    second_largest_property_use_type                  varchar(100),
    second_largest_property_use_type_gross_floor_area numeric(24, 2),
    third_largest_property_use_type                   varchar(100),
    third_largest_property_use_type_gross_floor_area  numeric(24, 2),
    year_built                                        integer,
    number_of_buildings                               integer,
    occupancy                                         integer,
    latitude_longitude_coordinates                    point,
    community_board                                   varchar(40),
    council_district                                  varchar(40),
    census_tract                                      varchar(40),
    nta                                               varchar(1000),
    fuel_oil_1_use                                    numeric(24, 2),
    fuel_oil_2_use                                    numeric(24, 2),
    fuel_oil_4_use                                    numeric(24, 2),
    fuel_oil_5_6_use                                  numeric(24, 2),
    disel_2_use                                       numeric(24, 2),
    propane_use                                       numeric(24, 2),
    district_steam_use                                numeric(24, 2),
    district_chilledwater_use                         numeric(24, 2),
    naturalgas_use                                    numeric(24, 2),
    electricity_use_grid_purchase_kwh                 numeric(24, 2),
    total_ghg_emissions_metric_ton_co2                numeric(24, 2),
    energy_star_score                                 integer,
    site_eui                                          numeric(24, 2),
    primary key (bbl, nyc_bin)
);
