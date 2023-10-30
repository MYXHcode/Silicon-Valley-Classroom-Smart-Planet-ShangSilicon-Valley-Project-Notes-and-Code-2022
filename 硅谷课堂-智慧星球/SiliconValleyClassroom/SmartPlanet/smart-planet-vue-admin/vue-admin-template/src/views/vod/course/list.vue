<template>
  <div class="app-container">
    <head>
      <!-- 设置 referrer 为 no-referrer，用于绕过防盗链限制，从而正常显示图片 -->
      <meta name="referrer" content="no-referrer" />
    </head>

    <!-- 查询表单 -->
    <el-card class="operate-container" shadow="never">
      <el-form :inline="true" class="demo-form-inline">
        <!-- 所属分类：级联下拉列表 -->
        <!-- 一级分类 -->
        <el-form-item label="课程类别">
          <el-select
            v-model="searchObj.subjectParentId"
            placeholder="请选择"
            @change="subjectLevelOneChanged"
          >
            <el-option
              v-for="subject in subjectList"
              :key="subject.id"
              :label="subject.title"
              :value="subject.id"
            />
          </el-select>

          <!-- 二级分类 -->
          <el-select v-model="searchObj.subjectId" placeholder="请选择">
            <el-option
              v-for="subject in subjectLevelTwoList"
              :key="subject.id"
              :label="subject.title"
              :value="subject.id"
            />
          </el-select>
        </el-form-item>

        <!-- 标题 -->
        <el-form-item label="标题">
          <el-input v-model="searchObj.title" placeholder="课程标题" />
        </el-form-item>

        <!-- 教师 -->
        <el-form-item label="教师">
          <el-select v-model="searchObj.teacherId" placeholder="请选择教师">
            <el-option
              v-for="teacher in teacherList"
              :key="teacher.id"
              :label="teacher.name"
              :value="teacher.id"
            />
          </el-select>
        </el-form-item>

        <el-button type="primary" icon="el-icon-search" @click="fetchData()"
          >查询</el-button
        >
        <el-button type="default" @click="resetData()">清空</el-button>
      </el-form>
    </el-card>

    <!-- 工具按钮 -->
    <el-card class="operate-container" shadow="never">
      <i class="el-icon-tickets" style="margin-top: 5px"></i>
      <span style="margin-top: 5px">数据列表</span>
      <el-button class="btn-add" @click="add()">添加</el-button>
    </el-card>

    <!-- 表格 -->
    <el-table :data="list" border stripe>
      <el-table-column label="序号" width="50">
        <template slot-scope="scope">
          {{ (page - 1) * limit + scope.$index + 1 }}
        </template>
      </el-table-column>

      <el-table-column label="封面" width="200" align="center">
        <template slot-scope="scope">
          <img :src="scope.row.cover" alt="scope.row.title" width="100%" />
        </template>
      </el-table-column>
      <el-table-column label="课程信息">
        <template slot-scope="scope">
          <a href="">{{ scope.row.title }}</a>
          <p>
            分类：{{ scope.row.param.subjectParentTitle }}
            {{ scope.row.param.subjectTitle }}
          </p>
          <p>
            课时：{{ scope.row.lessonNum }} / 浏览：{{ scope.row.viewCount }} /
            付费学员：{{ scope.row.buyCount }}
          </p>
        </template>
      </el-table-column>
      <el-table-column label="教师" width="100" align="center">
        <template slot-scope="scope">
          {{ scope.row.param.teacherName }}
        </template>
      </el-table-column>
      <el-table-column label="价格(元)" width="100" align="center">
        <template slot-scope="scope">
          <el-tag v-if="Number(scope.row.price) === 0" type="success"
            >免费</el-tag
          >
          <!-- 前端解决保留两位小数的问题 -->
          <!-- <el-tag v-else>{{ Number(scope.row.price).toFixed(2) }}</el-tag> -->

          <!-- 后端解决保留两位小数的问题，前端不用处理 -->
          <el-tag v-else>{{ scope.row.price }}</el-tag>
        </template>
      </el-table-column>
      <el-table-column
        prop="status"
        label="课程状态"
        width="100"
        align="center"
      >
        <template slot-scope="scope">
          <el-tag :type="scope.row.status === 0 ? 'warning' : 'success'">{{
            scope.row.status === 0 ? "未发布" : "已发布"
          }}</el-tag>
        </template>
      </el-table-column>
      <el-table-column label="发布时间" width="140" align="center">
        <template slot-scope="scope">
          {{ scope.row.createTime ? scope.row.createTime.substr(0, 16) : "" }}
        </template>
      </el-table-column>

      <el-table-column label="操作" width="210" align="center">
        <template slot-scope="scope">
          <router-link :to="'/vod/course/course/info/' + scope.row.id">
            <el-button type="text" icon="el-icon-edit">修改</el-button>
          </router-link>
          <router-link :to="'/vod/course/course/chapter/' + scope.row.id">
            <el-button type="text" icon="el-icon-edit">编辑大纲</el-button>
          </router-link>
          <router-link :to="'/vod/course/course/chart/' + scope.row.id">
            <el-button type="text" icon="el-icon-edit">课程统计</el-button>
          </router-link>
          <el-button
            type="text"
            icon="el-icon-delete"
            @click="removeById(scope.row.id)"
            >删除</el-button
          >
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
      layout="total, sizes, prev, pager, next, jumper"
      @size-change="changePageSize"
      @current-change="changeCurrentPage"
    />
  </div>
