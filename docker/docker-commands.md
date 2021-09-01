1. docker cp /Users/sujeshs/IdeaProjects/NYU/docker/dump_02-06-2021_08_27_37.sql stern-local-postgres:/docker-entrypoint-initdb.d/dump.sql
1. docker exec -u postgres stern-local-postgres psql postgres postgres -f docker-entrypoint-initdb.d/dump.sql
1. docker exec -it stern-local-postgres psql -U postgres -P postgres -f /Users/sujeshs/IdeaProjects/NYU/docker/dump_02-06-2021_08_27_37.sql
1. docker exec -t stern-local-postgres pg_dumpall -c -U postgres > ./export.sql

```
UPDATE stern.consolidated_report A
SET lien_name = array_append(lien_name, B."Name")
FROM stern.openliendata B
WHERE A.bbl like B.bbl;
```
