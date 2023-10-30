import request from "@/utils/request";

const COUPON_INFO_API = "/admin/activity/coupon/info";

export default {
  /**
   * 优惠券信息列表
   *
   * @param {number} current 当前页码
   * @param {number} limit 每页记录数
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  getPageList(current, limit) {
    return request({
      url: `${COUPON_INFO_API}/find/query/page/${current}/${limit}`,
      method: "get",
    });
  },

  /**
   * 根据 id 获取优惠券信息
   *
   * @param {number} id id
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  getById(id) {
    return request({
      url: `${COUPON_INFO_API}/get/${id}`,
      method: "get",
    });
  },

  /**
   * 添加优惠券信息
   *
   * @param {Object} couponInfo 优惠券信息
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  save(couponInfo) {
    return request({
      url: `${COUPON_INFO_API}/save`,
      method: "post",
      data: couponInfo,
    });
  },

  /**
   * 根据 id 修改优惠券信息
   *
   * @param {Object} couponInfo 优惠券信息
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  updateById(couponInfo) {
    return request({
      url: `${COUPON_INFO_API}/update`,
      method: "put",
      data: couponInfo,
    });
  },

  /**
   * 删除优惠券信息
   *
   * @param {number} id id
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  removeById(id) {
    return request({
      url: `${COUPON_INFO_API}/remove/${id}`,
      method: "delete",
    });
  },

  /**
   * 批量删除优惠券信息
   *
   * @param {Array}idList id 数组，Json 数组 [1,2,3,...]
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  removeRows(idList) {
    return request({
      url: `${COUPON_INFO_API}/remove/batch`,
      method: "delete",
      data: idList,
    });
  },

  /**
   * 已经使用的优惠券信息列表
   *
   * @param {number} current 当前页码
   * @param {number} limit 每页记录数
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  getPageCouponUseList(current, limit, searchObj) {
    return request({
      url: `${COUPON_INFO_API}/coupon/use/${current}/${limit}`,
      method: "get",
      params: searchObj,
    });
  },
};