</template>

<script>
import teacherAPI from "@/api/vod/teacher";
import subjectAPI from "@/api/vod/subject";
import courseAPI from "@/api/vod/course";

export default {
  data() {
    return {
      // 课程列表
      list: [],
      // 总记录数
      total: 0,
      // 页码
      page: 1,
      // 每页记录数
      limit: 10,

      // 查询条件
      searchObj: {
        // 解决查询表单无法选中二级类别
        subjectId: "",
      },

      // 教师列表
      teacherList: [],
      // 一级分类列表
      subjectList: [],
      // 二级分类列表,
      subjectLevelTwoList: [],
    };
  },

  created() {
    this.fetchData();

    // 初始化分类列表
    this.initSubjectList();

    // 获取教师列表
    this.initTeacherList();
  },

  methods: {
    fetchData() {
      courseAPI
        .getPageList(this.page, this.limit, this.searchObj)
        .then((response) => {
          this.list = response.data.records;
          this.total = response.data.totalCount;
        });
    },

    initTeacherList() {
      teacherAPI.list().then((response) => {
        this.teacherList = response.data;
      });
    },

    initSubjectList() {
      subjectAPI.getChildList(0).then((response) => {
        this.subjectList = response.data;
      });
    },

    subjectLevelOneChanged(value) {
      subjectAPI.getChildList(value).then((response) => {
        this.subjectLevelTwoList = response.data;
        this.searchObj.subjectId = "";
      });
    },

    add() {
      this.$router.push({ path: "/vod/course/course/info" });
    },

    // 每页记录数改变，size：回调参数，表示当前选中的“每页条数”
    changePageSize(size) {
      this.limit = size;
      this.fetchData();
    },

    // 改变页码，page：回调参数，表示当前选中的“页码”
    changeCurrentPage(page) {
      this.page = page;
      this.fetchData();
    },

    // 重置表单
    resetData() {
      this.searchObj = {};

      // 二级分类列表
      this.subjectLevelTwoList = [];
      this.fetchData();
    },

    // 根据 id 删除数据
    removeById(id) {
      this.$confirm(
        "此操作将永久删除该课程，以及该课程下的章节和视频，是否继续?",
        "提示",
        {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning",
        }
      )
        .then(() => {
          return courseAPI.removeById(id);
        })
        .then((response) => {
          this.fetchData();
          this.$message.success(response.message);
        });
    },
  },
};
</script>
