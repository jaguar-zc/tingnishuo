//index.js
//获取应用实例
const app = getApp()
const p = require("../../utils/placeholder.js")

Page({
  data: {
    motto: '我要提现',
    balancePay:0,
    weixinPay:0,
    placeholder: "",
    inputmoney:null,
    inputnumber:null,
    userInfo: {},
    hasUserInfo: false
  },
  //事件处理函数
  bindViewTap: function() {
    wx.navigateTo({ url: '../more/more' })
  },
  inputMoney:function(event){ 
    this.setData({ inputmoney: event.detail.value })
    this.compute(this.data.inputmoney, this.data.inputnumber);
    return event.detail.value;
  },
  inputNumber: function (event){ 
    this.setData({ inputnumber: event.detail.value })
    this.compute(this.data.inputmoney, this.data.inputnumber);
    return event.detail.value;
  },
  compute: function (inputmoney, inputnumber){ 
    var inmoney = Number(inputmoney);
    var innumber = Number(inputnumber);
    console.log(inmoney);
    console.log(innumber); 
    if (!(inmoney > 0 && innumber > 0)){
      return;
    }
    var money = inmoney * innumber;
    if (userinfo.balance - money > 0) {
      this.setData({ balancePay: money, weixinPay:0 })
    } else {
      this.setData({ 
        balancePay: userinfo.balance ,
        weixinPay: money - userinfo.balance
        })
    } 
  } 
  ,
  onLoad: function () {  
    this.setData({
      placeholder: p.placeholder[0]
    })
    if (app.globalData.userInfo) {
      this.setData({
        userInfo: app.globalData.userInfo,
        hasUserInfo: true
      })
    } else {
      // 由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回
      // 所以此处加入 callback 以防止这种情况
      app.userInfoReadyCallback = res => { 
        this.setData({
          userInfo: res.userInfo,
          hasUserInfo: true
        })
      }
    }  
    
    // 
  },
  getUserInfo: function(e) { 
    app.globalData.userInfo = e.detail.userInfo
    this.setData({
      userInfo: e.detail.userInfo,
      hasUserInfo: true
    })
  }
})
