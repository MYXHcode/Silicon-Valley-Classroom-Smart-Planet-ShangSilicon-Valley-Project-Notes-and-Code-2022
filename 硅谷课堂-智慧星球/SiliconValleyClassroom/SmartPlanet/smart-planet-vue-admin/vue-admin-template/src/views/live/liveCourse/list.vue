<template>
  <div class="app-container">
    <head>
      <!-- 设置 referrer 为 no-referrer，用于绕过防盗链限制，从而正常显示图片 -->
      <meta name="referrer" content="no-referrer" />
    </head>

    <!-- 工具条 -->
    <el-card class="operate-container" shadow="never">
      <i class="el-icon-tickets" style="margin-top: 5px"></i>
      <span style="margin-top: 5px">数据列表</span>
      <el-button class="btn-add" size="mini" @click="add">添 加</el-button>
    </el-card>

    <!-- banner 列表 -->
    <el-table
      v-loading="listLoading"
      :data="list"
      stripe
      border
      style="width: 100%; margin-top: 10px"
    >
      <el-table-column label="序号" width="50" align="center">
        <template slot-scope="scope">
          {{ (page - 1) * limit + scope.$index + 1 }}
        </template>
      </el-table-column>
      <el-table-column label="封面" width="200" align="center">
        <template slot-scope="scope">
          <img :src="scope.row.cover" width="100%" />
        </template>
      </el-table-column>
      <el-table-column prop="courseName" label="直播名称" />
      <el-table-column prop="startTime" label="直播时间">
        <template slot-scope="scope">
          {{ scope.row.startTime }} 至 {{ scope.row.endTime }}
        </template>
      </el-table-column>
      <el-table-column prop="endTime" label="直播结束时间" />
      <el-table-column prop="param.teacherName" label="直播教师" />
      <el-table-column label="头衔" width="90">
        <template slot-scope="scope">
          <el-tag
            v-if="scope.row.param.teacherLevel === 1"
            type="success"
            size="mini"
            >高级教师</el-tag
          >
          <el-tag v-if="scope.row.param.teacherLevel === 0" size="mini"
            >首席教师</el-tag
          >
        </template>
      </el-table-column>
      <el-table-column prop="createTime" label="创建时间" />

      <el-table-column label="操作" width="200" align="center">
        <template slot-scope="scope">
          <el-button type="text" size="mini" @click="edit(scope.row.id)"
            >修改</el-button
          >
          <el-button
            type="text"
            size="mini"
            @click="removeDataById(scope.row.id)"
            >删除</el-button
          >
          <el-button type="text" size="mini" @click="showAccount(scope.row)"
            >查看账号</el-button
          >
          <router-link :to="'/live/liveCourse/config/' + scope.row.id">
            <el-button type="text" size="mini" style="margin-left: 10px"
              >配置</el-button
            >
          </router-link>
          <router-link :to="'/live/liveVisitor/list/' + scope.row.id">
            <el-button type="text" size="mini">观看记录</el-button>
          </router-link>
        </template>
      </el-table-column>
    </el-table>

    <!-- 分页组件 -->
    <el-pagination
      :current-page="page"
      :total="total"
      :page-size="limit"
      :page-sizes="[5, 10, 20, 30, 40, 50, 100]"
      style="padding: 30px 0; text-align: center"
      layout="sizes, prev, pager, next, jumper, ->, total, slot"
      @current-change="fetchData"
      @size-change="changeSize"
    />

    <el-dialog title="添加/修改" :visible.sync="dialogVisible" width="60%">
      <el-form
        ref="flashPromotionForm"
        label-width="150px"
        size="small"
        style="padding-right: 40px"
      >
        <!-- 课程教师 -->
        <el-form-item label="直播教师">
          <el-select v-model="liveCourse.teacherId" placeholder="请选择">
            <el-option
              v-for="teacher in teacherList"
              :key="teacher.id"
              :label="teacher.name"
              :value="teacher.id"
            />
          </el-select>
        </el-form-item>
        <el-form-item label="直播教师登录密码" v-if="liveCourse.id === ''">
          <el-input v-model="liveCourse.password" />
        </el-form-item>
        <el-form-item label="直播名称">
          <el-input v-model="liveCourse.courseName" />
        </el-form-item>
        <el-form-item label="直播开始时间">
          <el-date-picker
            v-model="liveCourse.startTime"
            type="datetime"
            placeholder="选择开始日期"
            value-format="yyyy-MM-dd HH:mm:ss"
          />
        </el-form-item>
        <el-form-item label="直播结束时间">
          <el-date-picker
            v-model="liveCourse.endTime"
            type="datetime"
            placeholder="选择结束日期"
            value-format="yyyy-MM-dd HH:mm:ss"
          />
        </el-form-item>
        <el-form-item label="直播封面">
          <el-upload
            :show-file-list="false"
            :on-success="handleCoverSuccess"
            :before-upload="beforeCoverUpload"
            :on-error="handleCoverError"
            :action="BASE_API + '/admin/vod/file/upload?module=cover'"
            class="cover-uploader"
          >
            <img v-if="liveCourse.cover" :src="liveCourse.cover" width="60%" />
            <i v-else class="el-icon-plus avatar-uploader-icon" />
          </el-upload>
        </el-form-item>
        <el-form-item label="直播详情">
          <el-input v-model="liveCourse.description" type="textarea" rows="5" />
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false" size="small">取 消</el-button>
        <el-button type="primary" @click="saveOrUpdate()" size="small"
          >确 定</el-button
        >
      </span>
    </el-dialog>

    <el-dialog
      title="查看账号"
      :visible.sync="accountDialogVisible"
      width="60%"
    >
      <el-form
        ref="accountForm"
        label-width="150px"
        size="small"
        style="padding-right: 40px"
      >
        <div style="margin-left: 40px">
          <h4>主播帮助信息</h4>
          <el-row style="height: 35px">
            <el-co>
              <span class="spd-info">主播登录链接：</span>
              <span class="spd-info"
                >https://live.zhibodun.com/live/courseLogin.php?course_id={{
                  liveCourseAccount.courseId
                }}&role=admin</span
              >
            </el-co>
          </el-row>
          <el-row style="height: 35px">
            <el-col>
              <span class="spd-info"
                >主播登录密码：{{ liveCourseAccount.anchorKey }}</span
              >
            </el-col>
          </el-row>
        </div>
        <div style="margin-left: 40px">
          <h4>主播客户端账号信息</h4>
          <el-row style="height: 35px">
            <el-col>
              <span class="spd-info"
                >主播登录账户：{{ liveCourseAccount.anchorAccount }}</span
              >
            </el-col>
          </el-row>
          <el-row style="height: 35px">
            <el-col>
              <span class="spd-info"
                >主播登录密码：{{ liveCourseAccount.anchorPassword }}</span
              >
            </el-col>
          </el-row>
        </div>

        <div style="margin-left: 40px">
          <h4>助教信息</h4>
          <el-row style="height: 35px">
            <el-co>
              <span class="spd-info">助教登录连接：</span>
              <span class="spd-info"
                >https://live.zhibodun.com/live/courseLogin.php?course_id={{
                  liveCourseAccount.courseId
                }}&role=admin</span
              >
            </el-co>
          </el-row>
          <el-row style="height: 35px">
            <el-col>
              <span class="spd-info"
                >主播登录密码：{{ liveCourseAccount.adminKey }}</span
              >
            </el-col>
          </el-row>
        </div>
        <div style="margin-left: 40px">
          <h4>学生观看信息</h4>
          <el-row style="height: 35px">
            <el-co>
              <span class="spd-info">观看连接：</span>
              <span class="spd-info"
                >http://smartplanetmobile.free.idcfengye.com/#/live/info/{{
                  liveCourseAccount.courseId
                }}</span
              >
            </el-co>
          </el-row>
          <el-row style="height: 35px">
            <el-col>
              <span class="spd-info"
                >观看二维码：<img src="@/assets/SmartPlanet.png" width="80px"
              /></span>
            </el-col>
          </el-row>
        </div>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="accountDialogVisible = false" size="small"
          >关 闭</el-button
        >
      </span>
    </el-dialog>
  </div>
