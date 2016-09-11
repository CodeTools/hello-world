import argparse
#
#
# Python Script to read a File : by default reads itself. Else it provided a file name will read the same
#
#
# 
# 
# 
parser = argparse.ArgumentParser();
parser.add_argument("-file", "--fileName", dest = "fileName", default = "MyFileReader.py", help="File name");
parser.add_argument("-c", "--count", dest = "count", default = 0, help="number of line displayed at a time");
args = parser.parse_args();
print( "FileName {} Number of Lines {} ".format(args.fileName, args.count));
#
#
#
#
fObj = open(args.fileName);
nol = 1;
count = int(args.count);
for line in fObj:
    if(count != 0 and nol % count == 0):
        input("Press Enter to continue:");
    print(line.rstrip());
    nol = nol + 1;
fObj.close();
# 
# 
# End of Python Script
#