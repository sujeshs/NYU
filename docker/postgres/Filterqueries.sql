/**
 * NOTE: Don't consider "parents" or repeated submissions
 * - I am planning to run a query that will remove such records from the view; No other action needed for this
 * - Keep parent, just remove duplicates
 */



/*
 * Rank buildings by total LL97 carbon
 */
select A.bbl, B.nyc_bin, A.total_actual_emission
from derived_penalty_variables A
         left join feed_ll84_bbl B
                   on A.bbl = B.bbl
group by A.bbl, B.nyc_bin, A.total_actual_emission
order by total_actual_emission desc;


/*
 * Rank buildings by Carbon Intensity
 */
select A.bbl, A.nyc_bin, A.site_eui from feed_ll84_bbl A
order by site_eui desc;


/*
 * Rank buildings by Penalties to pay in phase 1
 */
select A.bbl, A.nyc_bin, A.emission_penalty_2024_2029
from derived_penalty_variables A
         left join feed_ll84_bbl B
                   on A.bbl = B.bbl
group by A.bbl, A.nyc_bin, A.emission_penalty_2024_2029, A.phase1_penalty
order by phase1_penalty desc;


/*
 * Rank buildings by Penalties to pay in phase 2
 */
select A.bbl, A.nyc_bin, A.emission_penalty_2030_2034
from derived_penalty_variables A
         left join feed_ll84_bbl B
                   on A.bbl = B.bbl
group by A.bbl, A.nyc_bin, A.emission_penalty_2030_2034, A.phase2_penalty
order by phase2_penalty desc;


/*
 * Rank ownership groups by total LL97 carbon
 */
select B.mail_careof, A.total_actual_emission
from derived_penalty_variables A
         left join feed_soana B
                   on A.bbl = B.bbl
group by A.bbl, A.property_id, B.mail_careof, A.total_actual_emission
order by total_actual_emission desc;


/*
 * Rank ownership groups by average carbon intensity
 */
select B.mail_careof, A.site_eui
from feed_ll84_bbl A
         left join feed_soana B
                   on A.bbl = B.bbl
group by A.bbl, A.property_id, B.mail_careof, A.site_eui
order by site_eui desc;


/*
 * Rank ownership groups by added penalties phase 1
 */
select B.mail_careof, A.emission_penalty_2024_2029
from derived_penalty_variables A
         left join feed_soana B
                   on A.bbl = B.bbl
group by B.mail_careof, A.emission_penalty_2024_2029, A.phase1_penalty
order by phase1_penalty desc;


/*
 * Rank ownership groups by added penalties phase 2
 */
select B.mail_careof, A.emission_penalty_2030_2034
from derived_penalty_variables A
         left join feed_soana B
                   on A.bbl = B.bbl
group by B.mail_careof, A.emission_penalty_2030_2034, A.phase2_penalty
order by phase2_penalty desc;




/*
 * Rank lenders by total LL97 carbon
 */
select A.name, sum(B.total_actual_emission) as TotalEmissions from feed_acris_mortgage_info A
left join derived_penalty_variables B
on A.bbl = B.bbl
where A.party_type = '2' and A.name <> ''
group by A.name
order by TotalEmissions desc;



/*
 * Rank lenders by carbon intensity (by weighted average carbon intensity of lending portfolio –
 * where weights are the notional of each NYC mortgage/total NYC mortgage portfolio)
 */
select A.name, sum(B.site_eui) as TotalSiteEUI from feed_acris_mortgage_info A
left join feed_ll84_bbl B
on A.bbl = B.bbl
where A.party_type = '2' and A.name <> ''
group by A.name
order by TotalSiteEUI desc;



/*
 * Rank Lenders by added penalties phase 1
 */
select A.name, cast(sum(B.phase1_penalty) as money) as TotalPhase1Penalty from feed_acris_mortgage_info A
left join derived_penalty_variables B
on A.bbl = B.bbl
where A.party_type = '2' and A.name <> ''
group by A.name
order by TotalPhase1Penalty desc;


/*
 * Rank Lenders by added penalties phase 1
 */
select A.name, cast(sum(B.phase1_penalty) as money) as TotalPhase1Penalty from feed_acris_mortgage_info A
left join derived_penalty_variables B
on A.bbl = B.bbl
where A.party_type = '2' and A.name <> ''
group by A.name
order by TotalPhase1Penalty desc;



/*
 * Rank Lenders by added penalties phase 2
 */
select A.name, cast(sum(B.phase2_penalty) as money) as TotalPhase2Penalty from feed_acris_mortgage_info A
left join derived_penalty_variables B
on A.bbl = B.bbl
where A.party_type = '2' and A.name <> ''
group by A.name
order by TotalPhase2Penalty desc;


/*
 * Rank lenders by number of open liens
 */
select name as lenders, bbl from feed_acris_mortgage_info A
where party_type = '2' and name='UBS REAL ESTATE INVESTMENTS INC.'


select name as lenders, count(bbl) as totalbbls from feed_acris_mortgage_info A
where party_type = '2'
group by lenders
order by totalbbls desc;



/*
 * Building use types by area
 */
select largest_property_use_type, sum(largest_property_use_type_gross_floor_area) as TotalAreasqfoot
from feed_ll84_bbl A
group by largest_property_use_type
order by TotalAreasqfoot desc;

select second_largest_property_use_type, sum(second_largest_property_use_type_gross_floor_area) as TotalAreasqfoot
from feed_ll84_bbl A
group by second_largest_property_use_type
order by TotalAreasqfoot desc;

select third_largest_property_use_type , sum(third_largest_property_use_type_gross_floor_area) as TotalAreasqfoot
from feed_ll84_bbl A
group by third_largest_property_use_type
order by TotalAreasqfoot desc;


/*
 * Building use types by Total LL97 carbon
 * Building use types by average carbon intensity
 * Building use types by added penalties phase 1
 * Building use types by added penalties phase 2
 * - These queries would give incorrect results because of the way we compute penalties.
 * e.g. we can get the top polluting BBl and get its largest use type
 * - but that doesn't mean that this particular largest use type is the worst across NYC
 */



/*
 * Rank buildings by efficiency score (1-100/letter grade)
 */
select nyc_bin, energy_star_score
from feed_ll84_bbl A
order by energy_star_score desc;



/*
 * Sort buildings by Community Board with more LL97 carbon
 */
select B.community_board, sum(A.total_actual_emission) as TotalEmissions
from derived_penalty_variables A
         left join feed_ll84_bbl B
                   on A.bbl = B.bbl
group by B.community_board
order by TotalEmissions desc;


/*
 * Sort buildings by Council district with more LL97 carbon
 */
select B.council_district, sum(A.total_actual_emission) as TotalEmissions
from derived_penalty_variables A
         left join feed_ll84_bbl B
                   on A.bbl = B.bbl
group by B.council_district
order by TotalEmissions desc;



/*
 * Sort buildings by NTA - US CENSUS neighborhoods
 */
select B.nta, sum(A.total_actual_emission) as TotalEmissions
from derived_penalty_variables A
         left join feed_ll84_bbl B
                   on A.bbl = B.bbl
group by B.nta
order by TotalEmissions desc;


/*
 * Sort buildings by US CENSUS tract
 */
select B.census_tract, sum(A.total_actual_emission) as TotalEmissions
from derived_penalty_variables A
         left join feed_ll84_bbl B
                   on A.bbl = B.bbl
group by B.census_tract
order by TotalEmissions desc;







