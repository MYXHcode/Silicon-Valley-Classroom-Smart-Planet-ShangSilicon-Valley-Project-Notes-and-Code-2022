/**
 * 微信 js-sdk
 * 参考文档：https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421141115
 */
const wxShare = {
  /**
   * [wxRegister 微信 Api 初始化]
   * @param  {Function} callback [ready 回调函数]
   */
  wxRegister(data, option) {
    // data 是微信配置信息，option 是分享的配置内容

    wx.config({
      // 开启调试模式
      debug: false,
      // 必填，公众号的唯一标识
      appId: data.appId,
      // 必填，生成签名的时间戳
      timestamp: data.timestamp,
      // 必填，生成签名的随机串
      nonceStr: data.nonceStr,
      // 必填，签名，见附录 1
      signature: data.signature,
      // 必填，需要使用的 JS 接口列表，所有 JS 接口列表见附录 2
      jsApiList: ["onMenuShareAppMessage"],
    });

    wx.ready(function () {
      wx.onMenuShareAppMessage({
        // 分享标题
        title: option.title,
        // 分享描述
        desc: option.desc,
        // 分享链接
        link: option.link,
        // 分享图标
        imgUrl: option.imgUrl,
        success() {
          // 用户成功分享后执行的回调函数
          //  option.success()
          console.log("ok");
        },
        cancel() {
          // 用户取消分享后执行的回调函数
          // option.error()
          console.log("cancel");
        },
      });
    });

    wx.error(function (res) {
      // config 信息验证失败会执行 error 函数，如签名过期导致验证失败，具体错误信息可以打开 config 的 debug 模式查看，也可以在返回的 res 参数中查看，对于 SPA 可以在这里更新签名。
      alert("error:" + JSON.stringify(res));
    });
  },
};

export default wxShare;
