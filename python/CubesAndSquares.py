# Using the Join method 
for x in range (1, 100):
    s = "-";
    seq = (str(x), str(x * x), str(x * x * x));
    print(s.join(seq));
