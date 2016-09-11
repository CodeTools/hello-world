# "http://www.pythonscraping.com/exercises/exercise1.html"
# https://www.google.co.in/?gws_rd=ssl#q=web+scraping+python+3
from urllib.request import urlopen;
from urllib.error import HTTPError;
from bs4 import BeautifulSoup;

def getTitle(url):
    try:
        html = urlopen(url)
    except HTTPError as e:
        return None;
    try:
        bsObj = BeautifulSoup(html.read(), 'html.parser');
        title = bsObj.body.h1;
    except AttributeError as e:
        return None;
    return title;
title = getTitle("https://www.google.co.in/?gws_rd=ssl#q=web+scraping+python+3");
if title == None:
    print("Title could not be found");
else:
    print(title);




def getBody(url):
    try:
        html = urlopen(url)
    except HTTPError as e:
        return None;
    try:
        bsObj = BeautifulSoup(html.read(), 'html.parser');
        title = bsObj.body.h2;
    except AttributeError as e:
        return None;
    return title;
title = getTitle("https://www.google.co.in/?gws_rd=ssl#q=web+scraping+python+3");
if title == None:
    print("Title could not be found");
else:
    print(title);



if __name__ == "__main__":

    # you can pass in a keyword to search for when you run the script
    # be default, we'll search for the "web scraping" keyword
    try:
        keyword = sys.argv[1];
    except IndexError:
        keyword = "web scraping";

    getTitle(keyword);