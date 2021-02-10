INSERT INTO public.lookup_energy_src_ghg_coeff (id, energy_source, ghg_coefficient, ghg_coefficient_unit) VALUES (1, 'DistrictSteam', 0.000044930000, 'tonCO2e/kBTU');
INSERT INTO public.lookup_energy_src_ghg_coeff (id, energy_source, ghg_coefficient, ghg_coefficient_unit) VALUES (2, 'FuelOil2', 0.000074210000, 'tonCO2e/kBTU');
INSERT INTO public.lookup_energy_src_ghg_coeff (id, energy_source, ghg_coefficient, ghg_coefficient_unit) VALUES (3, 'FuelOil4', 0.000075290000, 'tonCO2e/kBTU');
INSERT INTO public.lookup_energy_src_ghg_coeff (id, energy_source, ghg_coefficient, ghg_coefficient_unit) VALUES (4, 'Natural-Gas', 0.000053110000, 'tonCO2e/kBTU');
INSERT INTO public.lookup_energy_src_ghg_coeff (id, energy_source, ghg_coefficient, ghg_coefficient_unit) VALUES (5, 'Utility-Electricity', 0.000288962000, 'tonCO2e/kWh');


INSERT INTO public.lookup_carbon_limit (id, occupancy_grp, space_use, carbon_limit_2024_2029, carbon_limit_2030_2034) VALUES (1, 'B-Business', 'Office', 8.46, 4.53);
INSERT INTO public.lookup_carbon_limit (id, occupancy_grp, space_use, carbon_limit_2024_2029, carbon_limit_2030_2034) VALUES (2, 'R2-Residential', 'MultifamilyHousing', 6.75, 4.07);
INSERT INTO public.lookup_carbon_limit (id, occupancy_grp, space_use, carbon_limit_2024_2029, carbon_limit_2030_2034) VALUES (3, 'M-Mercantile', 'RetailStore', 11.81, 4.30);
INSERT INTO public.lookup_carbon_limit (id, occupancy_grp, space_use, carbon_limit_2024_2029, carbon_limit_2030_2034) VALUES (4, 'A-Assembly', 'SocialMeetingHall', 10.74, 4.20);
INSERT INTO public.lookup_carbon_limit (id, occupancy_grp, space_use, carbon_limit_2024_2029, carbon_limit_2030_2034) VALUES (5, 'B-AmbulatoryHealth', 'MedicalOffice', 23.81, 11.93);
