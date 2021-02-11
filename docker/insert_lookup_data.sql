INSERT INTO public.lookup_energy_src_ghg_coeff (id, energy_source, ghg_coefficient, ghg_coefficient_unit) VALUES (1, 'DistrictSteam', 0.000044930000, 'tonCO2e/kBTU');
INSERT INTO public.lookup_energy_src_ghg_coeff (id, energy_source, ghg_coefficient, ghg_coefficient_unit) VALUES (2, 'FuelOil2', 0.000074210000, 'tonCO2e/kBTU');
INSERT INTO public.lookup_energy_src_ghg_coeff (id, energy_source, ghg_coefficient, ghg_coefficient_unit) VALUES (3, 'FuelOil4', 0.000075290000, 'tonCO2e/kBTU');
INSERT INTO public.lookup_energy_src_ghg_coeff (id, energy_source, ghg_coefficient, ghg_coefficient_unit) VALUES (4, 'Natural-Gas', 0.000053110000, 'tonCO2e/kBTU');
INSERT INTO public.lookup_energy_src_ghg_coeff (id, energy_source, ghg_coefficient, ghg_coefficient_unit) VALUES (5, 'Utility-Electricity', 0.000288962000, 'tonCO2e/kWh');


INSERT INTO public.lookup_carbon_limit (id, occupancy_grp, carbon_limit_2024_2029, carbon_limit_2030_2034) VALUES (4, 'A-Assembly', 10.74, 4.20);
INSERT INTO public.lookup_carbon_limit (id, occupancy_grp, carbon_limit_2024_2029, carbon_limit_2030_2034) VALUES (5, 'B-AmbulatoryHealth', 23.81, 11.93);
INSERT INTO public.lookup_carbon_limit (id, occupancy_grp, carbon_limit_2024_2029, carbon_limit_2030_2034) VALUES (1, 'B-Business', 8.46, 4.53);
INSERT INTO public.lookup_carbon_limit (id, occupancy_grp, carbon_limit_2024_2029, carbon_limit_2030_2034) VALUES (25, 'B-Healthcare', 0.00, 0.00);
INSERT INTO public.lookup_carbon_limit (id, occupancy_grp, carbon_limit_2024_2029, carbon_limit_2030_2034) VALUES (68, 'E-Education', 0.00, 0.00);
INSERT INTO public.lookup_carbon_limit (id, occupancy_grp, carbon_limit_2024_2029, carbon_limit_2030_2034) VALUES (6, 'E-Educational', 0.00, 0.00);
INSERT INTO public.lookup_carbon_limit (id, occupancy_grp, carbon_limit_2024_2029, carbon_limit_2030_2034) VALUES (13, 'F-Factory/Industrial', 0.00, 0.00);
INSERT INTO public.lookup_carbon_limit (id, occupancy_grp, carbon_limit_2024_2029, carbon_limit_2030_2034) VALUES (29, 'I1-Institutional', 0.00, 0.00);
INSERT INTO public.lookup_carbon_limit (id, occupancy_grp, carbon_limit_2024_2029, carbon_limit_2030_2034) VALUES (15, 'I2-Institutional', 0.00, 0.00);
INSERT INTO public.lookup_carbon_limit (id, occupancy_grp, carbon_limit_2024_2029, carbon_limit_2030_2034) VALUES (61, 'I3-Institutional', 0.00, 0.00);
INSERT INTO public.lookup_carbon_limit (id, occupancy_grp, carbon_limit_2024_2029, carbon_limit_2030_2034) VALUES (3, 'M-Mercantile', 11.81, 4.30);
INSERT INTO public.lookup_carbon_limit (id, occupancy_grp, carbon_limit_2024_2029, carbon_limit_2030_2034) VALUES (7, 'R1-Residential', 0.00, 0.00);
INSERT INTO public.lookup_carbon_limit (id, occupancy_grp, carbon_limit_2024_2029, carbon_limit_2030_2034) VALUES (2, 'R2-Residential', 6.75, 4.07);
INSERT INTO public.lookup_carbon_limit (id, occupancy_grp, carbon_limit_2024_2029, carbon_limit_2030_2034) VALUES (10, 'S-Storage', 0.00, 0.00);
INSERT INTO public.lookup_carbon_limit (id, occupancy_grp, carbon_limit_2024_2029, carbon_limit_2030_2034) VALUES (56, 'U-Utility/Misc', 0.00, 0.00);


