import axios from "axios";

// 创建 axios 实例
const service = axios.create({
  // api 的 base_url
  baseURL: "http://smartplanet.free.idcfengye.com",
  // 请求超时时间
  timeout: 30000,
});

// http request 拦截器
service.interceptors.request.use(
  (config) => {
    // 获取 localStorage 里面的 token 值
    let token = window.localStorage.getItem("token") || "";

    if (token != "") {
      // 把 token 值放到 header 里面
      config.headers["token"] = token;

      // cookie.get('SmartPlanet');
    }

    return config;
  },

  (err) => {
    return Promise.reject(err);
  }
);

// http response 拦截器
service.interceptors.response.use(
  (response) => {
    if (response.data.code == 208) {
      // 替换 #，后台获取不到 # 后面的参数
      let url = window.location.href.replace("#", "smartplanet");

      window.location =
        "http://smartplanet.free.idcfengye.com/api/user/wechat/authorize?returnUrl=" +
        url;
    } else {
      if (response.data.code == 20000) {
        return response.data;
      } else {
        console.log("response.data:" + JSON.stringify(response.data));
        alert(response.data.message || "error");

        return Promise.reject(response);
      }
    }
  },

  (error) => {
    // 返回接口返回的错误信息
    return Promise.reject(error.response);
  }
);

export default service;
