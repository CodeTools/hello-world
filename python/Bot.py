# "http://www.pythonscraping.com/exercises/exercise1.html"
# https://en.wikipedia.org/robots.txt
import requests
response = requests.get("http://www.pythonscraping.com/exercises/exercise1.html");
txt = response.text;
print(txt);