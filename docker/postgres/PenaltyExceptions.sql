INSERT INTO stern.derived_penalty_exception (bbl)
SELECT bbl FROM stern.feed_ll84_bbl;

-- QCT

UPDATE stern.derived_penalty_exception
SET qct = '1'
FROM stern.feed_qct
WHERE stern.derived_penalty_exception.bbl = stern.feed_qct.bbl;


UPDATE stern.derived_penalty_exception
SET qct = '0'
WHERE qct is null;

-- City building

UPDATE stern.derived_penalty_exception
SET city_building = '1'
FROM stern.feed_ll84_bbl
WHERE stern.derived_penalty_exception.bbl = stern.feed_ll84_bbl.bbl
AND stern.feed_ll84_bbl.city_building='Yes' ;

UPDATE stern.derived_penalty_exception
SET city_building = '0'
WHERE city_building is null;

-- Rent stabilization
-- TODO : something's not right here

UPDATE stern.derived_penalty_exception
SET rent_stablized_aptmt = '1'
FROM stern.feed_rent_stabilized_units_info
WHERE stern.derived_penalty_exception.bbl = stern.feed_rent_stabilized_units_info.bbl
AND stern.feed_rent_stabilized_units_info.stab_unit_pct>0.01
AND stern.feed_rent_stabilized_units_info.stab_unit_pct<0.35 ;

UPDATE stern.derived_penalty_exception
SET rent_stablized_aptmt = '0'
WHERE rent_stablized_aptmt is null;

-- Power generation


UPDATE stern.derived_penalty_exception
SET power_generation = '1'
FROM stern.feed_ll84_bbl
WHERE stern.derived_penalty_exception.bbl = stern.feed_ll84_bbl.bbl
AND stern.feed_ll84_bbl.list_of_property_types like '%Energy/Power Station%' ;

UPDATE stern.derived_penalty_exception
SET power_generation = '0'
WHERE power_generation is null;


-- House of worship


UPDATE stern.derived_penalty_exception
SET house_of_worship = '1'
FROM stern.feed_ll84_bbl
WHERE stern.derived_penalty_exception.bbl = stern.feed_ll84_bbl.bbl
AND stern.feed_ll84_bbl.list_of_property_types like '%Worship Facility%' ;

UPDATE stern.derived_penalty_exception
SET house_of_worship = '0'
WHERE house_of_worship is null;


-- HDFC

UPDATE stern.derived_penalty_exception
SET hdfc = '1'
FROM stern.feed_hdfc
WHERE stern.derived_penalty_exception.bbl = stern.feed_hdfc.bbl;

UPDATE stern.derived_penalty_exception
SET hdfc = '0'
WHERE hdfc is null;

-- Mitchell-Lama

UPDATE stern.derived_penalty_exception
SET mitchell_lama = '1'
FROM stern.feed_fc_shd_bbl_analysis
WHERE stern.derived_penalty_exception.bbl = stern.feed_fc_shd_bbl_analysis.bbl
AND stern.feed_fc_shd_bbl_analysis.data_ml = '1' ;

UPDATE stern.derived_penalty_exception
SET mitchell_lama = '0'
WHERE mitchell_lama is null;


-- prog_j51 a.k.a Government assisted buildings J-51 Tax Incentive

UPDATE stern.derived_penalty_exception
SET prog_j51 = '1'
FROM stern.feed_fc_shd_bbl_analysis
WHERE stern.derived_penalty_exception.bbl = stern.feed_fc_shd_bbl_analysis.bbl
AND stern.feed_fc_shd_bbl_analysis.prog_j51 = '1' ;

UPDATE stern.derived_penalty_exception
SET prog_j51 = '0'
WHERE prog_j51 is null;


-- prog_421a a.k.a Government assisted buildings 421-a Tax Incentive Program

UPDATE stern.derived_penalty_exception
SET prog_421a = '1'
FROM stern.feed_fc_shd_bbl_analysis
WHERE stern.derived_penalty_exception.bbl = stern.feed_fc_shd_bbl_analysis.bbl
AND stern.feed_fc_shd_bbl_analysis.prog_421a = '1' ;

UPDATE stern.derived_penalty_exception
SET prog_421a = '0'
WHERE prog_421a is null;


-- prog_421a_aff a.k.a Government assisted buildings 421a Affordable

UPDATE stern.derived_penalty_exception
SET prog_421a_aff = '1'
FROM stern.feed_fc_shd_bbl_analysis
WHERE stern.derived_penalty_exception.bbl = stern.feed_fc_shd_bbl_analysis.bbl
AND stern.feed_fc_shd_bbl_analysis.prog_421a_aff = '1' ;

UPDATE stern.derived_penalty_exception
SET prog_421a_aff = '0'
WHERE prog_421a_aff is null;


-- prog_202_8 a.k.a Section 202/8

UPDATE stern.derived_penalty_exception
SET prog_202_8 = '1'
FROM stern.feed_fc_shd_bbl_analysis
WHERE stern.derived_penalty_exception.bbl = stern.feed_fc_shd_bbl_analysis.bbl
AND stern.feed_fc_shd_bbl_analysis.prog_202_8 = '1' ;

UPDATE stern.derived_penalty_exception
SET prog_202_8 = '0'
WHERE prog_202_8 is null;


-- Project Rental Assistance Contract / 202


UPDATE stern.derived_penalty_exception
SET prog_prac_202 = '1'
FROM stern.feed_fc_shd_bbl_analysis
WHERE stern.derived_penalty_exception.bbl = stern.feed_fc_shd_bbl_analysis.bbl
AND stern.feed_fc_shd_bbl_analysis.prog_prac_202 = '1' ;


UPDATE stern.derived_penalty_exception
SET prog_prac_202 = '0'
WHERE prog_prac_202 is null;


-- Project-Based Section 8 a.k.a prog_proj8


UPDATE stern.derived_penalty_exception
SET prog_proj8 = '1'
FROM stern.feed_fc_shd_bbl_analysis
WHERE stern.derived_penalty_exception.bbl = stern.feed_fc_shd_bbl_analysis.bbl
AND stern.feed_fc_shd_bbl_analysis.prog_proj8 = '1' ;


UPDATE stern.derived_penalty_exception
SET prog_proj8 = '0'
WHERE prog_proj8 is null;



-- Section 8 - RAD a.k.a prog_rad


UPDATE stern.derived_penalty_exception
SET prog_rad = '1'
FROM stern.feed_fc_shd_bbl_analysis
WHERE stern.derived_penalty_exception.bbl = stern.feed_fc_shd_bbl_analysis.bbl
AND stern.feed_fc_shd_bbl_analysis.prog_rad = '1' ;


UPDATE stern.derived_penalty_exception
SET prog_rad = '0'
WHERE prog_rad is null;


-- NYCHA

UPDATE stern.derived_penalty_exception
SET data_nycha = '1'
FROM stern.feed_fc_shd_bbl_analysis
WHERE stern.derived_penalty_exception.bbl = stern.feed_fc_shd_bbl_analysis.bbl
AND stern.feed_fc_shd_bbl_analysis.data_nycha = '1' ;


UPDATE stern.derived_penalty_exception
SET data_nycha = '0'
WHERE data_nycha is null;
