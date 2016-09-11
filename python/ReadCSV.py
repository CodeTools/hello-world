# copied from this website https://docs.python.org/3/library/csv.html#csv-fmt-params


import csv;
with open('names.csv') as csvfile:
    reader = csv.DictReader(csvfile)
    for row in reader:
        print(row['first_name'], row['last_name'])
