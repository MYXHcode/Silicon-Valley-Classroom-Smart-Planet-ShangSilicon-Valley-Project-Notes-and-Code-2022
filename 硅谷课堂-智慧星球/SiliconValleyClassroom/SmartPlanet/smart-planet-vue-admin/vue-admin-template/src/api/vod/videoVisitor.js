import request from "@/utils/request";

const VIDEO_VISITOR_API = "/admin/vod/video/visitor";

export default {
  /**
   * 显示课程统计数据
   *
   * @param {number} courseId  课程 id
   * @param {String} startDate 开始时间
   * @param {String} endDate   结束时间
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  findCount(courseId, startDate, endDate) {
    return request({
      url: `${VIDEO_VISITOR_API}/find/count/${courseId}/${startDate}/${endDate}`,
      method: "get",
    });
  },
};
