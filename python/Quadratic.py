# Quadratic 
#
# Solves Quadratic Equations
#
# 
a = int(input('Enter the value of a:'));
b = int(input('Enter the value of b:'));
c = int(input('Enter the value of c:'));

x = 0;
y = 0;
print('calculating ax^2 + by + c');
for x in range(0, 2):    
    for y in range(0, 2):
        print(' x = ', x);
        print(' y = ', y);
        z = (x * x) * a + y * b + c;
        print(' z = ', z);
       
    
    