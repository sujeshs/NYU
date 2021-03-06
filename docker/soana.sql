WITH subquery AS (
    SELECT mail_careof, mail_address_1
    FROM feed_soana
)
UPDATE feed_soana
SET mail_careof = subquery.mail_careof
FROM subquery
WHERE
        feed_soana.mail_careof =''  AND
        feed_soana.mail_address_1 = subquery.mail_address_1;
