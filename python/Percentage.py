number_of_records = int(input());
my_dict = {};
for record in range(0, number_of_records):    
    arr = input().split(" ");    
    my_dict[arr[0]] = round (  ( ( float(arr[1]) + float(arr[2]) + float(arr[3])) / 3.00 ), 2 );
    #print(my_dict);
key = input();
print('{0:.2f}'.format(my_dict[key]));
    