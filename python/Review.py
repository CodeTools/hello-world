number = int(input());
for i in range (0, number):
    string = input();
    odd = "";
    even = "";
    for j in range (1, len(string), 2):
        odd = odd + string[j];
    for k in range (0, len(string), 2):
        even = even + string[k];
    print(even + " " + odd);