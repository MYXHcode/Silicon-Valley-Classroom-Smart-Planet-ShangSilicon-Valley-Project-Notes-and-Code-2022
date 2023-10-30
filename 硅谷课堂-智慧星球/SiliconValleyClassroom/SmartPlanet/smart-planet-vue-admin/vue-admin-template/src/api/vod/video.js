import request from "@/utils/request";

const VIDEO_API = "/admin/vod/video";

export default {
  /**
   * 获取课程视频小节
   *
   * @param {number} id 课程视频小节 id
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  getById(id) {
    return request({
      url: `${VIDEO_API}/get/${id}`,
      method: "get",
    });
  },

  /**
   * 新增课程视频小节
   *
   * @param {Object}video 课程视频小节数据
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  save(video) {
    return request({
      url: `${VIDEO_API}/save`,
      method: "post",
      data: video,
    });
  },

  /**
   * 修改课程视频小节
   *
   * @param {Object}video 课程视频小节数据
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  updateById(video) {
    return request({
      url: `${VIDEO_API}/update`,
      method: "post",
      data: video,
    });
  },

  /**
   * 删除课程视频小节
   *
   * @param {number} id 课程视频小节 id
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  removeById(id) {
    return request({
      url: `${VIDEO_API}/remove/${id}`,
      method: "delete",
    });
  },
};
