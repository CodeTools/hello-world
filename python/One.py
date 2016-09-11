import functools;
# Simple Program to run a few Progress
def add(x, y): return x + y

# The Main program
print("==================================")
print("Progress Report")
print("==================================")


subjects = int(input("Enter the numbers of Subjects:"));
students = int(input("Input the number of Students:"));
while(students > 0)  :
   students = students - 1 ;
   list = [];
   count = 0;
   name = input("Enter the name of the student:");
   while(count < subjects) :
       marks = float(input("Enter marks for subject :"));
       list.append(marks);
       count = count + 1;
   sum = functools.reduce(add, list);
   avg = sum / subjects;
   print(name);
   print(students);
   print(avg);




