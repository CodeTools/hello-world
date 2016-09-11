import urllib.request;
with urllib.request.urlopen('http://192.168.1.1/html/home.html') as response:
   html = response.read();
   print(html);