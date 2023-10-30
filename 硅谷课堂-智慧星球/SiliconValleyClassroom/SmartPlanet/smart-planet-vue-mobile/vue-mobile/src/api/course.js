import request from "@/utils/request";

const COURSE_API = "/api/vod/course";

export default {
  /**
   * 课程分页列表
   *
   * @param {number} subjectParentId 课程专业父级 id
   * @param {number} pageNo 页面号
   * @param {number} pageSize 页面大小
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  findPage(subjectParentId, pageNo, pageSize) {
    return request({
      url: `${COURSE_API}/${subjectParentId}/${pageNo}/${pageSize}`,
      method: "get",
    });
  },

  /**
   * 课程详情
   *
   * @param {number} courseId 课程 id
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  getInfo(courseId) {
    return request({
      url: `${COURSE_API}/get/info/${courseId}`,
      method: "get",
    });
  },
};
