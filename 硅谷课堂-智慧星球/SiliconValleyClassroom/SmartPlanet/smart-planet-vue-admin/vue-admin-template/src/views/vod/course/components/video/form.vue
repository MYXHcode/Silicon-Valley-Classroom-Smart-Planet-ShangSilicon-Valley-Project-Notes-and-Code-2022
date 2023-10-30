<template>
  <!-- 添加和修改课时表单 -->
  <el-dialog :visible="dialogVisible" title="添加课时" @close="close()">
    <el-form :model="video" label-width="120px">
      <el-form-item label="课时标题">
        <el-input v-model="video.title" />
      </el-form-item>
      <el-form-item label="课时排序">
        <el-input-number v-model="video.sort" :min="0" />
      </el-form-item>
      <el-form-item label="是否免费">
        <el-radio-group v-model="video.isFree">
          <el-radio :label="0">收费</el-radio>
          <el-radio :label="1">免费</el-radio>
        </el-radio-group>
      </el-form-item>

      <!-- 上传视频 -->
      <el-form-item label="上传视频">
        <el-upload
          ref="upload"
          action="#"
          :http-request="uploadVideo"
          :limit="1"
          :on-remove="handleRemove"
          :on-change="handleChange"
          :auto-upload="false"
        >
          <el-button
            :visible="!uploading"
            slot="trigger"
            size="small"
            type="primary"
            >选择视频</el-button
          >
          <el-button
            :visible="!uploading"
            style="margin-left: 40px"
            size="small"
            type="success"
            @click="submitUpload()"
            >点击上传</el-button
          >
          <el-progress
            class="progress"
            :text-inside="true"
            :stroke-width="18"
            :percentage="progress"
            status="exception"
          ></el-progress>
          <div slot="tip" class="el-upload__tip">
            只能上传 MP4 文件，且不超过 500MB
          </div>
        </el-upload>
      </el-form-item>
    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-button :visible="!uploading" @click="close()">取 消</el-button>
      <el-button :visible="!uploading" type="primary" @click="saveOrUpdate()"
        >确 定</el-button
      >
    </div>
  </el-dialog>
</template>

<script>
import TcVod from "vod-js-sdk-v6";
import request from "@/utils/request";

import videoAPI from "@/api/vod/video";
// import vodAPI from "@/api/vod/vod";

export default {
  data() {
    return {
      // BASE_API: "http://localhost:8301",
      BASE_API: "http://localhost:8333",
      // BASE_API: "http://smartplanet.free.idcfengye.com",
      dialogVisible: false,
      uploading: false,

      video: {
        sort: 0,
        free: false,
      },

      // 上传文件列表
      fileList: [],

      // 进度条百分比
      progress: 0,

      // 图片原名称和 id
      filename: "",
      fileId: "",

      // 上传成功后的地址
      videoURL: "",
    };
  },

  methods: {
    open(chapterId, videoId) {
      this.dialogVisible = true;
      this.video.chapterId = chapterId;

      if (videoId) {
        videoAPI.getById(videoId).then((response) => {
          this.video = response.data;
          // 回显
          if (this.video.videoOriginalName) {
            this.fileList = [{ name: this.video.videoOriginalName }];
          }
        });
      }
    },

    close() {
      this.dialogVisible = false;

      // 重置表单
      this.resetForm();
    },

    resetForm() {
      this.video = {
        sort: 0,
        free: false,
      };

      // 重置视频上传列表
      this.fileList = [];
    },

    saveOrUpdate() {
      this.dialogVisible = true;

      if (!this.video.title) {
        this.$message.error("请输入课时标题");
        this.dialogVisible = false;

        return;
      }

      if (!this.video.id) {
        this.save();
      } else {
        this.update();
      }
    },

    save() {
      this.video.courseId = this.$parent.$parent.courseId;
      videoAPI.save(this.video).then((response) => {
        this.$message.success(response.message);
        // 关闭组件
        this.close();

        // 刷新列表
        this.$parent.fetchNodeList();
      });
    },

    update() {
      videoAPI.updateById(this.video).then((response) => {
        this.$message.success(response.message);
        // 关闭组件
        this.close();

        // 刷新列表
        this.$parent.fetchNodeList();
      });
    },

    // 处理上传超出一个视频
    handleUploadExceed(files, fileList) {
      this.$message.warning("想要重新上传视频，请先删除已上传的视频");
    },

    // 获取签名，这里的签名请求是由后端提供的，只需要拿到后端给的签名请求即可
    getVodSignature() {
      const url = this.BASE_API + "/admin/vod/sign";
      return request.get(url).then(function (response) {
        return response.data;
      });
    },

    // 文件列表改变时，将文件列表保存到本地
    handleChange(file, fileList) {
      this.fileList = fileList;
      this.filename = this.fileList[0].raw.name;
    },

    // 上传
    submitUpload() {
      if (this.fileList.length === 0) {
        this.$message.warning("请先选择视频，再进行上传");

        return;
      }

      if (this.uploading) {
        // 如果正在上传中，则直接返回，不执行上传逻辑
        return;
      }

      // 设置上传中状态
      this.uploading = true;

      this.uploadVideo();
    },

    // 自定义上传
    uploadVideo() {
      console.log(this.fileList[0].raw);

      if (this.fileList.length === 0) {
        window.alert("您还没有选取文件");
      } else {
        //必须以函数的形式返回，sdk 参数限制
        const getSignature = async () => {
          const data = await this.getVodSignature();

          return data;
        };

        const tcVod = new TcVod({
          // 获取上传签名的函数
          getSignature: getSignature,
        });

        // 获取通过 element-ui 上传到本地的文件，因为参数类型必须为 file，不能直接以对象的形式传输
        const mediaFile = this.fileList[0].raw;

        const uploader = tcVod.upload({
          mediaFile: mediaFile,
        });

        // 监听上传进度
        uploader.on("media_progress", (info) => {
          this.progress = parseInt(info.percent * 100);
        });

        // 上传结束时，将 url 存到本地
        uploader.done().then((doneResult) => {
          // 保存地址
          this.video.videoSourceId = doneResult.fileId;
          this.video.videoOriginalName = this.filename;

          // 将视频的第一帧保存为封面
          const canvas = document.createElement("canvas");
          const img = document.getElementById("video_img");
          const video = document.getElementById("video");
          video.setAttribute("crossOrigin", "anonymous");
          canvas.width = video.clientWidth;
          canvas.height = video.clientHeight;

          video.onloadeddata = (res) => {
            canvas
              .getContext("2d")
              .drawImage(video, 0, 0, canvas.width, canvas.height);
            const dataURL = canvas.toDataURL("image/png");
            img.setAttribute("src", dataURL);

            // 拿到 base64 的字符串，并保存到本地
            this.imgBase = dataURL.split(",")[1];
          };

          // 设置上传完成状态
          this.uploading = false;
        });
      }
    },

    // 点击删除时
    handleRemove(file, fileList) {
      console.log(file, fileList.length);
    },
  },
};
</script>
