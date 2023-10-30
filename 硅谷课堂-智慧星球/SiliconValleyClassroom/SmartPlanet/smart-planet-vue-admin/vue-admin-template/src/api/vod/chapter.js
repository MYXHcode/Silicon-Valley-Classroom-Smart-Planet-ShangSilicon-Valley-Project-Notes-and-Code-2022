import request from "@/utils/request";

const CHAPTER_API = "/admin/vod/chapter";

export default {
  /**
   * 大纲列表，获取章节和小节列表
   *
   * @param {number} courseId 课程 id
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  getNestedTreeList(courseId) {
    return request({
      url: `${CHAPTER_API}/get/nested/tree/list/${courseId}`,
      method: "get",
    });
  },

  /**
   * 添加章节
   *
   * @param {Object} chapter 章节数据
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  save(chapter) {
    return request({
      url: `${CHAPTER_API}/save`,
      method: "post",
      data: chapter,
    });
  },

  /**
   * 根据 id 查询章节
   *
   * @param {number} id 章节 id
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  getById(id) {
    return request({
      url: `${CHAPTER_API}/get/${id}`,
      method: "get",
    });
  },

  /**
   * 修改章节
   *
   * @param {Object} chapter 章节数据
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  updateById(chapter) {
    return request({
      url: `${CHAPTER_API}/update`,
      method: "post",
      data: chapter,
    });
  },

  /**
   * 根据 id 删除章节
   *
   * @param {number} id 章节 id
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  removeById(id) {
    return request({
      url: `${CHAPTER_API}/remove/${id}`,
      method: "delete",
    });
  },
};
