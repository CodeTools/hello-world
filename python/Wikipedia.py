from bs4 import BeautifulSoup;
import urllib.request;
import codecs;


with urllib.request.urlopen('https://en.wikipedia.org/wiki/Category:English-language_films') as response:
    #  FormattedHTML.html
    html = response.read();     
    #print(html);


    # create a working file
    f = open('Category.html', 'w');

    #  FormattedHTML.html
    soup = BeautifulSoup(html,"html.parser", from_encoding="ascii");
    results =  soup.findAll("html");
    for r in results:
        f.write(str(r));
    f.close();






