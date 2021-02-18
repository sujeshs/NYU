/* Rank buildings by total carbon */
select A.bbl, A.total_actual_emission
from derived_penalty_variables A
         left join feed_ll84_bbl B
                   on A.bbl = B.bbl
group by A.bbl, A.total_actual_emission
order by total_actual_emission desc
    fetch first 10 rows only;

/* Rank NYC agencies by total carbon */
select A.bbl, A.total_actual_emission
from derived_penalty_variables A
         left join feed_ll84_bbl B
                   on A.bbl = B.bbl
where B.city_building = 'Yes'
group by A.bbl, A.total_actual_emission
order by total_actual_emission desc
    fetch first 10 rows only;

/* Rank buildings by total 2024 fines */
select A.bbl as BBL, A.emission_penalty_2024_2029 as Fines_2024
from derived_penalty_variables A
         left join feed_ll84_bbl B
                   on A.bbl = B.bbl
where B.city_building = 'Yes'
group by A.bbl, A.emission_penalty_2024_2029, A.phase1_penalty
order by phase1_penalty desc
    fetch first 10 rows only;

/* Rank buildings by total 2024 fines */
select A.bbl as BBL, A.emission_penalty_2024_2029 as Fines_2024
from derived_penalty_variables A
         left join feed_ll84_bbl B
                   on A.bbl = B.bbl
where B.city_building = 'Yes'
group by A.bbl, A.emission_penalty_2024_2029, A.phase1_penalty
order by phase1_penalty desc
    fetch first 10 rows only;

/* Rank occupancy groups by sq foot */
select largest_property_use_type,
       sums,
       counts,
       total,
       (counts * 100) / total as percentage
from (
         select largest_property_use_type                       as largest_property_use_type,
                sum(largest_property_use_type_gross_floor_area) as sums,
                count(largest_property_use_type)                as counts,
                (select count(*) from feed_ll84_bbl)            as total
         from feed_ll84_bbl
         group by largest_property_use_type
         order by sums desc
     ) t;
