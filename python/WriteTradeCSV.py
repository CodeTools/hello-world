# copied from this website https://docs.python.org/3/library/csv.html#csv-fmt-params

import csv;

with open('Trades.csv', 'w') as csvfile:
    fieldnames = ['dealt', 'contra', 'dealtRate', 'traderRate', 'dealtCurrency', 'baseCurrency', 'termCurrency']
    writer = csv.DictWriter(csvfile, fieldnames=fieldnames)

    writer.writeheader()
    writer.writerow({'dealt': '100', 'contra': '160', 'dealtRate': '1.60', 'traderRate': '1.601', 'dealtCurrency': 'USD', 'baseCurrency': 'INR', 'termCurrency': 'INR' });
    writer.writerow({'dealt': '100', 'contra': '160', 'dealtRate': '1.60', 'traderRate': '1.601', 'dealtCurrency': 'USD', 'baseCurrency': 'INR', 'termCurrency': 'INR' });
    writer.writerow({'dealt': '100', 'contra': '160', 'dealtRate': '1.60', 'traderRate': '1.601', 'dealtCurrency': 'USD', 'baseCurrency': 'INR', 'termCurrency': 'INR' });