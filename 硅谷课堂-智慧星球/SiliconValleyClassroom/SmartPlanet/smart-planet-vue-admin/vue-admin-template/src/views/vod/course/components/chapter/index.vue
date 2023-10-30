<template>
  <div class="app-container">
    <!-- 添加章节按钮 -->
    <div>
      <el-button type="primary" @click="addChapter()">添加章节</el-button>
    </div>

    <!-- 章节列表 -->
    <ul class="chapterList">
      <li v-for="chapter in chapterList" :key="chapter.id">
        <p>
          {{ chapter.title }}
          <span class="acts">
            <el-button type="text" @click="addVideo(chapter.id)"
              >添加课时</el-button
            >
            <el-button type="text" @click="editChapter(chapter.id)"
              >编辑</el-button
            >
            <el-button type="text" @click="removeChapterById(chapter.id)"
              >删除</el-button
            >
          </span>
        </p>

        <!-- 视频 -->
        <ul class="chapterList videoList">
          <li v-for="video in chapter.children" :key="video.id">
            <p>
              {{ video.title }}
              <el-tag v-if="!video.videoSourceId" size="mini" type="danger">
                {{ "尚未上传视频" }}
              </el-tag>
              <span class="acts">
                <el-tag v-if="video.isFree" size="mini" type="success">{{
                  "免费观看"
                }}</el-tag>
                <el-button type="text" @click="editVideo(chapter.id, video.id)"
                  >编辑</el-button
                >
                <el-button type="text" @click="removeVideoById(video.id)"
                  >删除</el-button
                >
              </span>
            </p>
          </li>
        </ul>
      </li>
    </ul>

    <!-- 章节表单对话框 -->
    <chapter-form ref="chapterForm" />

    <!-- 课时表单对话框 -->
    <video-form ref="videoForm" />

    <div style="text-align: center">
      <el-button type="primary" @click="prev()">上一步</el-button>
      <el-button type="primary" @click="next()">下一步</el-button>
    </div>
  </div>
</template>

<script>
import chapterAPI from "@/api/vod/chapter";
import videoAPI from "@/api/vod/video";

// 引入组件
import chapterForm from "@/views/vod/course/components/chapter/form";
import videoForm from "@/views/vod/course/components/video/form";

export default {
  // 注册组件
  components: { chapterForm, videoForm },

  data() {
    return {
      // 章节嵌套列表
      chapterList: [],
    };
  },

  created() {
    this.fetchNodeList();
  },

  methods: {
    // 获取章节小节数据
    fetchNodeList() {
      chapterAPI.getNestedTreeList(this.$parent.courseId).then((response) => {
        this.chapterList = response.data;
      });
    },

    // 添加章节
    addChapter() {
      this.$refs.chapterForm.open();
    },

    // 编辑章节
    editChapter(chapterId) {
      this.$refs.chapterForm.open(chapterId);
    },

    // 删除章节
    removeChapterById(chapterId) {
      this.$confirm("此操作将永久删除该章节，是否继续?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      })
        .then(() => {
          return chapterAPI.removeById(chapterId);
        })
        .then((response) => {
          this.fetchNodeList();
          this.$message.success(response.message);
        })
        .catch((response) => {
          if (response === "cancel") {
            this.$message.info("取消删除");
          }
        });
    },

    // 添加课时
    addVideo(chapterId) {
      this.$refs.videoForm.open(chapterId);
    },

    // 编辑课时
    editVideo(chapterId, videoId) {
      this.$refs.videoForm.open(chapterId, videoId);
    },

    // 删除课时
    removeVideoById(videoId) {
      this.$confirm("此操作将永久删除该课时, 是否继续?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      })
        .then(() => {
          return videoAPI.removeById(videoId);
        })
        .then((response) => {
          this.fetchNodeList();
          this.$message.success(response.message);
        })
        .catch((response) => {
          if (response === "cancel") {
            this.$message.info("取消删除");
          }
        });
    },

    // 上一步
    prev() {
      this.$parent.active = 0;
    },

    // 下一步
    next() {
      this.$parent.active = 2;
    },
  },
};
</script>
