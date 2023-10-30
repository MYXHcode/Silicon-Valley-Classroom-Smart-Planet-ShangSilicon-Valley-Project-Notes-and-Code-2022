import request from "@/utils/request";

const MENU_API = "/admin/wechat/menu";

export default {
  /**
   * 获取所有菜单，按照一级和二级菜单封装
   *
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  findMenuInfo() {
    return request({
      url: `${MENU_API}/find/menu/info`,
      method: `get`,
    });
  },

  /**
   * 获取所有一级菜单
   *
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  findOneMenuInfo() {
    return request({
      url: `${MENU_API}/find/one/menu/info`,
      method: `get`,
    });
  },

  /**
   * 根据 id 查询菜单
   *
   * @param {number} id id
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  getById(id) {
    return request({
      url: `${MENU_API}/get/${id}`,
      method: `get`,
    });
  },

  /**
   * 添加菜单
   *
   * @param {Object} menu 菜单
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  save(menu) {
    return request({
      url: `${MENU_API}/save`,
      method: `post`,
      data: menu,
    });
  },

  /**
   * 修改菜单
   *
   * @param {Object} menu 菜单
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  updateById(menu) {
    return request({
      url: `${MENU_API}/update`,
      method: `put`,
      data: menu,
    });
  },

  /**
   * 逻辑删除菜单
   *
   * @param {number} id id
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  removeById(id) {
    return request({
      url: `${MENU_API}/remove/${id}`,
      method: "delete",
    });
  },

  /**
   * 同步微信公众号菜单
   *
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  syncMenu() {
    return request({
      url: `${MENU_API}/sync/menu`,
      method: `get`,
    });
  },

  /**
   * 删除微信公众号菜单
   *
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  removeMenu() {
    return request({
      url: `${MENU_API}/remove/menu`,
      method: `delete`,
    });
  },
};
