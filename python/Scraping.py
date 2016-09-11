#  "http://www.pythonscraping.com/exercises/exercise1.html"
from urllib.request import urlopen;
from bs4 import BeautifulSoup;
try :
    html = urlopen("http://www.pythonscraping.com/exercises/exercise1.html");
    bsObj = BeautifulSoup(html.read(), "html.parser");
    print(bsObj.h1);
except HTTPError as e:
    print(e);
    print("Please if check the site is available");
else:
    print("Loaded The site");