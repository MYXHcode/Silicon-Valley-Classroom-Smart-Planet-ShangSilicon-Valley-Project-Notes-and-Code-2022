import request from "@/utils/request";

const VOD_API = "/api/vod";

export default {
  /**
   * 获取播放凭证
   *
   * @param {number} courseId 课程 id
   * @param {number} videoId 视频 id
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  getPlayAuth(courseId, videoId) {
    return request({
      url: `${VOD_API}/get/play/auth/${courseId}/${videoId}`,
      method: "get",
    });
  },
};
