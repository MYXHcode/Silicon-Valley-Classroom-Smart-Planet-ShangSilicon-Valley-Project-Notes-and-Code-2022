import request from "@/utils/request";

const SHARE_API = "/api/wechat/share";

export default {
  /**
   * 获取签名
   *
   * @param {string} url url
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  getSignature(url) {
    return request({
      url: `${SHARE_API}/get/signature?url=${url}`,
      method: "get",
    });
  },
};
