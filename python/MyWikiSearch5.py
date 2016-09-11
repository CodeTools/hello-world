import urllib.request;
import sys;
from bs4 import BeautifulSoup;

#sys.stdout.encoding='utf-8';

url = 'https://en.wikipedia.org/wiki/Algorithm';
req = urllib.request.Request(url);
req.add_header('Accept', 'application/json, text/javascript, */*; q=0.01');
req.add_header('Content-Type', 'application/x-www-form-urlencoded; charset=UTF-8');
req.add_header('X-Requested-With', 'XMLHttpRequest');
s = urllib.request.urlopen(req);

soup = BeautifulSoup(s, 'html.parser');
print(soup.title);
print(soup.find_all('h1'));

for page in soup.find_all('h2'):
    print(page.id);

print("End of Program");
