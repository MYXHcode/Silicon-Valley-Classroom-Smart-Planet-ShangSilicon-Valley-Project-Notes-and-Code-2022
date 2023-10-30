<template>
  <div class="app-container">
    <head>
      <!-- 设置 referrer 为 no-referrer，用于绕过防盗链限制，从而正常显示图片 -->
      <meta name="referrer" content="no-referrer" />
    </head>

    <!-- 课程预览 -->
    <div class="ccInfo">
      <img :src="coursePublish.cover" style="width: 200px; height: auto" />
      <div class="main">
        <h2>{{ coursePublish.title }}</h2>
        <p class="gray">
          <span>共{{ coursePublish.lessonNum }}课时</span>
        </p>
        <p>
          <span
            >所属分类：{{ coursePublish.subjectParentTitle }} —
            {{ coursePublish.subjectTitle }}</span
          >
        </p>
        <p>课程教师：{{ coursePublish.teacherName }}</p>
        <h3 class="red">￥{{ coursePublish.price }}</h3>
      </div>
    </div>
    <div style="text-align: center">
      <el-button type="primary" @click="prev()">上一步</el-button>
      <el-button
        :disabled="publishBtnDisabled"
        type="primary"
        @click="publish()"
        >发布课程</el-button
      >
    </div>
  </div>
</template>

<script>
import courseAPI from "@/api/vod/course";

export default {
  data() {
    return {
      // 按钮是否禁用
      publishBtnDisabled: false,
      coursePublish: {},
    };
  },

  created() {
    if (this.$parent.courseId) {
      this.fetchCoursePublishById(this.$parent.courseId);
    }
  },

  methods: {
    // 获取课程发布信息
    fetchCoursePublishById(id) {
      courseAPI.getCoursePublishById(id).then((response) => {
        this.coursePublish = response.data;
      });
    },

    // 上一步
    prev() {
      this.$parent.active = 1;
    },

    // 下一步
    publish() {
      this.publishBtnDisabled = true;
      courseAPI.publishCourseById(this.$parent.courseId).then((response) => {
        this.$parent.active = 3;
        this.$message.success(response.message);
        this.$router.push({ path: "/vod/course/course/list" });
      });
    },
  },
};
</script>
