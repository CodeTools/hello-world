var mongoDB = require('mongoose');
var dev = require('./config/dev.js');

// load DB config from the config.js
var error = '';
var db = mongoDB.createConnection(dev.db.url, function (err, res) {
   if(err)
   {
     console.log('Error connected: ' + dev.db.url + ' -  ' + err);
     error = err;
   }
   else
   {
     console.log('Success connected: ' + dev.db.url);
   }
}
);




// Add Schema in DB
db.on("error", function(error) {
    console.log("connection exception", err);
});


// Once db is open create and load schema

var Schema = mongoDB.Schema;
var User  = new Schema({
        name:String,
        userName: { type: String, required: true, unique: true},
        passWord: { type: String, required:true },
        admin:   Boolean,
        meta: {
            age: Number,
            website: String
        },
        createdAt: Date,
        updatedAt: Date
    });
mongoDB.model('Users', User);
var Users  = mongoDB.model('Users');


// Provide a call back for external modules to check if we are connected
function isLoaded(callback) {
    if(error) {
         callback(false);

    }
    else  {
         callback(true);

    }
}

// var to store a function
function create(name , password) {
    new Users(
        {
        userName : name,
        passWord : password
        }
)
}





// Expose or Export the DB, callback and the Model.
module.exports = db;
module.exports.isLoaded = isLoaded;
module.exports.Users = Users;
module.exports.create = create;