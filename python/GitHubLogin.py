"""Example app to login to GitHub"""
import argparse
import mechanicalsoup

parser = argparse.ArgumentParser(description='Login to GitHub.')
parser.add_argument("username")
parser.add_argument("password")
args = parser.parse_args()
print("Taken Args");

browser = mechanicalsoup.Browser();
print("Loaded Browser");

# request github login page. the result is a requests.Response object http://docs.python-requests.org/en/latest/user/quickstart/#response-content
login_page = browser.get("https://github.com/login")
login_page.raise_for_status()  # similar to assert login_page.ok but with full status code in case of failure.
print("status page");

# login_page.soup is a BeautifulSoup object http://www.crummy.com/software/BeautifulSoup/bs4/doc/#beautifulsoup 
# we grab the login form
login_form = login_page.soup.select_one('#login form')
print("got form");

# specify username and password
login_form.input({"login": args.username, "password": args.password})
print("got input");

# submit form
page2 = browser.submit(login_form, login_page.url);
print("page 2");

# verify we are now logged in
messages = page2.soup.find('div', class_='flash-messages');
print("messages");
if messages:
    print(messages.text)
assert page2.soup.select(".logout-form")
print("logouts");

print(page2.soup.title.text)

# verify we remain logged in (thanks to cookies) as we browse the rest of the site
page3 = browser.get("https://github.com/hickford/MechanicalSoup")
assert page3.soup.select(".logout-form")