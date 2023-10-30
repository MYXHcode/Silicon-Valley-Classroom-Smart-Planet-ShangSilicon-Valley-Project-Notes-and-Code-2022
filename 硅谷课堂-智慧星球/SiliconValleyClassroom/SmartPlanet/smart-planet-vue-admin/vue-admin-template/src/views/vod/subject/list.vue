<template>
  <div class="app-container">
    <el-table
      :data="list"
      style="width: 100%"
      row-key="id"
      border
      lazy
      :load="load"
      :tree-props="{ children: 'children', hasChildren: 'hasChildren' }"
    >
      <el-table-column prop="title" label="名称" width="150"></el-table-column>
      <el-table-column prop="createTime" label="创建时间"></el-table-column>
    </el-table>

    <div
      class="el-toolbar"
      style="display: flex; justify-content: center; align-items: center"
    >
      <div
        class="el-toolbar-body"
        style="justify-content: flex-start; margin-top: 20px"
      >
        <el-button type="primary" @click="exportData">
          <i class="fa fa-plus" /> 导出
        </el-button>
        <el-button type="primary" @click="importData">
          <i class="fa fa-plus" /> 导入
        </el-button>
      </div>
    </div>

    <el-dialog title="导入" :visible.sync="dialogImportVisible" width="480px">
      <el-form label-position="right" label-width="170px">
        <el-form-item label="文件">
          <el-upload
            :multiple="false"
            :on-success="onUploadSuccess"
            :action="BASE_API + '/' + SUBJECT_API + '/import/data'"
            class="upload-demo"
          >
            <el-button size="small" type="primary">点击上传</el-button>
            <div slot="tip" class="el-upload__tip">
              只能上传 xlsx 文件，且不超过 500KB
            </div>
          </el-upload>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogImportVisible = false">取消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import subjectAPI from "@/api/vod/subject";

export default {
  data() {
    return {
      // 课程分类列表数组
      list: [],

      dialogImportVisible: false,

      // BASE_API: "http://localhost:8301",
      BASE_API: "http://localhost:8333",
      // BASE_API: "http://smartplanet.free.idcfengye.com",

      SUBJECT_API: "admin/vod/subject",
    };
  },

  created() {
    this.getSubList(0);
  },

  methods: {
    // 课程分类列表
    getSubList(id) {
      subjectAPI.getChildList(id).then((response) => {
        this.list = response.data;
      });
    },

    // 下一层的课程分类列表
    load(tree, treeNode, resolve) {
      subjectAPI.getChildList(tree.id).then((response) => {
        resolve(response.data);
      });
    },

    // 课程分类导出为 Excel
    exportData() {
      window.open(`${this.BASE_API}/${this.SUBJECT_API}/export/data`);
    },

    // 从 Excel 导入课程分类
    importData() {
      this.dialogImportVisible = true;
    },

    onUploadSuccess(response, file) {
      this.$message.info("上传成功");
      this.dialogImportVisible = false;
      this.getSubList(0);
    },
  },
};
</script>
