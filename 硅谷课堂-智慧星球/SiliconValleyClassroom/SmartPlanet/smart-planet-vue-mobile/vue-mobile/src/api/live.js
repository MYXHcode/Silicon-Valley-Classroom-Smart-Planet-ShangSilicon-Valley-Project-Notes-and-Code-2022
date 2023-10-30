import request from "@/utils/request";

const LIVE_COURSE_API = "/api/live/live/course";

export default {
  /**
   * 列表
   *
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  list() {
    return request({
      url: `${LIVE_COURSE_API}/list`,
      method: "get",
    });
  },

  /**
   * 直播详情
   *
   * @param {number} liveCourseId 直播课程 id
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  getInfo(liveCourseId) {
    return request({
      url: `${LIVE_COURSE_API}/get/info/${liveCourseId}`,
      method: "get",
    });
  },

  /**
   * 获取播放身份验证
   *
   * @param {number} liveCourseId 直播课程 id
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  getPlayAuth(liveCourseId) {
    return request({
      url: `${LIVE_COURSE_API}/get/play/auth/${liveCourseId}`,
      method: "get",
    });
  },
};
