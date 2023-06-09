<template>
  <div id="topbar">

    <el-menu class="left-entry" mode="horizontal" :router="true" default-active="1">
      <el-menu-item index="0" route="/login" class="el-icon-platform-eleme"> Share</el-menu-item>
      <el-menu-item index="1" route="/">首页</el-menu-item>
      <el-menu-item index="2" route="/user">个人</el-menu-item>
      <el-menu-item index="3" route="/search">搜索</el-menu-item>
      <el-menu-item index="4" route="/manager" :disabled="!isAdm">上传</el-menu-item>
      <el-menu-item index="5" route="/comment">私信</el-menu-item>
      <el-menu-item class="short"><search></search></el-menu-item>



    </el-menu>

  </div>
</template>

<script>
import SearchBar from "./SearchBar.vue";

export default {
  name: "TopBar",
  components: {
    search: SearchBar,
  },
  data() {
    return {
      uid: "/user",
      isAdm:true,
    };
  },

  methods: {
    isClick: function () {
      let a = document.getElementById("shouye");
      console.log("is click! ");
    },
  },
};
</script>

<style>
#topbar {
  position: fixed;
  top: 0%;
  z-index: 100;
  height: fit-content;
  width: 100%;
  margin: 0px;

  background-color: rgba(0, 0, 0, 0);
}

.short {
  width: 500px;
  height: 100%;
}

/*.topbarlist {*/
/*  height: 100%;*/

/*  list-style-type: none;*/
/*  margin: 0px;*/
/*  padding: 0px;*/

/*  display: flex;*/
/*  align-content: center;*/

/*}*/

/*.topbarlist li {*/
/*  color: aqua;*/
/*  background-color: aliceblue;*/
/*  border: -1px solid #000;*/
/*  width: 60px;*/
/*  height: 100%;*/
/*  margin: 20px 0px;*/
/*  transform: translateY(-50%);*/

/*  display: block;*/
/*}*/

/*.topbarlist li:hover {*/
/*  background-color: rgb(103, 183, 253);*/
/*  border: 0px solid #000;*/
/*  width: 60px;*/
/*  display: block;*/
/*}*/

/*.topbarlist li {*/
/*  background-color: #003572;*/
/*  display: block;*/
/*}*/

/*.topbuttom {*/
/*  color: #ffffff;*/
/*}*/

a {
  text-decoration: none;
}
</style>
