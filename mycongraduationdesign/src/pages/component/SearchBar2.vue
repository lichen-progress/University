<template>
    <el-card class="search-card">
      <el-form :inline="true" class="search-form" @submit.native.prevent="search">
        <el-form-item label="检索条件">
          <el-input v-model="searchTerm" placeholder="请输入要检索的条件"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" icon="el-icon-search" native-type="submit">检索</el-button>
        </el-form-item>
      </el-form>
    </el-card>
  </template>
  
  <script>
  export default {
    data() {
      return {
        searchTerm: ''
      }
    },
    methods: {
      search() {
        // 在这里处理检索逻辑
        console.log('搜索词:', this.searchTerm)
      }
    }
  }
  </script>
  
  <style scoped>
  .search-card {
    margin: auto;
    width: 100%;
    max-width: 1000px;
  }
  
  .search-form {
    padding: 20px;
  }
  
  .el-form-item__label {
    width: 100px;
  }
  </style>