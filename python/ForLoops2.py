#
#
#
# For Loops Two in Python :Sum and Average
#
#
limit = int(input("Enter the number of observations:"));
sum = 0;
avg = 0.0;
if(limit > 100 or limit < 0):
    print("Limit must less than 100 and greater than 0.");
    limit = 0;
for x in range (0, limit):
    y = int(input("Enter argument " + str(x) + " : "));
    print("y(" + str(x) + ") = "+ str(y));
    sum = sum + y;
if(limit != 0) :
    avg = sum / limit;
    print("Sum = " + str(sum));
    print("Avg = " + str(avg));