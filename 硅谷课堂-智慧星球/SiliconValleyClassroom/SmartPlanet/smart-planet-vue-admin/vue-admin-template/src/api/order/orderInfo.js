import request from "@/utils/request";

const ORDER_INFO_API = "/admin/order/order/info";

export default {
  /**
   * 订单信息列表
   *
   * @param {number} current 当前页码
   * @param {number} limit 每页记录数
   * @param {Object} orderInfoQueryVo 查询对象
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  getPageList(current, limit, orderInfoQueryVo) {
    return request({
      url: `${ORDER_INFO_API}/find/query/page/${current}/${limit}`,
      method: "get",
      params: orderInfoQueryVo,
    });
  },
};
