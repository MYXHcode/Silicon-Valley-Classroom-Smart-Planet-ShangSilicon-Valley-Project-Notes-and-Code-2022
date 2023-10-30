import request from "@/utils/request";

const COUPON_INFO_API = "/api/activity/coupon/info";

export default {
  /**
   * 查询优惠券信息
   *
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  findCouponInfo() {
    return request({
      url: `${COUPON_INFO_API}/find/coupon/info`,
      method: "get",
    });
  },

  /**
   * 查询列表页面
   *
   * @param {number} pageNo 页面号
   * @param {number} pageSize 页面大小
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  findListPage(pageNo, pageSize) {
    return request({
      url: `${COUPON_INFO_API}/${pageNo}/${pageSize}`,
      method: "get",
    });
  },
};
