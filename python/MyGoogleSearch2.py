import urllib.request;

url = 'https://www.google.co.in';
req = urllib.request.Request(url);
req.add_header('Accept', 'application/json, text/javascript, */*; q=0.01')
req.add_header('Content-Type', 'application/x-www-form-urlencoded; charset=UTF-8')
req.add_header('X-Requested-With', 'XMLHttpRequest')
s = urllib.request.urlopen(req);
print(s.read());
