const express = require('express');
const router  = express.Router();
const https =  require('https');



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

  var apiKey = "NyQnVHxBny2NGD9OMdwwu4l9dRyPPFCg8MPlD51T" 
  var client = "dde8275bfe3a4120ab04f321dcd6213e"
  var user = "TEAM2"
  var pass = "e273cd6876774506965e58F563C94e32"  

  let url = "https://s0kg6zbefh.execute-api.us-east-1.amazonaws.com/dev/v1/sandbox/clients/9094578/profile" ; // + req.params.term + "/standings";

  var options = {
    host: url,
    method: 'GET',
    headers: {
      'X-api-key': apiKey,
      'X-User': user,
      'X-Client': client,
      'X-Password': pass
    }
  };
  
  var getReq = https.request(options,(res, err) => {
      console.log(res.body)
      .then(data => {
          console.log(data);
      }).catch(e=>res.render('error'))
  });

  getReq.end();

})

module.exports = router;
