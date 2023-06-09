<template>
  <div>
    <el-card>
      <div slot="header" class="clearfix">
        <span>登录</span>
      </div>
      <el-form
        :model="form"
        :rules="rules"
        ref="form"
        label-width="80px"
        class="login-form"
      >
        <el-form-item label="邮箱" prop="mail">
          <el-input v-model="form.mail" placeholder="请输入邮箱"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password">
          <el-input
            type="password"
            v-model="form.password"
            autocomplete="off"
            placeholder="请输入密码"
          ></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="submitForm">登录</el-button>
        </el-form-item>
      </el-form>
    </el-card>
  </div>
</template>
  
  <script>
import axios from "axios";
import Cookies from "js-cookie";
import { Message } from "element-ui";

export default {
  name: "LoginForm",
  data() {
    const validateMail = (rule, value, callback) => {
      if (!value) {
        callback(new Error("邮箱不能为空"));
      } else if (
        !/^([a-zA-Z0-9_\-])+@([a-zA-Z0-9_-])+(\.[a-zA-Z0-9_-])+/i.test(value)
      ) {
        callback(new Error("邮箱格式不正确"));
      } else {
        callback();
      }
    };
    const validatePassword = (rule, value, callback) => {
      if (!value) {
        callback(new Error("密码不能为空"));
      } else {
        callback();
      }
    };

    return {
      form: {
        mail: "",
        password: "",
      },

      rules: {
        mail: [{ validator: validateMail, trigger: "blur" }],
        password: [{ validator: validatePassword, trigger: "blur" }],
      },
    };
  },

  methods: {
    submitForm() {
      const _this = this;
      this.$refs.form.validate((valid) => {
        if (valid) {
          const { mail, password } = this.form;
          // 发起登录请求
          axios
            .post("http://localhost:3030/user/login", { mail, password })
            .then((response) => {
              // 存储token到cookie中
              
              const token = response.data.data.token;
              console.log(token);
              _this.$cookies.set("token", token, { expires: 7 });
              // 处理登录成功的逻辑
              console.log(response.data);
              Message.success('登录成功，欢迎你！');
              
            })
            .catch((error) => {
              // 处理登录失败的逻辑
              console.log("登录失败:", error);
              Message.error("登录失败，请检查用户名和密码");
            });
        } else {
          console.log("表单验证不通过");
          return false;
        }
      });
    },
  },
};
</script>
  
  <style>
.login-form {
  max-width: 400px;
  margin: 30px auto;
  border: 0px;
}

.el-form-item {
  margin-bottom: 20px;
}
</style>