const express = require('express');
const router  = express.Router();

/* GET home page */
router.get('/', (req, res, next) => {
  res.render('index');
});

router.get('/registro/emprendedores', (req, res) => {
  res.render('registroEntre')
})

module.exports = router;
