<template>
  <div class="app-container">
    <head>
      <!-- 设置 referrer 为 no-referrer，用于绕过防盗链限制，从而正常显示图片 -->
      <meta name="referrer" content="no-referrer" />
    </head>

    <h2 style="text-align: center">发布新课程</h2>
    <el-steps
      :active="active"
      finish-status="success"
      simple
      style="margin-bottom: 40px"
    >
      <el-step title="填写课程基本信息" />
      <el-step title="创建课程大纲" />
      <el-step title="发布课程" />
    </el-steps>

    <!-- 填写课程基本信息 -->
    <info v-if="active === 0" />

    <!-- 创建课程大纲 -->
    <chapter v-if="active === 1" />

    <!-- 发布课程 -->
    <publish v-if="active === 2 || active === 3" />
  </div>
</template>

<script>
// 引入子组件
import info from "@/views/vod/course/components/info";
import chapter from "@/views/vod/course/components/chapter";
import publish from "@/views/vod/course/components/publish";

export default {
  // 注册子组件
  components: { info, chapter, publish },

  data() {
    return {
      active: 0,
      courseId: null,
    };
  },

  created() {
    // 获取路由id
    if (this.$route.params.id) {
      this.courseId = this.$route.params.id;
    }
    if (this.$route.name === "CourseInfoEdit") {
      this.active = 0;
    }
    if (this.$route.name === "CourseChapterEdit") {
      this.active = 1;
    }
  },
};
</script>
