from bs4 import BeautifulSoup;
import urllib.request;
import codecs;


with urllib.request.urlopen('http://www.moneycontrol.com/financials/ruralelectrificationcorporation/profit-lossVI/REC02') as response:
    #  FormattedHTML.html
    html = response.read();     
    print(html);

    #  FormattedHTML.html
    soup = BeautifulSoup(html,"html.parser", from_encoding="UTF-8");
    #print(soup.prettify());






