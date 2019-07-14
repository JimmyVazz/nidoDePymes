const http =  require('https');

app.get('/api/', (req, res, next) =>{

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
  
  var getReq = https.request(options,function(res){
      console.log(res.body);
      res.on('data',(data) => {
          console.log(data);
      });
  });

  getReq.end();

})