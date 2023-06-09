<template>
  <div class="main-page">
    <div class="blank-vertical">
      <el-card class="show-card">
        <ResourceCard :resource="recommend"></ResourceCard>
        <el-divider><h3>推荐</h3></el-divider>
      </el-card>
    </div>

    <div class="blank-vertical flex-container">
      <UserProfile></UserProfile>
      <el-card class="rank-card">
        <!-- 排名表 -->
        <ul>
          <li v-for="i in rankData" :key="i.rid">
            <div>
              <span>{{ i.name }}</span>
              <span>{{ i.date }}</span>
            </div>
          </li>
        </ul>

        <el-divider><h3>排名</h3></el-divider>
      </el-card>
    </div>
    <div class=""></div>
  </div>
</template>

<script>
import Register from "./component/Register.vue";
import RankCard from "./component/RankCard.vue";
import Login from "./component/Login.vue";
import UserProfile from "./component/UserProfile.vue";
import ResourceCard from "./component/ResourceCard.vue";

export default {
  name: "MainPage",
  data() {
    return {
      msg: "testets",
      recommend: {},

      rankData: [
        {
          rid: 1,
          name: "爆辣野猪",
          date: Date.now(),
        },
        {
          rid: 2,
          name: "小樱",
          date: Date.now(),
        },
      ],

      file: {},
    };
  },
  methods: {
    fileChange(e) {
      console.log(e);
    },
    getResource() {
      let url = "/resource/11";
      this.$axios
        .get(url)
        .then((res) => {
          console.log(res.data);
          this.recommend = res.data.data.resource;
          console.log("recommend");
          console.log(this.recommend);
        })
        .catch((e) => {});
    },
    getRankList() {
      this.$axios
        .get("/user/1")
        .then((res) => {
          console.log(res.data);
          this.users = res.data;
        })
        .catch((e) => {});
    },
  },
  //生命周期
  created() {
    //被创建时加载
    // this.getResource();
  },
  mounted() {
    this.getResource();
  },

  computed: {
    userPage: function () {
      const router = this.$router;
      let text = router;
      console.log(router);
      console.log(text);
      return router.toString();
    },
  },

  components: {
    login: Login,
    rankcard: RankCard,
    register: Register,
    UserProfile,
    ResourceCard,
  },
};
</script>

<style>
.main-page {
  height: 2000px;
  text-align: center;
}

.blank-vertical {
  margin: 20px auto;
  width: 1020px;
  height: fit-content;
}

.blank-vertical .el-card {
  margin: auto 10px;
}

.rank-card {
  width: 100%;
}

.flex-container {
  display: flex;
  margin: auto;
}

.el-carousel__item h3 {
  color: #475669;
  font-size: 14px;
  opacity: 0.75;
  line-height: 200px;
  margin: 0;
}

.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n + 1) {
  background-color: #d3dce6;
}
</style>
