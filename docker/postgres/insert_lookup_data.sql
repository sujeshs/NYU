INSERT INTO stern.lookup_carbon_limit (id, occupancy_grp, carbon_limit_2024_2029, carbon_limit_2030_2034)
VALUES (1, 'B-Business', 8.46, 4.53);
INSERT INTO stern.lookup_carbon_limit (id, occupancy_grp, carbon_limit_2024_2029, carbon_limit_2030_2034)
VALUES (2, 'R2-Residential', 6.75, 4.07);
INSERT INTO stern.lookup_carbon_limit (id, occupancy_grp, carbon_limit_2024_2029, carbon_limit_2030_2034)
VALUES (3, 'M-Mercantile', 11.81, 4.30);
INSERT INTO stern.lookup_carbon_limit (id, occupancy_grp, carbon_limit_2024_2029, carbon_limit_2030_2034)
VALUES (4, 'A-Assembly', 10.74, 4.20);
INSERT INTO stern.lookup_carbon_limit (id, occupancy_grp, carbon_limit_2024_2029, carbon_limit_2030_2034)
VALUES (5, 'B-AmbulatoryHealth', 23.81, 11.93);
INSERT INTO stern.lookup_carbon_limit (id, occupancy_grp, carbon_limit_2024_2029, carbon_limit_2030_2034)
VALUES (100, 'B-Healthcare', 23.81, 11.93);
INSERT INTO stern.lookup_carbon_limit (id, occupancy_grp, carbon_limit_2024_2029, carbon_limit_2030_2034)
VALUES (101, 'E-Education', 7.58, 3.44);
INSERT INTO stern.lookup_carbon_limit (id, occupancy_grp, carbon_limit_2024_2029, carbon_limit_2030_2034)
VALUES (102, 'E-Educational', 7.58, 3.44);
INSERT INTO stern.lookup_carbon_limit (id, occupancy_grp, carbon_limit_2024_2029, carbon_limit_2030_2034)
VALUES (103, 'F-Factory/Industrial', 5.74, 1.67);
INSERT INTO stern.lookup_carbon_limit (id, occupancy_grp, carbon_limit_2024_2029, carbon_limit_2030_2034)
VALUES (104, 'I1-Institutional', 11.38, 5.98);
INSERT INTO stern.lookup_carbon_limit (id, occupancy_grp, carbon_limit_2024_2029, carbon_limit_2030_2034)
VALUES (105, 'I2-Institutional', 23.81, 11.93);
INSERT INTO stern.lookup_carbon_limit (id, occupancy_grp, carbon_limit_2024_2029, carbon_limit_2030_2034)
VALUES (106, 'I3-Institutional', 23.81, 11.93);
INSERT INTO stern.lookup_carbon_limit (id, occupancy_grp, carbon_limit_2024_2029, carbon_limit_2030_2034)
VALUES (107, 'R1-Residential', 9.87, 5.26);
INSERT INTO stern.lookup_carbon_limit (id, occupancy_grp, carbon_limit_2024_2029, carbon_limit_2030_2034)
VALUES (108, 'S-Storage', 4.26, 1.10);
INSERT INTO stern.lookup_carbon_limit (id, occupancy_grp, carbon_limit_2024_2029, carbon_limit_2030_2034)
VALUES (109, 'U-Utility/Misc', 4.26, 1.20);

INSERT INTO stern.lookup_energy_src_ghg_coeff (id, energy_source, ghg_coefficient, ghg_coefficient_unit)
VALUES (2, 'DistrictSteam', 0.000044930000, 'tonCO2e/kBTU');
INSERT INTO stern.lookup_energy_src_ghg_coeff (id, energy_source, ghg_coefficient, ghg_coefficient_unit)
VALUES (3, 'FuelOil2', 0.000074210000, 'tonCO2e/kBTU');
INSERT INTO stern.lookup_energy_src_ghg_coeff (id, energy_source, ghg_coefficient, ghg_coefficient_unit)
VALUES (4, 'FuelOil4', 0.000075290000, 'tonCO2e/kBTU');
INSERT INTO stern.lookup_energy_src_ghg_coeff (id, energy_source, ghg_coefficient, ghg_coefficient_unit)
VALUES (5, 'Natural-Gas', 0.000053110000, 'tonCO2e/kBTU');
INSERT INTO stern.lookup_energy_src_ghg_coeff (id, energy_source, ghg_coefficient, ghg_coefficient_unit)
VALUES (6, 'Utility-Electricity', 0.000288962000, 'tonCO2e/kWh');

