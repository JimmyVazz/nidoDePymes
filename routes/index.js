const express = require('express');
const router  = express.Router();
const https =  require('https');
const {objetoFeik} = require('../api')


/* GET home page */
router.get('/', (req, res, next) => {
  res.render('index');
});

router.get('/registro/emprendedores', (req, res) => {
  res.render('registroEntre')
})

router.get('/registro/pymes', (req, res) => {
  res.render('registroPyme')
})

router.get('/home/emprendedores/', (req, res) => {
  res.render('homeEmpre')
})

router.get('/home/pymes/', (req, res) => {
  res.render('datosCuenta')
})

router.get('/api/', (req, res, next) =>{
  res.json({objetoFeik})
})

module.exports = router;
