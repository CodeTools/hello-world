# *************************************************************************
# Simple Server  1.0
# *************************************************************************
import time;
import http.server;
import socketserver;

PORT = 8080;
HOST_NAME = 'localhost' # !!!REMEMBER TO CHANGE THIS!!!


class MyHandler(http.server.SimpleHTTPRequestHandler):
  def do_HEAD(s):
    s.send_response(200);
    s.send_header("Content-type", "text/html");
    s.end_headers();
  def do_GET(s):
    """Respond to a GET request."""
    print("GET Request started");
    s.send_response(200);
    s.send_header("Content-type", "text/html");
    s.end_headers();
    s.wfile.write(b"<html><head><title>My First Page in Python.</title></head>");
    s.wfile.write(b"<body><p>This is a test page.</p>");
    # If someone went to "http://something.somewhere.net/foo/bar/",
    # then s.path equals "/foo/bar/".    This can be used to separate content
    s.wfile.write(("<p>You accessed path " + str(s.path) + str("</p>")).encode("UTF-8"));    
    s.wfile.write(b"</body></html>");
    print("GET Request completed");


httpd = socketserver.TCPServer((HOST_NAME, PORT), MyHandler);
print("serving at port", PORT);
print(time.asctime(), "Server Starts - %s:%s" % (HOST_NAME, PORT));
httpd.serve_forever();