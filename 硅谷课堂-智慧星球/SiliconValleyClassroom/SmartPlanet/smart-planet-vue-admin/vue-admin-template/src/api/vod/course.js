import request from "@/utils/request";

const COURSE_API = "/admin/vod/course";

export default {
  /**
   * 点播课程列表
   *
   * @param {number} current 当前页码
   * @param {number} limit 每页记录数
   * @param {Object} courseQueryVo 查询对象
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  getPageList(current, limit, courseQueryVo) {
    return request({
      url: `${COURSE_API}/find/query/page/${current}/${limit}`,
      method: "get",
      params: courseQueryVo,
    });
  },

  /**
   * 添加课程基本信息
   * @param {Object} courseInfo 课程基本信息
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  saveCourseInfo(courseInfo) {
    return request({
      url: `${COURSE_API}/save`,
      method: "post",
      data: courseInfo,
    });
  },

  /**
   * 根据 id 获取课程信息
   *
   * @param {number} id 课程 id
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  getCourseInfoById(id) {
    return request({
      url: `${COURSE_API}/get/${id}`,
      method: "get",
    });
  },

  /**
   * 根据 id 修改课程信息
   *
   * @param {Object} courseInfo 课程基本信息
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  updateCourseInfoById(courseInfo) {
    return request({
      url: `${COURSE_API}/update`,
      method: "post",
      data: courseInfo,
    });
  },

  /**
   * 根据课程 id 查询课程发布信息
   *
   * @param {number} id 课程 id
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  getCoursePublishById(id) {
    return request({
      url: `${COURSE_API}/get/course/publish/vo/${id}`,
      method: "get",
    });
  },

  /**
   * 根据课程 id 最终发布课程
   *
   * @param {number} id 课程 id
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  publishCourseById(id) {
    return request({
      url: `${COURSE_API}/publish/course/${id}`,
      method: "put",
    });
  },

  /**
   * 删除课程
   *
   * @param {number} id 课程 id
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  removeById(id) {
    return request({
      url: `${COURSE_API}/remove/${id}`,
      method: "delete",
    });
  },

  /**
   * 查询所有课程
   *
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  findAll() {
    return request({
      url: `${COURSE_API}/find/all`,
      method: "get",
    });
  },
};
