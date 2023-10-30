<template>
  <div class="app-container">
    <head>
      <!-- 设置 referrer 为 no-referrer，用于绕过防盗链限制，从而正常显示图片 -->
      <meta name="referrer" content="no-referrer" />
    </head>

    <h1>教师列表</h1>

    <!--查询表单-->
    <el-card class="operate-container" shadow="never">
      <el-form :inline="true" class="demo-form-inline">
        <el-form-item label="名称">
          <el-input v-model="searchObj.name" placeholder="教师名称" />
        </el-form-item>

        <el-form-item label="头衔">
          <el-select v-model="searchObj.level" clearable placeholder="头衔">
            <el-option value="1" label="高级教师" />
            <el-option value="0" label="首席教师" />
          </el-select>
        </el-form-item>

        <el-form-item label="入驻时间">
          <el-date-picker
            v-model="searchObj.joinDateBegin"
            placeholder="开始时间"
            value-format="yyyy-MM-dd"
          />
        </el-form-item>
        <el-form-item label="-">
          <el-date-picker
            v-model="searchObj.joinDateEnd"
            placeholder="结束时间"
            value-format="yyyy-MM-dd"
          />
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
      <el-button class="btn-add" @click="add()" style="margin-left: 10px"
        >添加</el-button
      >
      <el-button class="btn-add" @click="batchRemove()">批量删除</el-button>
    </el-card>

    <!-- 表格 -->
    <el-table
      :data="list"
      border
      stripe
      @selection-change="handleSelectionChange"
    >
      <el-table-column type="selection" />
      <el-table-column label="序号" width="50">
        <template slot-scope="scope">
          {{ (page - 1) * limit + scope.$index + 1 }}
        </template>
      </el-table-column>
      <el-table-column prop="name" label="名称" width="80" />
      <el-table-column label="头像" width="80">
        <template slot-scope="scope">
          <img
            v-if="scope.row.avatar"
            :src="scope.row.avatar"
            style="
              width: 50px;
              height: 50px;
              border-radius: 50%;
              object-fit: cover;
            "
          />
        </template>
      </el-table-column>
      <el-table-column label="头衔" width="90">
        <template slot-scope="scope">
          <el-tag v-if="scope.row.level === 1" type="success" size="mini"
            >高级教师</el-tag
          >
          <el-tag v-if="scope.row.level === 0" size="mini">首席教师</el-tag>
        </template>
      </el-table-column>
      <el-table-column prop="intro" label="简介" />
      <el-table-column prop="sort" label="排序" width="60" />
      <el-table-column prop="joinDate" label="入驻时间" width="160" />
      <el-table-column label="操作" width="200" align="center">
        <template slot-scope="scope">
          <el-button type="text" size="mini" @click="removeById(scope.row.id)"
            >删除</el-button
          >
          <router-link :to="'/vod/teacher/edit/' + scope.row.id">
            <el-button type="text" size="mini">修改</el-button>
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
      layout="total, sizes, prev, pager, next, jumper"
      @size-change="changePageSize"
      @current-change="changeCurrentPage"
    />
  </div>
</template>

<script>
// 引入定义接口的 js 文件
import teacherAPI from "@/api/vod/teacher";

export default {
  // 初始值
  data() {
    return {
      // 教师列表
      list: [],
      // 总记录数
      total: 0,
      // 当前页码
      page: 1,
      // 每页记录数
      limit: 10,
      // 查询对象
      searchObj: {},
      // 批量删除选中的记录列表
      multipleSelection: [],
    };
  },

  //页面渲染之前
  created() {
    this.fetchData();
  },

  // 具体方法
  methods: {
    fetchData() {
      // 验证开始时间和结束时间的合法性
      if (!this.validateDateRange()) {
        return;
      }

      // 调用 API，进行 ajax 请求
      teacherAPI
        .teacherListPage(this.page, this.limit, this.searchObj)
        .then((response) => {
          this.list = response.data.records;
          this.total = response.data.total;
        });
    },

    // 验证开始时间和结束时间的合法性
    validateDateRange() {
      if (
        this.searchObj.joinDateBegin &&
        this.searchObj.joinDateEnd &&
        this.searchObj.joinDateBegin > this.searchObj.joinDateEnd
      ) {
        this.$message.error("开始时间不能晚于结束时间");
        return false;
      }
      return true;
    },

    // 清空表单
    resetData() {
      this.searchObj = {};
      this.fetchData();
    },

    // 改变每页显示的记录数，size：回调参数，表示当前选中的“每页条数”
    changePageSize(size) {
      this.limit = size;
      this.fetchData();
    },

    // 改变页码数，page：回调参数，表示当前选中的“页码”
    changeCurrentPage(page) {
      this.page = page;
      this.fetchData();
    },

    // 跳转到添加表单页面
    add() {
      this.$router.push({ path: "/vod/teacher/create" });
    },

    // 复选框发生变化，调用方法，选中复选框行的内容传递
    handleSelectionChange(selection) {
      this.multipleSelection = selection;
      // console.log(this.multipleSelection);
    },

    // 批量删除教师
    batchRemove() {
      // 判断非空
      if (this.multipleSelection.length === 0) {
        this.$message.warning("请选择要删除的记录！");
        return;
      }

      this.$confirm("此操作将删除该教师信息, 是否继续?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      }).then(() => {
        let idList = [];

        // 遍历数组 multipleSelection
        this.multipleSelection.forEach((item) => {
          // 放到数组 idList
          idList.push(item.id);
        });

        // 调用接口批量删除
        teacherAPI.removeBatchTeacher(idList).then((response) => {
          // 提示信息
          this.$message({
            type: "success",
            message: "删除成功!",
          });
          // 刷新页面
          this.fetchData();
        });
      });
    },

    // 逻辑删除教师
    removeById(id) {
      this.$confirm("此操作将删除该教师信息, 是否继续?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      }).then(() => {
        // 调用接口删除
        teacherAPI.removeTeacherById(id).then((response) => {
          // 提示信息
          this.$message({
            type: "success",
            message: "删除成功!",
          });
          // 刷新页面
          this.fetchData();
        });
      });
    },
  },
};
</script>
