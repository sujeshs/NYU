#General objective:
Our objective in creating the database is to identify the dirtiest buildings (by Metric Tons CO2e), the owners of the dirtiest buildings, the mortgage lenders that have financed the dirtiest buildings, and the fines that will apply in 2024, 2030 and 2035.

Queries/Analysis – ideally, we would create an interface that would allow the user to quickly easily perform the following analysis:

For NYC as a whole and for each borough:

1)    Rank buildings by total carbon - check with Alejandro
2)    Rank buildings by carbon intensity - check with Alejandro
3)    Sort buildings into groups of buildings under common ownership (in the case of buildings held by an LLC infer common ownership of contact details are similar)
  - select owner and give me top 10 buildings
  - find owners of top 10 polluting buildings
4)    Rank ownership groups by carbon intensity
5)    Rank ownership groups by total carbon
6)    Rank lenders by carbon intensity (by weighted average carbon intensity of lending portfolio – where weights are the notional of each NYC mortgage/total NYC mortgage portfolio)
7)    Rank lenders by total carbon (for each lender sum the carbon emissions of every building the lender has lent against).
8)    Sort building into occupancy groups
9)    Rank occupancy groups by total carbon
10) Rank occupancy groups by carbon intensity
11) Rank buildings by total 2024, 2030 & 2035 fines
12) Rank buildings by 2024, 2030 & 2035 fines per square foot
13) Rank NYC agencies by total carbon
14) Rank NYC agencies by carbon intensity
15) Rank by energy source and use
16) Rank by efficiency score

Some queries that can be obtained after a connection  with PLUTO and other sources:
1) By whether located in historic district
2) By whether located in Opportunity Zone
3) By demographics and neighborhood
4) By Council district, Congressional district
5) Identifies whether it is occupied by a CIG.

A few ad hoc calculations (that we don’t really need this application to perform):

1) Total carbon of NYC owned buildings as % of total carbon of all NYC buildings (or all NYC buildings > 25k square feet).
2)  Total carbon of NYC owned buildings in each borough as % of total carbon of all buildings in the borough (or all buildings in the borough > 25k square feet).
3) Total carbon of all CIGS as % of total carbon of all NYC buildings (or all NYC buildings > 25k square feet).
4) Total carbon of all CIGS in Manhattan as % of total carbon of all buildings in Manhattan (or all buildings in Manhattan > 25k square feet).


Scenario - filter - map view - table view
