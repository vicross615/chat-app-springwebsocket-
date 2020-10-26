const express = require('express');
const router = express.Router();

const Suscriber = require('../model/suscriber')

router.get('/', async (req, res) =>{

    try{
        const suscribers = await Suscriber.find();
        res.send(suscribers);
    }catch (err) {

    }
})


router.get('/:id', async (req, res) =>{

    try{
        const suscriber = await Suscriber.findById(req.param.id);
        res.send(suscriber);
        console.log(`Fetched suscriber   ${suscriber}`)
    }catch (err) {
        console.log(`Fetching suscriber didnt work ${err}`)
    }
})

router.post('/', async (req, res) => {

    const suscriber= new Suscriber();
        suscriber.name= req.body.name;
        suscriber.age= req.body.age;
        suscriber.location= req.body.location;
    try {
        const savedUser = await suscriber.save(suscriber)
        res.send(savedUser)
    }catch(err) {
        console.log(`saving suscriber didnt work ${err}`)
    }
})



module.exports = router