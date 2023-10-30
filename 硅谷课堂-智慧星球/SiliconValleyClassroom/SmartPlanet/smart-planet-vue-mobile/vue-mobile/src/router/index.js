import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";

Vue.use(VueRouter);

const routes = [
  // 首页
  {
    path: "/",
    name: "Home",
    component: Home,
  },

  // 在线直播
  {
    path: "/live/online",
    name: "liveOnline",
    component: () => import("../views/liveOnline.vue"),
  },

  // 直播
  {
    path: "/live",
    name: "Live",
    component: () => import("../views/live.vue"),
  },

  // 直播信息
  {
    path: "/live/info/:liveCourseId",
    name: "LiveInfo",
    component: () => import("../views/liveInfo.vue"),
  },

  // 课程
  {
    path: "/course/:subjectId",
    name: "Course",
    component: () => import("../views/course.vue"),
  },

  // 课程信息
  {
    path: "/course/info/:courseId",
    name: "CourseInfo",
    component: () => import("../views/courseInfo.vue"),
  },

  // 播放
  {
    path: "/play/:courseId/:videoId",
    name: "Play",
    component: () => import("../views/play.vue"),
  },

  // 购物车
  {
    path: "/trade/:courseId",
    name: "Trade",
    component: () => import("../views/trade.vue"),
  },

  // 支付
  {
    path: "/pay/:orderId",
    name: "Pay",
    component: () => import("../views/pay.vue"),
  },

  // 订单
  {
    path: "/order",
    name: "Order",
    component: () => import("../views/order.vue"),
  },

  // 我的课程
  {
    path: "/my/course",
    name: "MyCourse",
    component: () => import("../views/myCourse.vue"),
  },

  // 绑定手机号
  {
    path: "/bind/first",
    name: "BindFirst",
    component: () => import("../views/bindFirst.vue"),
  },

  // 关注微信公众号
  {
    path: "/bind/second",
    name: "BindSecond",
    component: () => import("../views/bindSecond.vue"),
  },

  // 优惠券
  {
    path: "/coupon",
    name: "Coupon",
    component: () => import("../views/coupon.vue"),
  },
  {
    path: "/clear",
    name: "clear",
    component: () => import("../views/clear.vue"),
  },
];

const router = new VueRouter({
  routes,
});

export default router;
