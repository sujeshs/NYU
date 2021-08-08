INSERT INTO stern.consolidated_report
SELECT * FROM stern.feed_ll84_bbl;

UPDATE stern.consolidated_report A
 SET standardized_address = B.standardized_address
 FROM stern.ll97_standardizedaddress_csv B
 WHERE A.bbl = B.bbl;

UPDATE stern.consolidated_report A
  SET master_servicer = B.master_servicer
  FROM stern.agency_hud_ny_csv B
  WHERE A.standardized_address = B.standardized_address;

UPDATE stern.consolidated_report A
SET A.deal_name = B."Deal",
    A.securitization_type = 'private'
FROM stern.bloomberg B
WHERE A.standardized_address = B."StandardizedAddress";

UPDATE stern.consolidated_report A
SET securitization_type = 'agency'
WHERE A.master_servicer is not null;

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

update stern.consolidated_report
set energy_grade =
case when energy_star_score >= 85 then 'A'
            when energy_star_score >= 70 and energy_star_score < 85 then 'B'
            when energy_star_score >= 55 and energy_star_score < 70 then 'C'
            when energy_star_score < 55 then 'D'
            else 'N' end;

update stern.consolidated_report A
set is_penalty_applicable_in_2024 =
	case when power_generation='1' or
	          power_generation='1' or
	          data_nycha='1' or
	          rent_stab_1_to_35='1' or
	          rent_stab_gt_35='1' or
	          house_of_worship='1' or
	          hdfc='1' or
	          mitchell_lama='1' or
	          prog_j51='1' or
	          prog_421a='1'
	          or prog_421a_aff='1' or
	          prog_202_8='1' or
	          prog_prac_202='1' or
	          prog_proj8='1' or
	          prog_rad='1' or
	          city_building='1'
	     then 'No'
	end
from stern.derived_penalty_exception B
where A.bbl = B.bbl ;

update stern.consolidated_report A
set is_penalty_applicable_in_2024 = 'Yes'
where is_penalty_applicable_in_2024 is null ;


update stern.consolidated_report A
set exception_name =
	case when rent_stab_1_to_35='1' then 'Rent Stabilized With At Least One Unit and Fewer Than 35% (If Income Restricted, Compliance Delayed to 2035)'
	     when data_nycha='1' then 'NYCHA'
	     when mitchell_lama='1' then 'Mitchell-Lama'
       when prog_j51='1' then 'Government assisted buildings J-51 Tax Incentive'
       when prog_421a='1' then 'Government assisted buildings 421-a Tax Incentive Program'
       when prog_421a_aff='1' then 'Government assisted buildings 421a Affordable'
       when rent_stab_gt_35='1' then 'More than 35% Rent Stabilized'
       when prog_202_8='1' then 'Section 202/8 - Elderly Supportive Housing'
       when prog_prac_202='1' then 'Project Rental Assistance Contract / 202'
       when prog_proj8='1' then 'Project-Based Section 8'
       when prog_rad='1' then 'Section 8 - RAD'
       when hdfc='1' then 'HDFC'
	     when power_generation='1' then 'Energy/Power Station'
	     when B.city_building='1' then 'City-owned Building'
	     when house_of_worship='1' then 'Worship Facility'
	     end
from stern.derived_penalty_exception B
where A.bbl = B.bbl;


update
	stern.consolidated_report A
set
	exception_type =
	case
		when data_nycha = '1'
		or B.city_building = '1'
		or prog_rad = '1' then 'Emissions Reductions Required Portfolio-Wide'
		when rent_stab_gt_35 = '1'
		or prog_202_8 = '1'
		or prog_prac_202 = '1'
		or prog_proj8 = '1'
		or hdfc = '1'
		or house_of_worship = '1' then 'Subject to Prescriptive Requirements, but Exempt from Penalties'
		when mitchell_lama = '1' then 'Compliance Delayed to 2035'
		when rent_stab_1_to_35 = '1' then 'Compliance Delayed to 2026'
		when power_generation = '1' then 'Exempt from Prescriptive Requirements and Penalties'
	end
from
	stern.derived_penalty_exception B
where
	A.bbl = B.bbl;


update stern.consolidated_report A
set city_building =
  case when B.city_building='1' then 'Yes'
  else 'No'
  end
from stern.derived_penalty_exception B
where A.bbl = B.bbl;


update stern.consolidated_report A
set borough =
  case when bbl like '1%' then 'Manhattan'
       when bbl like '2%' then 'Bronx'
       when bbl like '3%' then 'Brooklyn'
       when bbl like '4%' then 'Queens'
       when bbl like '5%' then 'Staten Island'
  end;


update stern.consolidated_report A
set qct =
case when B.qct = '1' then 'Yes'
else 'No'
end
from stern.derived_penalty_exception B
where A.bbl=B.bbl


update stern.consolidated_report A
set latitude = B.latitude,
longitude = B.longitude,
ownerpluto = B.ownerpluto
from stern.pluto B
where A.bbl=B.bbl


update stern.consolidated_report A
set A.year_built = B.year_built
from stern.feed_ll84_bbl B
where A.bbl = B.bbl ;

update stern.consolidated_report cr
set ownerpluto = faboc."Owner-PLUTO",
   "Owner-CorporationNameHDP"  = faboc."Owner-Corporation Name HDP"
from stern.feed_alejandro_bbl_owners_csv faboc
where cr.bbl = faboc.bbl
