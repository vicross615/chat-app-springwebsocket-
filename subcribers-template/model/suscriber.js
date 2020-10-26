const mongoose = require('mongoose')


const SUSCRIBER = new mongoose.Schema({
    name: {
        type: String,
        required: true
    },
    age: {
        type: Number
    },
    location: {
        type: String,
        required: true
    }
})

module.exports = mongoose.model('suscriber', SUSCRIBER)