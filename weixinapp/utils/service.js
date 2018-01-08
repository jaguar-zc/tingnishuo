const userInfo = {
  balance:10

}

var http = require("../utils/request.js") 
var req = {
  sysncUserinfo: function (wxname,logo, fn) {
    http.post("http://192.168.0.111:8080/user", { wxName: wxname, logo:logo}, function (res) {
      fn(res.data)
    })
  },
  commit:function(data,fn){
    http.post("http://192.168.0.111:8080/packet/commit", data, fn)
  },
  getPacketRed:function(id,fn){
    http.get("http://192.168.0.111:8080/packet/"+id,{}, fn)
  }


}






module.exports = {
  balance: userInfo.balance,
  req : req
}
