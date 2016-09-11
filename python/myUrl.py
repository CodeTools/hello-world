import os;
import urllib;
import re;
#import cPickle;
#import HTMLParser;
import requests;
import time;
import json;

my_Url = "http://192.168.1.1/html/home.html";
try:
    stream = urllib.urlopen(my_Url);
except Exception as e:
    print(e);