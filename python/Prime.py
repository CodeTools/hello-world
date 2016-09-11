#
#
# Prime.py
#
#
def firstPrime():
    result = [];
    result.append(2);#2
    result.append(3);#3
    result.append(5);#5
    result.append(7);#7
    result.append(11);#11
    result.append(13);#13
    result.append(17);
    result.append(19);
    result.append(23);
    result.append(29);
    result.append(31);
    result.append(37);
    result.append(41);
    result.append(43);
    result.append(47);
    result.append(53);
    result.append(59);
    result.append(61);
    result.append(67);
    result.append(71);
    result.append(73);
    result.append(79);
    result.append(83);
    result.append(89);
    result.append(97);
    result.append(101);    
    return result;





def prime():
    result  = firstPrime(); 
#{2, 3, 5, 7, 11, 13, 17, 19};
    natural = [];
    for number in range(102, 10200):        
        isPrime = True;
        for prime in result:            
            if(number % prime == 0 and number != prime):
                isPrime = False;
                break;
        if(isPrime):
            result.append(number);
    
    print("Prime");
    return result;




def primeTenKToTenMillion(p):
    r = [];
    print(p);
    for number in range(10201, 90801):
        if(number % 2 != 0 and number % 3 != 0 and number % 5 != 0 and number % 7 != 0 
        and number % 11 != 0 and number % 13 != 0 and number % 17 != 0 and number % 19 != 0):
            print(number);
    return r;



p = prime();
primeTenKToTenMillion(p);
#print(p);


