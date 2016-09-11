import urllib;
import urllib.parse;
import urllib.request;
import json as m_json;
import sys

print( sys.stdout.encoding);

query = input ('Query: ')
query = urllib.parse.urlencode({ 'q' : query })
response = urllib.request.urlopen('https://developers.google.com/custom-search/?v=1.0&' + query);
bytes = response.read();
print(bytes);
print('No Error Till Here');
f = open('workfile', 'w');
#f.write(bytes);
f.write(bytes.decode(sys.stdout.encoding, errors='replace'));
f.close();






