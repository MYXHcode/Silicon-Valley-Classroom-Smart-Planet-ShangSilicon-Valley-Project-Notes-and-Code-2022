<template>
  <div class="app-container">
    <head>
      <!-- 设置 referrer 为 no-referrer，用于绕过防盗链限制，从而正常显示图片 -->
      <meta name="referrer" content="no-referrer" />
    </head>

    <!-- 课程信息表单 -->
    <el-form label-width="120px">
      <el-form-item label="课程标题">
        <el-input
          v-model="courseInfo.title"
          placeholder=" 示例：机器学习项目课：从基础到搭建项目视频课程。专业名称注意大小写"
        />
      </el-form-item>

      <!-- 课程教师 -->
      <el-form-item label="课程教师">
        <el-select v-model="courseInfo.teacherId" placeholder="请选择">
          <el-option
            v-for="teacher in teacherList"
            :key="teacher.id"
            :label="teacher.name"
            :value="teacher.id"
          />
        </el-select>
      </el-form-item>

      <!-- 所属分类：级联下拉列表 -->
      <el-form-item label="课程类别">
        <!-- 一级分类 -->
        <el-select
          v-model="courseInfo.subjectParentId"
          placeholder="请选择"
          @change="subjectChanged"
        >
          <el-option
            v-for="subject in subjectList"
            :key="subject.id"
            :label="subject.title"
            :value="subject.id"
          />
        </el-select>

        <!-- 二级分类 -->
        <el-select v-model="courseInfo.subjectId" placeholder="请选择">
          <el-option
            v-for="subject in subjectLevelTwoList"
            :key="subject.id"
            :label="subject.title"
            :value="subject.id"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="总课时">
        <el-input-number
          :min="0"
          v-model="courseInfo.lessonNum"
          controls-position="right"
          placeholder="请填写课程的总课时数"
        />
      </el-form-item>

      <!-- 课程简介-->
      <el-form-item label="课程简介">
        <el-input v-model="courseInfo.description" type="textarea" rows="5" />
      </el-form-item>

      <!-- 课程封面 -->
      <el-form-item label="课程封面">
        <el-upload
          :show-file-list="false"
          :on-success="handleCoverSuccess"
          :before-upload="beforeCoverUpload"
          :on-error="handleCoverError"
          :action="BASE_API + '/admin/vod/file/upload'"
          class="cover-uploader"
        >
          <img
            v-if="courseInfo.cover"
            :src="courseInfo.cover"
            style="width: 200px; height: auto"
          />
          <i v-else class="el-icon-plus avatar-uploader-icon" />
        </el-upload>
      </el-form-item>
      <el-form-item label="课程价格">
        <el-input-number
          :min="0"
          v-model="courseInfo.price"
          controls-position="right"
          placeholder="免费课程请设置为0元"
        />
        元
      </el-form-item>
    </el-form>

    <div style="text-align: center">
      <el-button
        :disabled="saveBtnDisabled"
        type="primary"
        @click="saveAndNext()"
        >保存并下一步</el-button
      >
    </div>
  </div>
</template>

<script>
import courseAPI from "@/api/vod/course";
import teacherAPI from "@/api/vod/teacher";
import subjectAPI from "@/api/vod/subject";

export default {
  data() {
    return {
      // BASE_API: "http://localhost:8301",
      BASE_API: "http://localhost:8333",
      // BASE_API: "http://smartplanet.free.idcfengye.com",

      // 按钮是否禁用
      saveBtnDisabled: false,

      courseId: 0,

      courseInfo: {
        // 表单数据
        price: 0,
        lessonNum: 0,
        // 以下解决表单数据不全时 insert 语句非空校验
        teacherId: "",
        subjectId: "",
        subjectParentId: "",
        cover: "",
        description: "",
      },

      // 教师列表
      teacherList: [],
      // 一级分类列表
      subjectList: [],
      // 二级分类列表
      subjectLevelTwoList: [],
    };
  },

  created() {
    if (this.$parent.courseId) {
      // 回显数据
      this.fetchCourseInfoById(this.$parent.courseId);
    } else {
      // 新增数据
      // 初始化分类列表
      this.initSubjectList();
    }

    // 获取教师列表
    this.initTeacherList();
  },

  methods: {
    // 获取教师列表
    initTeacherList() {
      teacherAPI.list().then((response) => {
        this.teacherList = response.data;
      });
    },

    // 初始化分类列表
    initSubjectList() {
      subjectAPI.getChildList(0).then((response) => {
        this.subjectList = response.data;
      });
    },

    // 选择一级分类，切换二级分类
    subjectChanged(value) {
      subjectAPI.getChildList(value).then((response) => {
        this.courseInfo.subjectId = "";
        this.subjectLevelTwoList = response.data;
      });
    },

    // 上传成功回调
    handleCoverSuccess(response, file) {
      this.courseInfo.cover = response.data;
    },

    // 上传校验
    beforeCoverUpload(file) {
      const isJPG = file.type === "image/jpeg";
      const isPNG = file.type === "image/png";
      const isLt2M = file.size / 1024 / 1024 < 2;

      if (!isJPG && !isPNG) {
        this.$message.error("上传课程封面只能是 JPG 或 PNG 格式!");
      }
      if (!isLt2M) {
        this.$message.error("上传课程封面大小不能超过 2MB!");
      }

      return (isJPG || isPNG) && isLt2M;
    },

    // 错误处理
    handleCoverError() {
      console.log("error");
      this.$message.error("上传失败");
    },

    // 保存并下一步
    saveAndNext() {
      this.saveBtnDisabled = true;

      if (!this.courseInfo.title) {
        this.$message.error("请输入课程标题");
        this.saveBtnDisabled = false;

        return;
      }

      if (!this.courseInfo.description) {
        this.$message.error("请输入课程简介");
        this.saveBtnDisabled = false;

        return;
      }

      if (!this.$parent.courseId) {
        this.saveData();
      } else {
        this.updateData();
      }
    },

    // 保存
    saveData() {
      courseAPI.saveCourseInfo(this.courseInfo).then((response) => {
        this.$message.success(response.message);

        // 获取 courseId
        this.$parent.courseId = response.data;

        // 下一步
        this.$parent.active = 1;
      });
    },

    // 获取课程信息
    fetchCourseInfoById(id) {
      courseAPI.getCourseInfoById(id).then((response) => {
        this.courseInfo = response.data;

        // 初始化分类列表
        subjectAPI.getChildList(0).then((response) => {
          this.subjectList = response.data;

          // 填充二级菜单，遍历一级菜单列表
          this.subjectList.forEach((subject) => {
            // 找到和 courseInfo.subjectParentId 一致的父类别记录
            if (subject.id === this.courseInfo.subjectParentId) {
              // 拿到当前类别下的子类别列表，将子类别列表填入二级下拉菜单列表
              subjectAPI.getChildList(subject.id).then((response) => {
                this.subjectLevelTwoList = response.data;
              });
            }
          });
        });
      });
    },

    // 修改
    updateData() {
      courseAPI.updateCourseInfoById(this.courseInfo).then((response) => {
        this.$message.success(response.message);

        // 获取 courseId
        this.$parent.courseId = response.data;

        // 下一步
        this.$parent.active = 1;
      });
    },
  },
};
</script>
