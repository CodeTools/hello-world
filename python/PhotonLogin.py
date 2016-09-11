from bs4 import BeautifulSoup;
import urllib.request;
import codecs;


with urllib.request.urlopen('http://192.168.1.1/html/home.html') as response:
    #  FormattedHTML.html
    html = response.read();     


    #  FormattedHTML.html
    html_docs = codecs.decode(html, "UTF-8");

    soup = BeautifulSoup(html_docs,"html.parser");
    print(soup.prettify());






