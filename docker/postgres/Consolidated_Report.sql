INSERT INTO stern.consolidated_report
SELECT * FROM stern.feed_ll84_bbl;

UPDATE stern.consolidated_report A
 SET total_carbon_emission_threshold_2024_2029 = B.total_carbon_emission_threshold_2024_2029,
   total_carbon_emission_threshold_2030_2034 = B.total_carbon_emission_threshold_2030_2034,
   total_actual_emission = B.total_actual_emission,
   emission_excess_2024_2029 = B.emission_excess_2024_2029,
   emission_excess_2030_2034 = B.emission_excess_2030_2034,
   emission_penalty_2024_2029 = B.emission_penalty_2024_2029,
   emission_penalty_2030_2034 = B.emission_penalty_2030_2034
 FROM stern.derived_penalty_variables B
 WHERE A.bbl = B.bbl;

UPDATE stern.consolidated_report A
 SET owner_name_1 = B.owner_name_1,
   owner_name_2 = B.owner_name_2,
   mail_recipient_name = B.mail_recipient_name,
   mail_careof = B.mail_careof,
   mail_city = B.mail_city,
   mail_state = B.mail_state,
   usps_address = B.usps_address
 FROM stern.feed_soana B
 WHERE A.bbl = B.bbl;

