//index.js
//获取应用实例
const app = getApp()
const p = require("../../utils/placeholder.js")
const service = require("../../utils/service.js")
Page({
  data: {
    motto: '我要提现',
    balancePay: 0,
    weixinPay: 0,
    placeholder: "",
    inputmoney: null,
    inputnumber: null,
    userInfo: {},
    hasUserInfo: false,
    word:null
  },
  //事件处理函数
  onToMore: function () {
    wx.navigateTo({ url: '../more/more' })
  },
  onCommit: function () {
    var data = {
      balance: Number(this.data.inputmoney),
      count: Number(this.data.inputnumber),
      userId: app.globalData.userId,
      word: this.data.word
    }
    if (data.word == null || data.word.length <1){
      return;
    } 
    service.req.commit(data,function(res){ 
      if (res.data.success){
        wx.showToast({ title: '成功', icon: 'success', duration: 2000 })
        var url = "../share/share?id=" + res.data.data;
        console.log(url)
        wx.navigateTo({ url: url})

      }else{ 
        wx.showToast({title: "失败", image: '../../resources/images/icon/cry.png', duration: 2000 })
      }
    });
  },
  onInputMoney: function (event) {
    this.setData({ inputmoney: event.detail.value })
    this.compute(this.data.inputmoney, this.data.inputnumber);
    return event.detail.value;
  },
  onInputNumber: function (event) {
    this.setData({ inputnumber: event.detail.value })
    this.compute(this.data.inputmoney, this.data.inputnumber);
    return event.detail.value;
  },
  onInputword: function (event){
    this.setData({ word: event.detail.value })
    return event.detail.value;
  },
  compute: function (inputmoney, inputnumber) {
    var inmoney = Number(inputmoney);
    var innumber = Number(inputnumber); 
    if (!(inmoney > 0 && innumber > 0)) {
      return;
    }
    var money = inmoney * innumber;
    if (service.balance - money > 0) {
      this.setData({ balancePay: money, weixinPay: 0 })
    } else {
      this.setData({
        balancePay: service.balance,
        weixinPay: money - service.balance
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
  getUserInfo: function (e) {
    app.globalData.userInfo = e.detail.userInfo
    this.setData({
      userInfo: e.detail.userInfo,
      hasUserInfo: true
    })
  }
})
