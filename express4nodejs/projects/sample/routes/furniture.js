var express = require('express');
var router  = express.Router();

/* GET user listing  */
router.get('/', function(req, res, next) {
    res.render('furniture', {title:'WorkShop'});
});

module.exports = router;