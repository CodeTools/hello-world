# Capitalize The String 
s = input("");
a = s.split(" ");
r = "";
for count in range(0, len(a)):
    r = r + a[count].capitalize() + " ";
print(r.strip());