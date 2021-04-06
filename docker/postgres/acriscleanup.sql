
delete from stern.feed_acris_mortgage_info where document_id is null or document_id=''

DELETE FROM
    stern.feed_acris_mortgage_info a
        USING stern.feed_acris_mortgage_info b
WHERE
    a.id < b.id
    AND a.bbl = b.bbl
    AND a.party_type = b.party_type
    AND a.document_id = b.document_id;
