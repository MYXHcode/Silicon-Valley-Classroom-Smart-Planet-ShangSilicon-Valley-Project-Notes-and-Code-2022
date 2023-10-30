<template>
  <div class="app-container">
    <el-form label-width="120px">
      <el-form-item label="优惠券名称">
        <el-input v-model="couponInfo.couponName" />
      </el-form-item>
      <el-form-item label="优惠券类型">
        <el-radio-group v-model="couponInfo.couponType">
          <el-radio label="1">注册卷</el-radio>
          <el-radio label="2">推荐购买卷</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="金额">
        <el-input-number v-model="couponInfo.amount" :min="0" />
      </el-form-item>
      <el-form-item label="发行数量">
        <el-input-number v-model="couponInfo.publishCount" :min="0" />
      </el-form-item>
      <el-form-item label="领取时间">
        <el-date-picker
          v-model="couponInfo.startTime"
          type="date"
          placeholder="选择开始日期"
          value-format="yyyy-MM-dd"
        />
        至
        <el-date-picker
          v-model="couponInfo.endTime"
          type="date"
          placeholder="选择结束日期"
          value-format="yyyy-MM-dd"
        />
      </el-form-item>
      <el-form-item label="过期时间">
        <el-date-picker
          v-model="couponInfo.expireTime"
          type="datetime"
          placeholder="选择过期时间"
          value-format="yyyy-MM-dd HH:mm:ss"
        />
      </el-form-item>
      <el-form-item label="直播详情">
        <el-input v-model="couponInfo.ruleDesc" type="textarea" rows="5" />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="saveOrUpdate">保存</el-button>
        <el-button @click="back">返回</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import couponInfoAPI from "@/api/activity/couponInfo";

const defaultForm = {
  id: "",
  couponType: "1",
  couponName: "",
  amount: "0",
  conditionAmount: "0",
  startTime: "",
  endTime: "",
  rangeType: "1",
  ruleDesc: "",
  publishCount: "",
  perLimit: "1",
  useCount: "0",
  receiveCount: "",
  expireTime: "",
  publishStatus: "",
};

export default {
  data() {
    return {
      couponInfo: defaultForm,
      saveBtnDisabled: false,

      keyword: "",
      skuInfoList: [],
    };
  },

  // 监听器
  watch: {
    $route(to, from) {
      console.log("路由变化...");
      console.log(to);
      console.log(from);
      this.init();
    },
  },

  // 生命周期方法（在路由切换，组件不变的情况下不会被调用）
  created() {
    console.log("form created...");
    this.init();
  },

  methods: {
    // 表单初始化
    init() {
      // debugger
      if (this.$route.params && this.$route.params.id) {
        const id = this.$route.params.id;
        this.fetchDataById(id);
      } else {
        // 对象拓展运算符：拷贝对象，而不是赋值对象的引用
        this.couponInfo = { ...defaultForm };
      }
    },

    saveOrUpdate() {
      // 防止表单重复提交
      this.saveBtnDisabled = true;

      if (!this.couponInfo.couponName) {
        this.$message.error("请输入优惠券名称");
        this.saveBtnDisabled = false;

        return;
      }

      if (!this.couponInfo.publishCount) {
        this.$message.error("请输入发行数量");
        this.saveBtnDisabled = false;

        return;
      }

      // 验证开始时间和结束时间的合法性
      if (!this.validateDateRange()) {
        return;
      }

      if (!this.couponInfo.id) {
        this.saveData();
      } else {
        this.updateData();
      }
    },

    // 验证开始时间和结束时间的合法性
    validateDateRange() {
      if (
        (this.couponInfo.startTime &&
          this.couponInfo.endTime &&
          this.couponInfo.startTime > this.couponInfo.endTime) ||
        this.couponInfo.endTime > this.couponInfo.expireTime
      ) {
        this.$message.error("开始时间不能晚于结束时间");
        return false;
      }
      return true;
    },

    // 新增
    saveData() {
      couponInfoAPI.save(this.couponInfo).then((response) => {
        if (response.code) {
          this.$message({
            type: "success",
            message: response.message,
          });
          this.$router.push({ path: "/activity/coupon/info/list" });
        }
      });
    },

    // 根据 id 更新记录
    updateData() {
      couponInfoAPI.updateById(this.couponInfo).then((response) => {
        debugger;
        if (response.code) {
          this.$message({
            type: "success",
            message: response.message,
          });
          this.$router.push({ path: "/activity/coupon/info/list" });
        }
      });
    },

    back() {
      this.$router.push({ path: "/activity/coupon/info/list" });
    },

    // 根据 id 查询记录
    fetchDataById(id) {
      couponInfoAPI.getById(id).then((response) => {
        this.couponInfo = response.data;
      });
    },
  },
};
</script>
