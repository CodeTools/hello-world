N = int(input());
dict_map = {};
for i in range (0, N):
    arr = input().split(" ");
    dict_map[ arr[0] ] = arr[1];
for i in range (0, N):
    key = input();
    try :
        print(key+"="+dict_map[key]);
    except KeyError:
        print("Not found");
    
    