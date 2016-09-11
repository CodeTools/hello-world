import functools;
# Simple Program to calculate Discounted value
def add(x, y): return x + y

# The Main program
print("=============================================")
print("Simple Program to calculate Discounted value ")
print("=============================================")


amount = float(input("Enter the amount(float):"));
years = int(input("Enter the number of years(integer):"));
rate = float(input("Enter the rate of growth/interest(float):"));
rate = rate / 100;
rate = rate + 1;
print(str(rate));
term = years;
while(years > 0)  :
   years = years - 1;
   amount = amount / rate;
   print(' Amount ' + str(amount) + ' for year  ' + str(term - years));
print(amount);
input("");