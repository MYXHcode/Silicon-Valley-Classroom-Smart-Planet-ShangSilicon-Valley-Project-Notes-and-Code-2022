import request from "@/utils/request";

const LIVE_COURSE_API = "/admin/live/live/course";

export default {
  /**
   * 直播课程分页列表
   *
   * @param {number} current 当前页码
   * @param {number} limit 每页记录数
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  getPageList(page, limit) {
    return request({
      url: `${LIVE_COURSE_API}/find/query/page/${page}/${limit}`,
      method: "get",
    });
  },

  /**
   * 添加直播课程
   *
   * @param {Object} liveCourse 直播课程
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  save(liveCourse) {
    return request({
      url: `${LIVE_COURSE_API}/save`,
      method: "post",
      data: liveCourse,
    });
  },

  /**
   * 删除直播课程
   *
   * @param {number} id id
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  removeById(id) {
    return request({
      url: `${LIVE_COURSE_API}/remove/${id}`,
      method: "delete",
    });
  },

  /**
   * 根据 id 查询直播课程基本信息和描述信息
   *
   * @param {number} id id
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  getById(id) {
    return request({
      url: `${LIVE_COURSE_API}/get/info/${id}`,
      method: "get",
    });
  },

  /**
   * 根据 id 修改直播课程
   *
   * @param {Object} liveCourse 直播课程
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  updateById(liveCourse) {
    return request({
      url: `${LIVE_COURSE_API}/update`,
      method: "put",
      data: liveCourse,
    });
  },

  /**
   * 获取直播账号信息
   *
   * @param {number} id id
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  getLiveCourseAccount(id) {
    return request({
      url: `${LIVE_COURSE_API}/get/live/course/account/${id}`,
      method: "get",
    });
  },

  /**
   * 获取直播配置信息
   *
   * @param {number} id id
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  getCourseConfig(id) {
    return request({
      url: `${LIVE_COURSE_API}/get/course/config/${id}`,
      method: "get",
    });
  },

  /**
   * 修改直播配置信息
   *
   * @param {Object} liveCourseConfigVo 直播配置信息
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  updateConfig(liveCourseConfigVo) {
    return request({
      url: `${LIVE_COURSE_API}/update/config`,
      method: "put",
      data: liveCourseConfigVo,
    });
  },

  /**
   * 获取最近的直播
   *
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  findLatelyList() {
    return request({
      url: `${LIVE_COURSE_API}/find/lately/list`,
      method: "get",
    });
  },

  /**
   * 批量删除直播课程
   *
   * @param {Array}idList id 数组，Json 数组 [1,2,3,...]
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  removeRows(idList) {
    return request({
      url: `${LIVE_COURSE_API}/remove/batch`,
      method: "delete",
      data: idList,
    });
  },
};
