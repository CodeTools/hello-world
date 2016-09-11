# python program to handle sets
sizeOfFirstSet = input();
setOne = set(list(map(int, input().split())));
sizeOfSecondSet = input();
setTwo = set(list(map(int, input().split())));
list  = [];
for x in setOne.difference(setTwo):
    list.append(x);
for x in setTwo.difference(setOne):
    list.append(x);
list.sort();
for x in list:
    print(x);

