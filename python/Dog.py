class Dog:

    kind = 'canine'         # class variable shared by all instances

    def __init__(self, name):
        self.name = name    # instance variable unique to each instance


x = Dog('fredo')
print(x.name);
print(x.kind);
