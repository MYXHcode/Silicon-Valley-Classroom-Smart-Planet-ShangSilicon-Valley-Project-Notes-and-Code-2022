import request from "@/utils/request";

const VIDEO_VISITOR_API = "/api/vod/video/visitor";

export default {
  /**
   * 保存视频观看记录
   *
   * @param {Object} videoVisitor 视频来访者记录
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  save(videoVisitor) {
    return request({
      url: `${VIDEO_VISITOR_API}/save`,
      method: "post",
      data: videoVisitor,
    });
  },
};
