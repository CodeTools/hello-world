# Ok this is inspired from some web site 
# but atleast the coding is mine



# Menu Functions
def menu():
    print("This is python calculator v1.0");
    print("");
    print("your options are");
    print("");
    print("1. Add");
    print("2. Substract");
    print("3. Multiply");
    print("");
    print("4. Divide");
    print("5. Exit");    
    return input("Enter your options:");



# Add function
def add(x, y):
    print("");
    print(x, " + ", y , " = " , (x + y));


# Substract function
def substract(x, y):
    print("");
    print(y, " - ", x , " = " , (y - x));


# Multiply function
def multiply(x, y):
    print("");
    print(x, " * ", y , " = " , (x * y));


# Divide function
def divide(x, y):
   print("");
   print(x, " / ", y , " = " , (x / y));



# Main program starts
loop = 1;
choice = 0; 
while (loop == 1) :    
    choice = int(menu());
    if ( choice == 1 ):
        add(int(input("add this:")), int(input("to this:")));
    elif ( choice == 2 ) :
        substract(int(input("Substract this:")), int(input("from this:")));
    elif ( choice == 3 ) :
        multiply(int(input("Multiply this:")), int(input("with this:")));
    elif ( choice == 4 ) :
        divide(int(input("Divide this:")), int(input("with this:")));
    elif ( choice == 5 ) :
        loop = 0;
    else :
        loop = 1;

