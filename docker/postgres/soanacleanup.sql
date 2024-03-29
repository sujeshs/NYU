-- delete rows that do not have bbls from ll84
DELETE
FROM stern.feed_soana
WHERE bbl NOT IN (SELECT f.bbl
                  FROM stern.feed_ll84_bbl f);

-- backfill mail_careof using mail_address_1 match from other records
WITH subquery AS (
    SELECT mail_careof, mail_address_1
    FROM stern.feed_soana
)
UPDATE stern.feed_soana
SET mail_careof = subquery.mail_careof
FROM subquery
WHERE stern.feed_soana.mail_careof = ''
  AND stern.feed_soana.mail_address_1 = subquery.mail_address_1;


