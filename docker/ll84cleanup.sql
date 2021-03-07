WITH subquery AS
         (
             SELECT bbl
                  ,generation_date
                  ,ROW_NUMBER() OVER(PARTITION BY bbl, generation_date ORDER BY generation_date DESC) AS rNum
             FROM feed_ll84_bbl
         )
DELETE
FROM subquery
WHERE rNum > 1


select bbl,count(*) as occurence
from feed_ll84_bbl  group by bbl order by bbl,occurence desc
