<template>
  <div>
    <head>
      <!-- 设置 referrer 为 no-referrer，用于绕过防盗链限制，从而正常显示图片 -->
      <meta name="referrer" content="no-referrer" />
    </head>

    <van-image
      width="100%"
      height="200"
      src="https://img-blog.csdnimg.cn/b9f45932f6cf471aa53ee24e5555d9c2.png"
    />
    <van-list v-model="loading" :finished="finished" finished-text="没有更多了">
      <ul class="list">
        <li v-for="(item, index) in list" :key="index">
          <div>
            <h1 class="van-ellipsis">{{ item.courseName }}</h1>
            <span
              >直播时间：{{ item.startTimeString }}至{{
                item.endTimeString
              }}</span
            >
            <span>
              直播状态：{{
                item.liveStatus == 0
                  ? "未开始"
                  : item.liveStatus == 1
                  ? "直播中"
                  : "已结束"
              }}&nbsp;&nbsp;&nbsp;&nbsp; 直播老师：{{ item.teacher.name }}
            </span>
          </div>
          <p>
            <button @click="info(item.id)" type="default" size="mini">
              去看看
            </button>
          </p>
        </li>
      </ul>
    </van-list>
  </div>
</template>

<script>
import liveAPI from "@/api/live";

export default {
  name: "Live",

  data() {
    return {
      list: [],
      loading: false,
      finished: false,
      show: false,
    };
  },

  created() {
    this.fetchData();
  },

  methods: {
    fetchData() {
      liveAPI.list().then((response) => {
        console.log(response.data);
        this.list = response.data;
        this.finished = true;
      });
    },

    info(id) {
      this.$router.push({ path: "/live/info/" + id });
    },
  },
};
</script>

<style lang="scss" scoped>
.list {
  li {
    margin: 10px;
    padding-bottom: 5px;
    display: flex;
    justify-content: space-between;
    align-items: center;
    border-bottom: 1px solid #e5e5e5;

    div {
      width: calc(100% - 60px);
      display: flex;
      flex-direction: column;
      h1 {
        font-size: 16px;
      }

      span {
        margin: 0;
        font-size: 12px;
        color: gray;
      }
    }

    p {
      text-align: center;
      color: gray;
      font-size: 12px;
      width: 60px;
    }
  }
}
</style>
