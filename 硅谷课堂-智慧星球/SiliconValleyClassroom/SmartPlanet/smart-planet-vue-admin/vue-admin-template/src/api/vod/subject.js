import request from "@/utils/request";

const SUBJECT_API = "/admin/vod/subject";

export default {
  /**
   * 课程分类列表
   *
   * @param {number} id id
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  getChildList(id) {
    return request({
      url: `${SUBJECT_API}/get/child/subject/${id}`,
      method: "get",
    });
  },
};
