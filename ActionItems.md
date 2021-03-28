# Attendees
1. Michele Giorgianni
1. David Breeding

# Questions
1. David to give insight on how data is being loaded into the MAP application (API/ stored-proc/ cache <- based on volume,
load everything into app side)


# Action items
1. Load carto with the data
1. Alejandro to send the query patterns
1. David to look at the data and the pattern and recommend filters


# List of things to do
1. LL84:
    1. ~~Alejandro to check the Borough column (it has only Queens) in MOS data and if it is a data quality issue that got
        introduced while creating our merged file,~~ we can use SOANA Borough information because that is accurate
    1. Submission order -> e.g. for a given BBL, also use the property id to get all properties and return only the latest submission
        1009970029 -> 2 records for parent -> 1
        1009970029 -> 2 records for first child -> 1
        1009970029 -> 2 records for second child -> 1
        1009970029 -> 2 records for standalone -> 1
2. Acris:
    - Zach has already provided Acris mortgage info for all 28K LL84 records that we have.
    - We will simply load this into our table.
3. Soana :
    - Sujesh is loading all 5 boroughs (because of network hops and laptop limitations, it is taking a while but this is no blocker for David's work.
    David can use the Carto samples to work on AppGeo development and we can reload the Carto table when we are ready)
    - Mail_care_of query will be run once we load all the 5 borough data into NYU stern DB. (so that we don't have to repeat it over and over)
4. Penalty computation :
    - The data is computed and loaded into Carto -> no work needed here
5. Exceptions : complete (with whatever data we can use for exception calculation)
 - We already have the necessary variables for a lot of the exception criteria across our tables..
 so it is just a matter of writing queries that have these variables in the where clause of sql query.
 e.g. city building - Y/N is in LL84
 religious place of worship - is in LL84
 NYCHA - Y/N is in NYCHA table
 Rentstablisized - Y/N is in rent table
 - Alejandro is gonna work with Elissa (MOS) and map some of the exceptions to tables/columns/instructions that Appgeo can use to apply filters.





