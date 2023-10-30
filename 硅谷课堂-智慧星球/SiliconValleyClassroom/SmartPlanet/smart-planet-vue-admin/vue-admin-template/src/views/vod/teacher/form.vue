<template>
  <div class="app-container">
    <head>
      <!-- 设置 referrer 为 no-referrer，用于绕过防盗链限制，从而正常显示图片 -->
      <meta name="referrer" content="no-referrer" />
    </head>

    <h1>教师表单</h1>

    <!-- 输入表单 -->
    <el-form label-width="120px">
      <el-form-item label="教师名称">
        <el-input v-model="teacher.name" />
      </el-form-item>
      <el-form-item label="入驻时间">
        <el-date-picker v-model="teacher.joinDate" value-format="yyyy-MM-dd" />
      </el-form-item>
      <el-form-item label="教师排序">
        <el-input-number v-model="teacher.sort" :min="0" />
      </el-form-item>
      <el-form-item label="教师头衔">
        <el-select v-model="teacher.level">
          <!--
            数据类型一定要和取出的 json 中的一致，否则没法回填
            因此，这里 value 使用动态绑定的值，保证其数据类型是 number
            -->
          <el-option :value="1" label="高级教师" />
          <el-option :value="0" label="首席教师" />
        </el-select>
      </el-form-item>
      <el-form-item label="教师简介">
        <el-input v-model="teacher.intro" />
      </el-form-item>
      <el-form-item label="教师资历">
        <el-input v-model="teacher.career" :rows="10" type="textarea" />
      </el-form-item>

      <!-- 教师头像 -->
      <el-form-item label="教师头像">
        <el-upload
          :show-file-list="false"
          :on-success="handleAvatarSuccess"
          :before-upload="beforeAvatarUpload"
          :on-error="handleAvatarError"
          :action="BASE_API + '/admin/vod/file/upload'"
          class="avatar-uploader"
        >
          <img
            v-if="teacher.avatar"
            :src="teacher.avatar"
            style="width: 200px; height: auto"
          />
          <i v-else class="el-icon-plus avatar-uploader-icon" />
        </el-upload>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="saveOrUpdate()">保存</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import teacherAPI from "@/api/vod/teacher";

export default {
  data() {
    return {
      teacher: {
        // 初始化教师默认数据
        sort: 0,
        level: 1,
      },

      // 保存按钮是否禁用，防止表单重复提交
      saveBtnDisabled: false,

      // BASE_API: "http://localhost:8301",
      BASE_API: "http://localhost:8333",
      // BASE_API: "http://smartplanet.free.idcfengye.com",
    };
  },

  created() {
    // 获取路径中的 id 值，根据 id 查询得到数据，进行回显
    if (this.$route.params.id) {
      const id = this.$route.params.id;
      this.fetchDataById(id);
    }
  },

  methods: {
    // 上传成功回调
    handleAvatarSuccess(response, file) {
      if (response.code == 20000) {
        // console.log(response);
        this.teacher.avatar = response.data;
        // 强制重新渲染
        this.$forceUpdate();
      } else {
        this.$message.error("上传失败");
      }
    },

    // 上传校验
    beforeAvatarUpload(file) {
      const isJPG = file.type === "image/jpeg";
      const isPNG = file.type === "image/png";
      const isLt2M = file.size / 1024 / 1024 < 2;

      if (!isJPG && !isPNG) {
        this.$message.error("上传头像图片只能是 JPG 或 PNG 格式!");
      }
      if (!isLt2M) {
        this.$message.error("上传头像图片大小不能超过 2MB!");
      }

      return (isJPG || isPNG) && isLt2M;
    },

    // 错误处理
    handleAvatarError() {
      console.log("error");
      this.$message.error("上传失败（http 失败）");
    },

    // 根据 id 查询教师
    fetchDataById(id) {
      teacherAPI.getTeacherById(id).then((response) => {
        this.teacher = response.data;
      });
    },

    // 添加教师
    save() {
      teacherAPI.saveTeacher(this.teacher).then((response) => {
        // 提示信息
        this.$message({
          type: "success",
          message: "添加成功!",
        });

        // 跳转列表页面
        this.$router.push({ path: "/vod/teacher/list" });
      });
    },

    // 修改教师
    update() {
      teacherAPI.updateTeacher(this.teacher).then((response) => {
        // 提示信息
        this.$message({
          type: "success",
          message: "修改成功!",
        });

        // 跳转列表页面
        this.$router.push({ path: "/vod/teacher/list" });
      });
    },

    // 添加或修改教师
    saveOrUpdate() {
      // 禁用保存按钮
      this.saveBtnDisabled = true;

      if (!this.teacher.id) {
        // 教师数据中没有 id，添加
        if (!this.teacher.name) {
          this.$message.error("请输入教师名称");
          this.saveBtnDisabled = false;
          return;
        }

        this.save();
      } else {
        // 教师数据中有 id，修改
        this.update();
      }
    },
  },
};
</script>
