# **************************
# Advanced Stock Calculator
# 47.43	38.66	28.53 26.03	20.27 14.81 10.02 8.46 8.17 10.01
# **************************


print(" Advanced Stock calculator ");
observations = int(input("Enter the number of observations:"));
print("Number of observations is %d" % observations);
count = 0;
sum = 0.0;
previous = 0.0;
diff = 0.0;
rate = 0.0;
rateSum = 0.0;
rateAvg = 0.0;
mylist = [];
while count < observations :
  print("Enter observation [ %d] " % (count + 1));
  current = float(input("?"));  
  mylist.append(current);
  if(count != 0):
    diff = current - previous;
    rate = ( diff / previous ) * 100;  
    rateSum = rate + rateSum;
    print(" Difference [ %d ] " % diff);
    print(" Rate [ %d ] " % rate);  
  sum = sum + current;
  previous = current;
  count = count + 1;
avg = sum / observations;
rateAvg = rateSum / (observations + 1);
print("Average CMP is [ % d] " % avg);
print("Average rate of growth is [ % d ]" % rateAvg);
print("Range of CMP " + str(mylist));
input("");