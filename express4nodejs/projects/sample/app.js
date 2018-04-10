var express = require('express');
var path = require('path');
var favicon = require('serve-favicon');
var logger = require('morgan');
var cookieParser = require('cookie-parser');
var bodyParser = require('body-parser');
var dev = require('./config/dev.js');
var db = require('./db.js');

var routes = require('./routes/index');
var users = require('./routes/users');
var furniture = require('./routes/furniture');
var login = require('./routes/login');

var app = express();

// set the View Engine to be Jade
app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'jade');

// Uncomment below logging to check what your are getting
db.isLoaded(function(isConnected){
    if(isConnected) {
    console.log('Connected to db');
    console.log(db.Users);
    db.create('Rony', '123');
    db.create('Manav', '123');
    }
    else console.log('something went wrong');
});


// uncomment after placing your favicon in /public
// app.use(favicon(path.join(__dirname, 'public', 'favicon.ico')));



// Add layer by layer of middle war support to express
//app.use(logger('dev'));// Logging
app.use(logger(':method :url :status :res[content-length] - :response-time ms'));
app.use(bodyParser.json());// JSON parser
app.use(bodyParser.urlencoded({ extended: false }));// URL encoding
app.use(cookieParser());// the cookie Parser
app.use(express.static(path.join(__dirname, 'public')));// DO NOT Know what it does! some Black Magic

app.use('/', routes);
app.use('/users', users);
app.use('/furniture',furniture);
app.use('/login', login);

// catch 404 and forward to error handler
app.use(function(req, res, next) {
  var err = new Error('Oops It seems some new shift has happened.'); // print the follwoing line in case the router is not able to find
  err.status = 404;
  next(err);
});

// error handlers

// development error handler
// will print stacktrace
if (app.get('env') === 'development') {
  app.use(function(err, req, res, next) {
    res.status(err.status || 500);
    res.render('error', {
      message: err.message,
      error: err
    });
  });
}

// production error handler
// no stacktraces leaked to user
app.use(function(err, req, res, next) {
  res.status(err.status || 500);
  res.render('error', {
    message: err.message,
    error: {}
  });
});


module.exports = app;