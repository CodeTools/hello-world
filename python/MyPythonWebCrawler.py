import pickle;
import time;
import urllib.request;
import random;
import threading;
url = "http://192.168.1.1/html/home.html"
response = urllib.request.urlopen('http://python.org/')
html = response.read()
print(html);