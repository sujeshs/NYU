#!/usr/bin/env python

# make sure to install these packages before running:
# pip install pandas
# pip install sodapy

import pandas as pd
from sodapy import Socrata

// reading 15945489 records
results = client.get("bnx9-e6tj", limit=15945489)

# Convert to pandas DataFrame
results_df = pd.DataFrame.from_records(results)
