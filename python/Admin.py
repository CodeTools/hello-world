import pickle;
import time;
import urllib.request;
import random;
import threading;
import html;
from html.parser import HTMLParser;


url = "http://192.168.1.1/html/home.html"
response = urllib.request.urlopen(url);
html = response.read();
print(html);