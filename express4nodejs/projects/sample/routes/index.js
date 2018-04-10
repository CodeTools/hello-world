var express = require('express');
var router = express.Router();
var logger = require('morgan');
var cookieParser = require('cookie-parser');
var bodyParser = require('body-parser');
var dev = require('./../config/dev.js');
var db = require('./../db.js');



/* GET home page. */
router.get('/', function(req, res, next) {
  res.render('index', { title: 'My Site' });
});


router.post('/', function(req, res, next) {
    console.log('----------------here I come-------------------');

   var isLoaded = db.isLoaded(function(isConnected){
    if(isConnected) {
        console.log('Index Router connected to DB ');
    }
    else
        console.log('something went wrong');
   });




    console.log(req.body);
    console.log(req.body.userName);
    console.log(req.body.password);
    res.render('index', { title: 'My Site' });
})

module.exports = router;