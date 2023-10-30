import request from "@/utils/request";

const VOD_API = "/admin/vod";

export default {
  /**
   * 删除视频
   *
   * @param {number} id 视频源 id
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  removeByVodId(id) {
    return request({
      url: `${VOD_API}/remove/${id}`,
      method: "delete",
    });
  },
};
