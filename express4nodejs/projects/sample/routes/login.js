var express = require('express');
var router  = express.Router();

/* Post Login listing  */
router.get('/', function(req, res, next) {
    res.render('login', {title:'Login'});
});

module.exports = router;