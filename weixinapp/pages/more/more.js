//logs.js
const util = require('../../utils/util.js')
const more = require('../../utils/more.js')
Page({
  data: {
    mores: []
  },
  onLoad: function () {
    this.setData({ mores: more.mores}); 
  },
  display:function(event){
    var id = event.currentTarget.dataset.more.id;
    var mores = this.data.mores; 
    for (var i in mores){ 
      if (mores[i].id == id && mores[i].display == false){
        mores[i].display = true;
      }else{
        mores[i].display = false;
      }
    }
    this.setData({ mores: mores }); 
  }
})