INSERT INTO stern.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use)
VALUES (36, 'B-Business', 'Financial Office');
INSERT INTO stern.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use)
VALUES (15, 'I2-Institutional', 'Hospital (General Medical & Surgical)');
INSERT INTO stern.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use)
VALUES (40, 'B-Business', 'Bank Branch');
INSERT INTO stern.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use)
VALUES (3, 'M-Mercantile', 'Retail Store');
INSERT INTO stern.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use)
VALUES (24, 'B-Business', 'Medical Office');
INSERT INTO stern.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use)
VALUES (41, 'M-Mercantile', 'Wholesale Club/Supercenter');
INSERT INTO stern.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use)
VALUES (8, 'A-Assembly', 'Worship Facility');
INSERT INTO stern.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use)
VALUES (4, 'A-Assembly', 'Social/Meeting Hall');
INSERT INTO stern.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use)
VALUES (29, 'I1-Institutional', 'Senior Care Community');
INSERT INTO stern.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use)
VALUES (9, 'R1-Residential', 'Other - Lodging/Residential');
INSERT INTO stern.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use)
VALUES (35, 'U-Utility/Misc', 'Self-Storage Facility');
INSERT INTO stern.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use)
VALUES (34, 'E-Educational', 'Adult Education');
INSERT INTO stern.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use)
VALUES (27, 'I2-Institutional', 'Other - Specialty Hospital');
INSERT INTO stern.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use)
VALUES (12, 'S-Storage', 'Refrigerated Warehouse');
INSERT INTO stern.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use)
VALUES (28, 'B-Business', 'Other - Mall');
INSERT INTO stern.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use)
VALUES (26, 'B-Healthcare', 'Ambulatory Surgical Center');
INSERT INTO stern.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use)
VALUES (39, 'B-Business', 'Fitness Center/Health Club/Gym');
INSERT INTO stern.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use)
VALUES (11, 'S-Storage', 'Non-Refrigerated Warehouse');
INSERT INTO stern.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use)
VALUES (2, 'R2-Residential', 'Multifamily Housing');
INSERT INTO stern.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use)
VALUES (10, 'S-Storage', 'Distribution Center');
INSERT INTO stern.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use)
VALUES (42, 'B-Business', 'Data Center');
INSERT INTO stern.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use)
VALUES (43, 'U-Utility/Misc', 'Other - Services');
INSERT INTO stern.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use)
VALUES (37, 'M-Mercantile', 'Strip Mall');
INSERT INTO stern.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use)
VALUES (32, 'A-Assembly', 'Performing Arts');
INSERT INTO stern.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use)
VALUES (22, 'R1-Residential', 'Residence Hall/Dormitory');
INSERT INTO stern.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use)
VALUES (17, 'A-Assembly', 'Other - Education');
INSERT INTO stern.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use)
VALUES (13, 'F-Factory/Industrial', 'Manufacturing/Industrial Plant');
INSERT INTO stern.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use)
VALUES (19, 'A-Assembly', 'Other - Entertainment/Public Assembly');
INSERT INTO stern.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use)
VALUES (25, 'B-Healthcare', 'Urgent Care/Clinic/Other Outpatient');
INSERT INTO stern.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use)
VALUES (1, 'B-Business', 'Office');
INSERT INTO stern.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use)
VALUES (6, 'E-Educational', 'K-12 School');
INSERT INTO stern.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use)
VALUES (7, 'R1-Residential', 'Hotel');
INSERT INTO stern.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use)
VALUES (16, 'A-Assembly', 'Other');
INSERT INTO stern.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use)
VALUES (18, 'A-Assembly', 'Museum');
INSERT INTO stern.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use)
VALUES (20, 'E-Educational', 'College/University');
INSERT INTO stern.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use)
VALUES (21, 'F-Factory/Industrial', 'Food Service');
INSERT INTO stern.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use)
VALUES (23, 'I2-Institutional', 'Laboratory');
INSERT INTO stern.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use)
VALUES (30, 'E-Educational', 'Pre-school/Daycare');
INSERT INTO stern.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use)
VALUES (33, 'U-Utility/Misc', 'Parking');
INSERT INTO stern.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use)
VALUES (38, 'I3-Institutional', 'Prison/Incarceration');
INSERT INTO stern.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use)
VALUES (45, 'E-Education', 'Library');
INSERT INTO stern.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use)
VALUES (55, 'A-Assembly', 'Courthouse');
INSERT INTO stern.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use)
VALUES (64, 'A-Assembly', 'Zoo');
INSERT INTO stern.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use)
VALUES (66, 'A-Assembly', 'Stadium(Open)');
INSERT INTO stern.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use)
VALUES (67, 'A-Assembly', 'Restaurant');
INSERT INTO stern.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use)
VALUES (72, 'A-Assembly', 'Bar/Nightclub');
INSERT INTO stern.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use)
VALUES (68, 'E-Educational', 'Vocational School');
INSERT INTO stern.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use)
VALUES (71, 'A-Assembly', 'Swimming Pool');
INSERT INTO stern.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use)
VALUES (51, 'A-Assembly', 'Enclosed Mall');
INSERT INTO stern.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use)
VALUES (49, 'I1-Institutional', 'Residential Care Facility');
INSERT INTO stern.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use)
VALUES (53, 'B-Business', 'Mailing Center/Post Office');
INSERT INTO stern.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use)
VALUES (59, 'B-Business', 'Fire Station');
INSERT INTO stern.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use)
VALUES (61, 'F-Factory/Industrial', 'Wastewater Treatment Plant');
INSERT INTO stern.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use)
VALUES (69, 'B-Business', 'Other - Restaurant/Bar');
INSERT INTO stern.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use)
VALUES (58, 'B-Business', 'Repair Services (Vehicle, Shoe, Locksmith, etc)');
INSERT INTO stern.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use)
VALUES (74, 'U-Utility/Misc', 'Other - Utility');
INSERT INTO stern.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use)
VALUES (76, 'A-Assembly', 'Single Family Home');
INSERT INTO stern.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use)
VALUES (44, 'B-Business', 'Outpatient Rehabilitation/Physical Therapy');
INSERT INTO stern.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use)
VALUES (62, 'B-Business', 'Veterinary Office');
INSERT INTO stern.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use)
VALUES (46, 'A-Assembly', 'Other - Recreation');
INSERT INTO stern.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use)
VALUES (48, 'M-Mercantile', 'Convenience Store without Gas Station');
INSERT INTO stern.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use)
VALUES (47, 'M-Mercantile', 'Supermarket/Grocery Store');
INSERT INTO stern.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use)
VALUES (75, 'A-Assembly', 'Bowling Alley');
INSERT INTO stern.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use)
VALUES (56, 'B-Business', 'Other - Technology/Science');
INSERT INTO stern.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use)
VALUES (50, 'A-Assembly', 'Movie Theater');
INSERT INTO stern.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use)
VALUES (70, 'A-Assembly', 'Fast Food Restaurant');
INSERT INTO stern.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use)
VALUES (63, 'A-Assembly', 'Ice/Curling Rink');
INSERT INTO stern.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use)
VALUES (60, 'B-Business', 'Police Station');
INSERT INTO stern.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use)
VALUES (52, 'B-Business', 'Automobile Dealership');
INSERT INTO stern.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use)
VALUES (73, 'M-Mercantile', 'Food Sales');
INSERT INTO stern.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use)
VALUES (54, 'B-Business', 'Personal Services (Health/Beauty, Dry Cleaning, etc)');
INSERT INTO stern.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use)
VALUES (57, 'B-Business', 'Other - Public Services');
INSERT INTO stern.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use)
VALUES (65, 'A-Assembly', 'Transportation Terminal/Station');
