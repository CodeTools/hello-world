var express = require('express');
var router  = express.Router();

/* Post Login listing  */
router.post('/', function(req, res, next) {
    console.log(req.body.userName);
    console.log(req.body.password);
    res.render('index', { title: 'My Site' });
});

module.exports = router;