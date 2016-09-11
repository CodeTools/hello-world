# Hagi Pugi Simple Home Calculator for Ghar Ka Kharcha
# 
# 
# Import Date and Time
from datetime import datetime
now = datetime.now();
print(" Simple Calculator (c) Sanjay Ghosh " + str(now))
items = int(input('Number of Items?'));
print(" ready to calculate  ", items, "\r\n");
sum = 0.0;
while items > 0 :
  data = float(input("Enter Item: "));
  sum = data + sum;
  items = items - 1;

print (" Total sum is =", sum);

