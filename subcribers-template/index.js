const express = require('express');
const app = express();


const mongoose = require('mongoose');
const url = 'mongodb://localhost/suscriber';
const con = mongoose.connection


const suscriberRouter = require('./routers/route')

app.use(express.json())
app.use('/suscribers', suscriberRouter)








mongoose.connect(url, {useNewUrlParser: true});
con.on('open', function( ) {
    console.log('connected.......')
})

app.listen(9000, function() {
    console.log('server started')
})