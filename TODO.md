#Sujesh
1. App accepts only data without spaces and special characters. Enhance this.
1. While loading ll84 populate `No` instead of `blanks` for city building.
1. ~~Get list of BBLs from Miles and check penalty~~

#Questions to Alejandro/ Miles
1. ~~MedicalOffice maps to both B-AmbulatoryHealth and B-Business. which one should I use ?~~
2. ~~I do not see carbon limits for occupancy groups like R1-residential. Does that mean we do not care about these groups ?~~


#Next steps
1. Pull a list of duplicate BBL-BINs in LL84-feed
1. Get soana from Maxwell
1. Get write access to dev environment (postgres-aws) from Maxwell
1. Demo
1. Load into carto




# LL84 cleanup
MOS <- Mayor's office of sustainability
recommended a propery ID and the parent property ID as a way to identify the repeated submissions


if (propertyid != parentpropertyid) {
the current record is a child record
}

if (propertyid == parentpropertyid && is repeated more than once) {
this is a repeated submission consider only the newest one
}

if (propertyid == parentpropertyid && is only once) {
the current record is a parent record
}

if ( parentpropertyid == 'standalone') {
it is standalone
}

BBL = A , Ppid = 'standalone', Pid = 'X', Date = D1 -> standalone property <- elim
BBL = A , Ppid = 'standalone', Pid = 'X', Date = D1+3 -> standalone property & take this as recent
BBL = A , Ppid = 'X', Pid = 'X', Date = D1 -> parent record <- elim
BBL = A , Ppid = 'X', Pid = 'X', Date = D1+20 -> parent record & repeated submission - so take this because it is latest date
BBL = A , Ppid = 'X', Pid = 'Y', Date = D1 -> child record < elim
BBL = A , Ppid = 'X', Pid = 'Y', Date = D1+5 ->  child record & repeated submission - so take this because it is latest date



BBL = A , Ppid = 'standalone', Pid = 'X', Date = D1+3 -> standalone property & take this as recent <- `standalone property` is an exclusive value
BBL = A , Ppid = 'X', Pid = 'X', Date = D1+20 -> parent record & repeated submission - so take this because it is latest date
BBL = A , Ppid = 'X', Pid = 'Y', Date = D1+5 ->  child record & repeated submission - so take this because it is latest date
BBL = A , Ppid = 'X', Pid = 'Z', Date = D1+5 -> second


First load the ll84
Run a DQ check and mark records into the above categories
Then run the penalty calculator



UI search category -> BBL, address, BIn code
BBL, BIN code - Pid , PPid - penalty values <- parent level
BBL, BIN code - Pid , PPid - penalty values <- child 1
BBL, BIN code - Pid2 , PPid - penalty values <- child 2
