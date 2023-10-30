import request from "@/utils/request";

const SMS_API = "/api/user/sms";

export default {
  /**
   * 添加购物车
   *
   * @param {string} phone 手机号
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  send(phone) {
    return request({
      url: `${SMS_API}/send/${phone}`,
      method: "get",
    });
  },
};
