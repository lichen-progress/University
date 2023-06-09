<template>
  <div class="entrance">
    <div v-if="isLogin">
      <login></login>
    </div>
    <div v-else>
      <register></register>
    </div>
    <el-button type="primary" @click="toggleCard">
      {{ isLogin ? "Switch to Register" : "Switch to Login" }}
    </el-button>
  </div>
</template>
  
  <script>
import EditorVue from './component/Editor.vue';
import Login from "./component/Login.vue";
import Register from "./component/Register.vue";
import Editor from "./component/Editor.vue"

export default {
  components: {
    Login,
    Register,
    Editor
  },
  data() {
    return {
      isLogin: true,
    };
  },
  methods: {
    toggleCard() {
      this.isLogin = !this.isLogin;
    },
  },
  
};
</script>

<style>
.entrance {
  margin: auto;
  width: 1000px;
}
</style>