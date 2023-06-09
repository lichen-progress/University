<template>
  <el-card class="profile-card" shadow="hover">
    <div class="profile-avatar">
      <el-avatar :src="userInfo.avatar" :size="80"></el-avatar>
    </div>
    <div class="profile-info">
      <div class="profile-username">{{ userInfo.name }}</div>
      <div class="profile-email">{{ userInfo.mail }}</div>
    </div>
  </el-card>
</template>
  
  <script>
import axios from "axios";

export default {
  name: "UserProfile",
  props: {
    profile: {
      type: Object,
      default: null,
    },
  },
  data() {
    return {
      userInfo: {},
    };
  },
  mounted() {

    //若无参数传递，则显示当前用户
    if (this.profile == null) {
      axios
        .get("/user/login")
        .then((response) => {
          console.log(response);
          this.userInfo = response.data.data.userProfile;
          console.log(this.userInfo + "====================================");
        })
        .catch((error) => {
          console.log(error);
        });
    }else{//若有，则显示传入用户
      console.log("card profile");
      console.log(this.profile);
      this.userInfo = this.profile;
    }
  },
};
</script>
  
  <style scoped>
.profile-card {

  min-width: 200px;
  min-height: 250px;
  background-color: #f0f0f0;
}

.profile-avatar {
  padding: 20px;
}

.profile-info {
  text-align: center;
  padding: 10px;
}

.profile-username {
  font-weight: bold;
  font-size: 20px;
}

.profile-email {
  color: #606266;
}
</style>