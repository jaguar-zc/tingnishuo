const userInfo = {
  balance:10

}

var http = require("../utils/request.js")

var sysncUserinfo = function (wxname,fn){
  http.post("http://localhost:8080/user", {wxName:wxname},function(res){
      fn(res.data)
  })
}

module.exports = {
  balance: userInfo.balance,
  sysncUserinfo: sysncUserinfo
}
