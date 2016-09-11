# Lists in python
x = int(input());
y = int(input());
z = int(input());
n = int(input())
list_x = [ loop for loop in range(x + 1) ];
list_y = [ loop for loop in range(y + 1) ];
list_z = [ loop for loop in range(z + 1) ];
list = [];
for loopx in list_x:
    for loopy in list_y:
        for loopz in list_z:
            if (loopx + loopy + loopz) == n:
                continue;
            else:
                myList = [loopx, loopy, loopz];
                list.append(myList);
print(list);