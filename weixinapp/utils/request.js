
const req = {
    get:function(url,data,success){
      wx.request({
        url: url,
        method: 'GET',
        data: data,
        header: {
          'content-type': 'application/json' 
        },
        success: success
      })
    },
    post: function (url, data, success) {
      wx.request({
        url: url,
        method:'POST',
        data: data,
        header: {
          'content-type': 'application/json'
        },
        success: success
      })
    }


};

module.exports = {
  get: req.get,
  post:req.post
}