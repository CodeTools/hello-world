import itertools;


def function(i):
    return i+1;

print(itertools.count(10));
print(function(10));
print(imap(function, count(10)));