INSERT INTO public.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use) VALUES (36, 'B-Business', 'Financial Office');
INSERT INTO public.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use) VALUES (15, 'I2-Institutional', 'Hospital (General Medical & Surgical)');
INSERT INTO public.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use) VALUES (40, 'B-Business', 'Bank Branch');
INSERT INTO public.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use) VALUES (3, 'M-Mercantile', 'Retail Store');
INSERT INTO public.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use) VALUES (1, 'B-Business', 'Office');
INSERT INTO public.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use) VALUES (2, 'R2-Residential', 'MultifamilyHousing');
INSERT INTO public.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use) VALUES (4, 'A-Assembly', 'SocialMeetingHall');
INSERT INTO public.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use) VALUES (6, 'E-Educational', 'K-12 School');
INSERT INTO public.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use) VALUES (7, 'R1-Residential', 'Hotel');
INSERT INTO public.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use) VALUES (8, 'A-Assembly', 'WorshipFacility');
INSERT INTO public.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use) VALUES (9, 'R1-Residential', 'Other-Lodging/Residential');
INSERT INTO public.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use) VALUES (10, 'S-Storage', 'DistributionCenter');
INSERT INTO public.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use) VALUES (11, 'S-Storage', 'Non-RefrigeratedWarehouse');
INSERT INTO public.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use) VALUES (12, 'S-Storage', 'RefrigeratedWarehouse');
INSERT INTO public.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use) VALUES (13, 'F-Factory/Industrial', 'Manufacturing/IndustrialPlant');
INSERT INTO public.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use) VALUES (16, 'A-Assembly', 'Other');
INSERT INTO public.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use) VALUES (17, 'A-Assembly', 'Other-Education');
INSERT INTO public.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use) VALUES (18, 'A-Assembly', 'Museum');
INSERT INTO public.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use) VALUES (19, 'A-Assembly', 'Other-Entertainment/PublicAssembly');
INSERT INTO public.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use) VALUES (20, 'E-Educational', 'College/University');
INSERT INTO public.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use) VALUES (21, 'F-Factory/Industrial', 'Food Service');
INSERT INTO public.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use) VALUES (22, 'R1-Residential', 'ResidenceHall/Dormitory');
INSERT INTO public.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use) VALUES (23, 'I2-Institutional', 'Laboratory');
INSERT INTO public.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use) VALUES (24, 'B-Business', 'MedicalOffice');
INSERT INTO public.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use) VALUES (25, 'B-Healthcare', 'UrgentCare/Clinic/OtherOutpatient');
INSERT INTO public.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use) VALUES (26, 'B-Healthcare', 'AmbulatorySurgicalCenter');
INSERT INTO public.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use) VALUES (27, 'I2-Institutional', 'Other-SpecialtyHospital');
INSERT INTO public.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use) VALUES (28, 'B-Business', 'Other-Mall');
INSERT INTO public.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use) VALUES (29, 'I1-Institutional', 'SeniorCareCommunity');
INSERT INTO public.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use) VALUES (30, 'E-Educational', 'Pre-school/Daycare');
INSERT INTO public.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use) VALUES (31, 'A-Assembly', 'Social/MeetingHall');
INSERT INTO public.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use) VALUES (32, 'A-Assembly', 'PerformingArts');
INSERT INTO public.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use) VALUES (33, 'U-Utility/Misc', 'Parking');
INSERT INTO public.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use) VALUES (34, 'E-Educational', 'AdultEducation');
INSERT INTO public.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use) VALUES (35, 'U-Utility/Misc', 'Self-StorageFacility');
INSERT INTO public.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use) VALUES (37, 'M-Mercantile', 'StripMall');
INSERT INTO public.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use) VALUES (38, 'I3-Institutional', 'Prison/Incarceration');
INSERT INTO public.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use) VALUES (39, 'B-Business', 'FitnessCenter/HealthClub/Gym');
INSERT INTO public.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use) VALUES (41, 'M-Mercantile', 'WholesaleClub/Supercenter');
INSERT INTO public.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use) VALUES (42, 'B-Business', 'DataCenter');
INSERT INTO public.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use) VALUES (43, 'U-Utility/Misc', 'Other-Services');
INSERT INTO public.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use) VALUES (44, 'B-Business', 'OutpatientRehabilitation/PhysicalTherapy');
INSERT INTO public.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use) VALUES (45, 'E-Education', 'Library');
INSERT INTO public.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use) VALUES (46, 'A-Assembly', 'Other-Recreation');
INSERT INTO public.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use) VALUES (47, 'M-Mercantile', 'Supermarket/GroceryStore');
INSERT INTO public.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use) VALUES (48, 'M-Mercantile', 'ConvenienceStorewithoutGasStation');
INSERT INTO public.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use) VALUES (49, 'I1-Institutional', 'ResidentialCareFacility');
INSERT INTO public.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use) VALUES (50, 'A-Assembly', 'MovieTheater');
INSERT INTO public.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use) VALUES (51, 'A-Assembly', 'EnclosedMall');
INSERT INTO public.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use) VALUES (52, 'B-Business', 'AutomobileDealership');
INSERT INTO public.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use) VALUES (53, 'B-Business', 'MailingCenter/PostOffice');
INSERT INTO public.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use) VALUES (54, 'B-Business', 'PersonalServices(Health/Beauty,DryCleaning,etc)');
INSERT INTO public.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use) VALUES (55, 'A-Assembly', 'Courthouse');
INSERT INTO public.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use) VALUES (56, 'B-Business', 'Other-Technology/Science');
INSERT INTO public.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use) VALUES (57, 'B-Business', 'Other-PublicServices');
INSERT INTO public.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use) VALUES (58, 'B-Business', 'RepairServices(Vehicle,Shoe,Locksmith,etc)');
INSERT INTO public.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use) VALUES (59, 'B-Business', 'FireStation');
INSERT INTO public.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use) VALUES (60, 'B-Business', 'PoliceStation');
INSERT INTO public.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use) VALUES (61, 'F-Factory/Industrial', 'WastewaterTreatmentPlant');
INSERT INTO public.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use) VALUES (62, 'B-Business', 'VeterinaryOffice');
INSERT INTO public.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use) VALUES (63, 'A-Assembly', 'Ice/CurlingRink');
INSERT INTO public.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use) VALUES (64, 'A-Assembly', 'Zoo');
INSERT INTO public.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use) VALUES (65, 'A-Assembly', 'TransportationTerminal/Station');
INSERT INTO public.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use) VALUES (66, 'A-Assembly', 'Stadium(Open)');
INSERT INTO public.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use) VALUES (67, 'A-Assembly', 'Restaurant');
INSERT INTO public.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use) VALUES (68, 'E-Educational', 'VocationalSchool');
INSERT INTO public.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use) VALUES (69, 'B-Business', 'Other-Restaurant/Bar');
INSERT INTO public.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use) VALUES (70, 'A-Assembly', 'FastFoodRestaurant');
INSERT INTO public.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use) VALUES (71, 'A-Assembly', 'SwimmingPool');
INSERT INTO public.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use) VALUES (72, 'A-Assembly', 'Bar/Nightclub');
INSERT INTO public.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use) VALUES (73, 'M-Mercantile', 'FoodSales');
INSERT INTO public.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use) VALUES (74, 'U-Utility/Misc', 'Other-Utility');
INSERT INTO public.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use) VALUES (75, 'A-Assembly', 'BowlingAlley');
INSERT INTO public.lookup_occupancy_spaceuse_mapping (id, occupancy_grp, space_use) VALUES (76, 'A-Assembly', 'SingleFamilyHome');