</template>

<script>
import liveCourseAPI from "@/api/live/liveCourse";
import teacherAPI from "@/api/vod/teacher";

const defaultForm = {
  id: "",
  courseName: "",
  startTime: "",
  endTime: "",
  teacherId: "",
  password: "",
  description: "",
  cover: "https://img-blog.csdnimg.cn/b9f45932f6cf471aa53ee24e5555d9c2.png",
};

export default {
  data() {
    return {
      BASE_API: "http://localhost:8333",
      // BASE_API: "http://smartplanet.free.idcfengye.com",

      // 数据是否正在加载
      listLoading: true,

      // banner 列表
      list: null,

      // 数据库中的总记录数
      total: 0,

      // 默认页码
      page: 1,

      // 每页记录数
      limit: 10,

      // 查询表单对象
      searchObj: {},

      // 教师列表
      teacherList: [],

      dialogVisible: false,
      liveCourse: defaultForm,
      saveBtnDisabled: false,
      accountDialogVisible: false,

      liveCourseAccount: {
        courseId: "",
      },
    };
  },

  // 生命周期函数：内存准备完毕，页面尚未渲染
  created() {
    console.log("list created...");
    this.fetchData();

    // 获取教师列表
    this.initTeacherList();
  },

  // 生命周期函数：内存准备完毕，页面渲染成功
  mounted() {
    console.log("list mounted...");
  },

  methods: {
    // 当页码发生改变的时候
    changeSize(size) {
      console.log(size);
      this.limit = size;
      this.fetchData(1);
    },

    // 加载 banner 列表数据
    fetchData(page = 1) {
      console.log("翻页..." + page);

      // 异步获取远程数据（ajax）
      this.page = page;

      liveCourseAPI.getPageList(this.page, this.limit).then((response) => {
        this.list = response.data.records;
        this.total = response.data.total;

        // 数据加载并绑定成功
        this.listLoading = false;
      });
    },

    // 获取教师列表
    initTeacherList() {
      teacherAPI.list().then((response) => {
        this.teacherList = response.data;
      });
    },

    // 重置查询表单
    resetData() {
      console.log("重置查询表单");
      this.searchObj = {};
      this.fetchData();
    },

    // 根据 id 删除数据
    removeDataById(id) {
      this.$confirm("此操作将永久删除该记录, 是否继续?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      })
        .then(() => {
          // 点击确定，远程调用ajax
          return liveCourseAPI.removeById(id);
        })
        .then((response) => {
          this.fetchData(this.page);

          if (response.code) {
            this.$message({
              type: "success",
              message: "删除成功!",
            });
          }
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "已取消删除",
          });
        });
    },

    add() {
      this.dialogVisible = true;
      this.liveCourse = Object.assign({}, defaultForm);
    },

    edit(id) {
      this.dialogVisible = true;
      this.fetchDataById(id);
    },

    fetchDataById(id) {
      liveCourseAPI.getById(id).then((response) => {
        this.liveCourse = response.data;
      });
    },

    saveOrUpdate() {
      // 防止表单重复提交
      this.saveBtnDisabled = true;

      if (!this.liveCourse.teacherId) {
        this.$message.error("请选择直播教师");
        this.saveBtnDisabled = false;

        return;
      }

      if (!this.liveCourse.id && !this.liveCourse.password) {
        this.$message.error("请输入直播教师登录密码");
        this.saveBtnDisabled = false;

        return;
      }

      if (!this.liveCourse.courseName) {
        this.$message.error("请输入直播名称");
        this.saveBtnDisabled = false;

        return;
      }

      if (!this.liveCourse.courseName) {
        this.$message.error("请输入直播名称");
        this.saveBtnDisabled = false;

        return;
      }

      if (!this.liveCourse.startTime) {
        this.$message.error("请选择直播开始时间");
        this.saveBtnDisabled = false;

        return;
      }

      if (!this.liveCourse.endTime) {
        this.$message.error("请选择直播结束时间");
        this.saveBtnDisabled = false;

        return;
      }

      // 验证开始时间和结束时间的合法性
      if (!this.validateDateRange()) {
        return;
      }

      if (!this.liveCourse.description) {
        this.$message.error("请输入直播详情");
        this.saveBtnDisabled = false;

        return;
      }

      if (!this.liveCourse.id) {
        this.saveData();
      } else {
        this.updateData();
      }
    },

    // 验证开始时间和结束时间的合法性
    validateDateRange() {
      if (
        this.liveCourse.startTime &&
        this.liveCourse.endTime &&
        this.liveCourse.startTime > this.liveCourse.endTime
      ) {
        this.$message.error("开始时间不能晚于结束时间");
        return false;
      }

      const startDateTime = new Date(this.liveCourse.startTime);
      const endDateTime = new Date(this.liveCourse.endTime);
      const durationInMilliseconds = endDateTime - startDateTime;
      const durationInHours = durationInMilliseconds / (1000 * 60 * 60);

      if (durationInHours > 24) {
        this.$message.error("直播时间不能超过24小时");
        return false;
      }

      return true;
    },

    // 新增
    saveData() {
      liveCourseAPI.save(this.liveCourse).then((response) => {
        if (response.code) {
          this.$message({
            type: "success",
            message: response.message,
          });

          this.dialogVisible = false;
          this.fetchData(this.page);
        }
      });
    },

    // 根据 id 更新记录
    updateData() {
      liveCourseAPI.updateById(this.liveCourse).then((response) => {
        if (response.code) {
          this.$message({
            type: "success",
            message: response.message,
          });

          this.dialogVisible = false;
          this.fetchData(this.page);
        }
      });
    },

    // 根据 id 查询记录
    fetchDataById(id) {
      liveCourseAPI.getById(id).then((response) => {
        this.liveCourse = response.data;
      });
    },

    showAccount(row) {
      this.accountDialogVisible = true;
      liveCourseAPI.getLiveCourseAccount(row.id).then((response) => {
        this.liveCourseAccount = response.data;
        this.liveCourseAccount.courseId = row.courseId;
      });
    },

    // 上传成功回调
    handleCoverSuccess(res, file) {
      this.liveCourse.cover = res.data;
    },

    // 上传校验
    beforeCoverUpload(file) {
      const isJPG = file.type === "image/jpeg";
      const isPNG = file.type === "image/png";
      const isLt2M = file.size / 1024 / 1024 < 2;

      if (!isJPG && !isPNG) {
        this.$message.error("上传直播封面只能是 JPG 或 PNG 格式!");
      }
      if (!isLt2M) {
        this.$message.error("上传直播封面大小不能超过 2MB!");
      }

      return (isJPG || isPNG) && isLt2M;
    },

    // 错误处理
    handleCoverError() {
      console.log("error");
      this.$message.error("上传失败");
    },
  },
};
</script>
