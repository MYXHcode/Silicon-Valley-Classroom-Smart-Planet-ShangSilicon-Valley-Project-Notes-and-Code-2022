import request from "@/utils/request";

const USER_INFO_API = "/api/user/user/info";

export default {
  /**
   *  添加购物车
   *
   * @param {Object} bindPhoneVo 绑定手机号
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  bindPhone(bindPhoneVo) {
    return request({
      url: `${USER_INFO_API}/bind/phone`,
      method: "post",
      data: bindPhoneVo,
    });
  },

  /**
   * 获取当前用户信息
   *
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  getCurrentUserInfo() {
    return request({
      url: `${USER_INFO_API}/get/current/user/info`,
      method: "get",
    });
  },
};
