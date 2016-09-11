# Stock Calculator


print(" Stock calculator ");
observations = int(input("Enter the number of observations for earnings?"));
number = observations;
price = float(input("Enter the CMP:"))
print(" Entering the observations ");
sum = 0.0;
while observations > 0 :
  data = float(input("Enter earnings :"));
  sum = sum + data;
  observations = observations - 1;

avg_earnings = sum / number;
yield = (avg_earnings / price) * 100;
print(" Sum of Earnings " + str(sum) );
print(" Avg of earnings " + str(avg_earnings));
print(" Yield " + yield);

# End of Program