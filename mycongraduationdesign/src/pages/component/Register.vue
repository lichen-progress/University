<template>
  <div>
    <el-card>
      <div slot="header" class="clearfix">
        <span>注册</span>
      </div>
      <el-form :model="form" :rules="rules" ref="form" label-width="80px" class="register-form">
        <el-form-item label="邮箱" prop="mail">
          <el-input v-model="form.mail" placeholder="请输入邮箱"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password">
          <el-input type="password" v-model="form.password" autocomplete="off" placeholder="请输入密码"></el-input>
        </el-form-item>
        <el-form-item label="姓名" prop="name">
          <el-input v-model="form.name" placeholder="请输入姓名"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="submitForm">注册</el-button>
        </el-form-item>
      </el-form>
    </el-card>
  </div>
</template>

<script>
import axios from 'axios';
import { Message } from 'element-ui';

export default {
  name: 'RegisterForm',
  data() {
    const validateMail = (rule, value, callback) => {
      if (!value) {
        callback(new Error('邮箱不能为空'));
      } else if (!/^([a-zA-Z0-9_\-])+@([a-zA-Z0-9_-])+(\.[a-zA-Z0-9_-])+/i.test(value)) {
        callback(new Error('邮箱格式不正确'));
      } else {
        callback();
      }
    };
    const validatePassword = (rule, value, callback) => {
      if (!value) {
        callback(new Error('密码不能为空'));
      } else {
        callback();
      }
    };
    const validateName = (rule, value, callback) => {
      if (!value) {
        callback(new Error('姓名不能为空'));
      } else {
        callback();
      }
    }
    return {
      form: {
        mail: '',
        password: '',
        name: ''
      },
      rules: {
        mail: [
          { validator: validateMail, trigger: 'blur' }
        ],
        password: [
          { validator: validatePassword, trigger: 'blur' }
        ],
        name: [
          { validator: validateName, trigger: 'blur' }
        ]
      }
    };
  },
  methods: {
    submitForm() {
      this.$refs.form.validate((valid) => {
        if (valid) {
          const { mail, password, name } = this.form;
          // 发起注册请求
          axios.post('http://localhost:3030/user/register', { mail, password, name })
            .then((response) => {
              // 处理注册成功的逻辑
              console.log('注册成功');
              Message.success('注册成功，欢迎你！');
              
            })
            .catch((error) => {
              // 处理注册失败的逻辑
              console.log('注册失败:', error);
              Message.error('注册失败，请检查输入信息');
            });
        } else {
          console.log('表单验证不通过');
          return false;
        }
      });
    }
  }
}
</script>

<style scoped>
.register-form {
  max-width: 400px;
  margin: 30px auto;
  border: 0px;
}

.el-form-item {
  margin-bottom: 20px;
}
</style>