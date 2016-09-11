#  "http://www.pythonscraping.com/exercises/exercise1.html"
#  "http://stackoverflow.com/questions/22403871/content-length-should-be-specified-for-iterable-data-of-type-class-dict"
from urllib.request import urlopen;
from urllib.request import Request;
from urllib.error import URLError;
from bs4 import BeautifulSoup;
try :
    headers = {
        "user-agent": "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_5)",
        "accept": "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8",
        "accept-charset": "ISO-8859-1,utf-8;q=0.7,*;q=0.3",
        "accept-encoding": "gzip,deflate,sdch",
        "accept-language": "en-US,en;q=0.8",
    };
    req = Request("http://stackoverflow.com/questions/22403871/content-length-should-be-specified-for-iterable-data-of-type-class-dict", headers = headers);
    html = urlopen(req);    
    bsObj = BeautifulSoup(html.read(), "html.parser");
    print(bsObj.h1);
except URLError as e:
    print(e);
    print("Please if check the site is available");
else:
    print("Loaded The site");