#
#
# For Loops Three in Python : Sum and Average the EPS of a common Stock
# Only 100 observations are permitted (only 10 matter after that 'disruptive innovation'
# takes over ) 
#
#
#
limit = int(input("Enter the number of EPSs:"));
sum = 0.0;
avg = 0.0;
if(limit > 100 or limit < 0):
    print("Limit must less than 100 and greater than 0.");
    limit = 0;
for x in range (0, limit):
    y = float(input("Enter argument " + str(x) + " : "));
    print("y(" + str(x) + ") = "+ str(y));
    sum = sum + y;
if(limit != 0) :
    avg = sum / limit;
    print("Sum of Prices = " + str(sum));
    print("Avg of Prices = " + str(avg));