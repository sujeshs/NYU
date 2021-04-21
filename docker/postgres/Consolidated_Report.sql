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
	          prog_rad='1'
	     then 'no'
	end
from stern.derived_penalty_exception B
where A.bbl = B.bbl ;

update stern.consolidated_report A
set is_penalty_applicable_in_2024 = 'yes'
where is_penalty_applicable_in_2024 is null ;


update stern.consolidated_report A
set exception_name =
	case when rent_stab_1_to_35='1' then 'Rent stabilized-With at least  1 property but less than 35%, including Non government assisted buildings that utilize 421-a and J-51 exemptions'
	     when data_nycha='1' then 'NYCHA'
	     when mitchell_lama='1' then 'Mitchell-Lama'
       when prog_j51='1' then 'Government assisted buildings J-51 Tax Incentive'
       when prog_421a='1' then 'Government assisted buildings 421-a Tax Incentive Program'
       when prog_421a_aff='1' then 'Government assisted buildings 421a Affordable'
       when rent_stab_gt_35='1' then 'Rent stabilized-More than 35%, including Non government assisted buildings that utilize 421-a and J-51 exemptions'
       when prog_202_8='1' then 'Section 202/8'
       when prog_prac_202='1' then 'Project Rental Assistance Contract / 202'
       when prog_proj8='1' then 'Project-Based Section 8'
       when prog_rad='1' then 'Section 8 - RAD'
       when hdfc='1' then 'HDFC'
	     when power_generation='1' then 'Energy/Power Station'
	     when B.city_building='1' then 'City building'
	     when house_of_worship='1' then 'Worship Facility'
	     end
from stern.derived_penalty_exception B
where A.bbl = B.bbl;


update stern.consolidated_report A
set exception_type =
	case when rent_stab_1_to_35='1' then 'Comply with GHG limits beginning 2026'
	     when data_nycha='1' then 'Reduce general GHG 40% from 2005 by 2030'
	     when mitchell_lama='1' or
            prog_j51='1' or
            prog_421a='1' or
            prog_421a_aff='1' then 'Comply with GHG limits beginning 2035'
       when rent_stab_gt_35='1' or
            prog_202_8='1' or
            prog_prac_202='1' or
            prog_proj8='1' or
            prog_rad='1' or
            hdfc='1' or
	          power_generation='1' or
	          B.city_building='1' or
	          house_of_worship='1' then 'Exempted from compliance with all GHG limits, but subject to prescriptive requirements'
	     end
from stern.derived_penalty_exception B
where A.bbl = B.bbl;


update stern.consolidated_report A
set city_building =
  case when B.city_building='1' then 'Yes'
  else 'No'
  end
from stern.derived_penalty_exception B
where A.bbl = B.bbl;


update stern.consolidated_report A
set borough =
  case when bbl like '1%' then 'manhattan'
       when bbl like '2%' then 'bronx'
       when bbl like '3%' then 'brooklyn'
       when bbl like '4%' then 'queens'
       when bbl like '5%' then 'statenisland'
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


