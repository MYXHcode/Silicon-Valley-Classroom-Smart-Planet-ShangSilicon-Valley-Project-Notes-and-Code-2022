import request from "@/utils/request";

const TEACHER_API = "/admin/vod/teacher";

export default {
  /**
   * 条件查询教师分页
   *
   * @param {number} current   - 当前页码
   * @param {number} limit     - 每页记录数
   * @param {Object} searchObj - 查询对象
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  teacherListPage(current, limit, searchObj) {
    return request({
      url: `${TEACHER_API}/find/query/page/${current}/${limit}`,
      method: "post",

      /*
      使用参数格式传递，写法是 params:searchObj
      使用 json 格式传递，写法是 data:searchObj
       */
      data: searchObj,
    });
  },

  /**
   * 逻辑删除教师
   *
   * @param {number} id - id
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  removeTeacherById(id) {
    return request({
      url: `${TEACHER_API}/remove/${id}`,
      method: "delete",
    });
  },

  /**
   * 添加教师
   *
   * @param {Object} teacher - 教师数据
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  saveTeacher(teacher) {
    return request({
      url: `${TEACHER_API}/save`,
      method: "post",
      data: teacher,
    });
  },

  /**
   * 根据 id 查询教师
   *
   * @param {number} id - id
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  getTeacherById(id) {
    return request({
      url: `${TEACHER_API}/get/${id}`,
      method: "get",
    });
  },

  /**
   * 修改教师
   *
   * @param {Object} teacher - 教师数据
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  updateTeacher(teacher) {
    return request({
      url: `${TEACHER_API}/update`,
      method: "post",
      data: teacher,
    });
  },

  /**
   * 批量删除教师
   *
   * @param {Array}idList id 数组，Json 数组 [1,2,3,...]
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  removeBatchTeacher(idList) {
    return request({
      url: `${TEACHER_API}/remove/batch`,
      method: `delete`,
      data: idList,
    });
  },

  /**
   * 查询所有教师
   *
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  list() {
    return request({
      url: `${TEACHER_API}/find/all`,
      method: `get`,
    });
  },
};
