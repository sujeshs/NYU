# Python pre-requisites - install these before you run the actual program
# 
# python3 -m pip install psycopg2-binary
# python3 -m pip install sqlalchemy
# python3 -m pip install sodapy
# python3 -m pip install pandas


import pandas as pd
import time
from sodapy import Socrata
from sqlalchemy import create_engine

open_data_src = 'bnx9-e6tj'                                     # Each open-data source has a tag associated, use that here
open_data_app_token='1uPvCkPCFgGbXHlo7xvqUcI7i'                 # If this is not provided, the program will be throttled by open-data
open_data_request_timeout_in_seconds=3600                         # change this if you start seeing timeouts
open_data_chunk_size=30000                                       # for pagination; indicates how many records you want to read at a time
open_data_start_position=0                                      # starting record-position for reading the open-data records
postgres_url='postgresql://postgres:postgrespw@localhost:55000' # replace with your postgres url
postgres_table_name='bnx9_e6tj'                                 # replace with your postgres table; if table doesn't exist, the program will create it
postgres_chunk_size = 10000                                      # Insert 1000 rows at a time into postgres

start_time = time.time()

client = Socrata("data.cityofnewyork.us", open_data_app_token)
client.timeout = open_data_request_timeout_in_seconds

# Get record counts
record_count = client.get("bnx9-e6tj", select="COUNT(*)")
print('Total records to be loaded : '+str(record_count[0]['COUNT']))

# connect to postgres
engine = create_engine(postgres_url)


while True:

    # readfirst chunk from open-data
     df_current_chunk = pd.DataFrame.from_records(client.get("bnx9-e6tj", offset=open_data_start_position, limit=open_data_chunk_size))

    # persist current chunk into postgres
     df_current_chunk.to_sql(postgres_table_name, engine, if_exists='append', chunksize=postgres_chunk_size)

     # Move up the starting record
     open_data_start_position = open_data_start_position + open_data_chunk_size

     print('Now loading data from offset position : ' + str(open_data_start_position))

     # If we have fetched all of the records, bail out
     if (open_data_start_position > int(record_count[0]['COUNT']) ):
        break

print('Finished loading ' + str(record_count) + ' records from open-data-source "' + open_data_src + '" into postgres table "' + postgres_table_name + '" in ' + str(time.time() - start_time) + ' seconds')
