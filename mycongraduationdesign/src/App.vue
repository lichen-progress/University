<template>
  <div id="app">

    <topbar>TopBar</topbar>
    <!-- <div id="backgroudpic"></div> -->
    <router-view class="located"/>
    <!-- <div id="bgimg"></div> -->
  </div>
</template>

<script>
import TopBar from './pages/component/TopBar.vue'
export default {
  name: 'App',
  components:{
    'topbar': TopBar
  }
}
</script>

<style>
#app {
  font-family: "Helvetica Neue",Helvetica,"PingFang SC","Hiragino Sans GB","Microsoft YaHei","微软雅黑",Arial,sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 0px;
  height: 100vh;
  position: relative;

}

.located{
  position: relative;
  top: 80px;
}

.align-center{
  position: absolute;

  top: 50%;

  left: 50%;

  width: 100%;

  transform: translate(-50%, -50%);

  text-align: center;
}



#bgimg{

  position: fixed;
  background: #62b7a0;  /* fallback for old browsers */
  background: -webkit-linear-gradient(0deg, #d0fde8, #62b7a0);  /* Chrome 10-25, Safari 5.1-6 */
  background: linear-gradient(0deg, #d0fde8, #62b7a0); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */

  top: 0%;
  left: 0%;
  height: 100%;
  width: 100%;

  z-index: -100;

}

body {
  margin: 0px;
}
</style>
