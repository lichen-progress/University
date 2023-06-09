<template>
  <div class="userpage">
    <div class="flex-container">
      <div class="sideProfile">
        <el-card>
          <UserProfile></UserProfile>
        </el-card>
      </div>

      <div class="sideProfile">
        <el-card class="user-info">
          <el-descriptions title="用户信息">
            <el-descriptions-item label="用户名">{{
              userProfile.name
            }}</el-descriptions-item>
            <el-descriptions-item label="邮箱">{{
              userProfile.mail
            }}</el-descriptions-item>
            <el-descriptions-item label="居住地">苏州市</el-descriptions-item>
            <el-descriptions-item label="备注">
              <el-tag v-if="isAdm" size="small" type="success">管理员</el-tag>
              <el-tag v-else="isAdm" size="small">用户</el-tag>
            </el-descriptions-item>
            <el-descriptions-item label="联系地址"
              >江苏省苏州市吴中区吴中大道 1188 号</el-descriptions-item
            >
          </el-descriptions>

          <el-divider></el-divider>
      
        </el-card>
        <el-card class="user-info">
          <h3>已上传资源</h3>
          <div class="flex-container-vertical">
            <div v-for="resource in resourceList">
              <ResourceCard :resource="resource"></ResourceCard>
            </div>
          </div>
        </el-card>
        <el-card class="user-info">用户评论</el-card>
        <el-card class="user-info"></el-card>
      </div>
    </div>
  </div>
</template>

<script>
import UserProfile from "./component/UserProfile.vue";
import ResourceCard from "./component/ResourceCard.vue";

export default {
  name: "UserPage",
  data() {
    return {
      userProfile: {},
      isAdm: false,
      resourceList: [],
    };
  },
  methods: {
    getUserInfo() {
      let axios = this.$axios;
      axios
        .get("/user/login")
        .then((response) => {
          console.log("getUserInfo\n");
          console.log(response.data);
          this.userProfile = response.data.data.userProfile;
          console.log(this.userProfile);
          if (this.userProfile.type == 1) {
            this.isAdm = true;
          }
          this.getResources(this.userProfile.uid);
        })
        .catch((e) => {
          console.log(e);
        });
    },

    getResources(uid) {
      let path = "/resource/resourceAndUser/" + uid;
      console.log("path" + path);

      this.$axios
        .get(path)
        .then((res) => {
          this.resourceList = res.data.data.resources;
          console.log("rList:\n" + this.resourceList);
        })
        .catch((e) => {
          console.log(e);
        });
    },

 
  },
  created() {},
  mounted() {
    this.getUserInfo();
  },
  components: {
    UserProfile,
    ResourceCard,
  },
};
</script>

<style>
.userpage {
  margin: auto;
  max-width: 1100px;
}
.sideProfile {
  width: fit-content;
  height: fit-content;
  margin: 10px 8px 10px 8px;
}
.user-info {
  max-width: 800px;
  min-height: 200px;
  margin: 10px 8px;
}

.cards-container {
  margin: 20px auto;
  width: 800px;
  height: fit-content;
}
.flex-container {
  display: flex;
}
.flex-container-vertical {
  display: flex;
  flex-direction: column;
}
</style>