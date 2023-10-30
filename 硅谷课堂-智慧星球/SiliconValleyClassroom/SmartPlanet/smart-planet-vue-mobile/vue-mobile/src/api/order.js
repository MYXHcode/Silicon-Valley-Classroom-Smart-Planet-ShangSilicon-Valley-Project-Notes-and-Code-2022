import request from "@/utils/request";

const ORDER_API = "/api/order";

export default {
  /**
   * 订单支付
   *
   * @param {number} orderNo 订单号
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  createJsapi(orderNo) {
    return request({
      url: `${ORDER_API}/wx/pay/create/js/api/${orderNo}`,
      method: "get",
    });
  },

  /**
   * 订单信息
   *
   * @param {number} orderId 订单 id
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  getInfo(orderId) {
    return request({
      url: `${ORDER_API}/order/info/get/info/${orderId}`,
      method: "get",
    });
  },

  /**
   * 提交订单
   *
   * @param {Object} orderFormVo 订单
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  submitOrder(orderFormVo) {
    return request({
      url: `${ORDER_API}/order/info/submit/order`,
      method: "post",
      data: orderFormVo,
    });
  },

  /**
   * 查询支付状态
   *
   * @param {number} orderNo 订单号
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  queryPayStatus(orderNo) {
    return request({
      url: `${ORDER_API}/wx/pay/query/pay/status/${orderNo}`,
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
      url: `${ORDER_API}/order/info/${pageNo}/${pageSize}`,
      method: "get",
    });
  },

  /**
   * 查询课程列表页面
   *
   * @param {number} pageNo 页面号
   * @param {number} pageSize 页面大小
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  findCourseListPage(pageNo, pageSize) {
    return request({
      url: `${ORDER_API}/order/info/course/${pageNo}/${pageSize}`,
      method: "get",
    });
  },
};
