import sys;
# Returning to python programming after a long time
#
# Nothing fancy just stuff
name = input('what is your name?\n');
print( 'Hi ', name);
print( 'Welcome to the Python 3 world.');
number = int(input('Input any number'));
array = [];
count = 0;
print(number);
while(count < number):
    array.append(count);
    count = count + 1;
print("Enumerating numbers ", array);
count = 0;
array = [];
while(count < number):
    array.append(count * count);
    count = count + 1;
print("Enumerating Squares ", array);