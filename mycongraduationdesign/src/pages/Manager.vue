<template>
  <div class="upload-containner">
    <el-card>
      <div slot="header" class="card-header">
        <span>上传资源</span>
        <el-button
          style="posit"
          type="info"
          class="float-right"
          @click="preview()"
          >预览</el-button
        >
      </div>
      <div>
        <div style="margin: 20px"></div>
        <el-form
          :label-position="labelPosition"
          label-width="80px"
          :model="basicResourceInfo"
        >
          <el-form-item label="标题" :required="true">
            <el-input v-model="basicResourceInfo.title"></el-input>
          </el-form-item>
          <el-form-item label="分类">
            <el-input v-model="basicResourceInfo.tag"></el-input>
          </el-form-item>
          <el-form-item label="原地址" :required="true">
            <el-input v-model="basicResourceInfo.resource"></el-input>
          </el-form-item>
        </el-form>
      </div>
      <div>
        <editor @htmlChange="getHtml"></editor>
      </div>
    </el-card>
    <div class="preview" v-if="previewFlag">
      <h1>预览</h1>
      <resource :resource="basicResourceInfo"></resource>

      <el-button @click="upload">上传</el-button>
      <el-button @click="cancel">取消</el-button>
    </div>
  </div>
</template>

<script>
import { Message } from "element-ui";
import Editor from "./component/Editor.vue";
import Resource from "./Resource.vue";
export default {
  components: {
    Editor,
    Resource,
  },
  name: "Manager",
  data() {
    return {
      labelPosition: "left",
      basicResourceInfo: {
        name: "",
        title: "",
        resource: "",
        html: "",
      },
      previewFlag: false,
    };
  },
  methods: {
    now() {
      const date = new Date();
      const year = date.getFullYear();
      const month = date.getMonth() + 1; // 月份从0~11，需要+1
      const day = date.getDate();
      const hour = date.getHours();
      const minute = date.getMinutes();
      const second = date.getSeconds();
      const dateString = `${year}-${month < 10 ? "0" + month : month}-${
        day < 10 ? "0" + day : day
      } ${hour < 10 ? "0" + hour : hour}:${
        minute < 10 ? "0" + minute : minute
      }:${second < 10 ? "0" + second : second}`;
      return dateString;
    },
    preview() {
      this.previewFlag = true;
    },
    cancel() {
      this.previewFlag = false;
    },
    upload() {
      let readyData = this.basicResourceInfo;
      //封装基础信息
      let date = this.now();
      console.log(date);
      readyData.date = date;
      console.log("ready upload:\n");
      console.log(readyData);
      //封装html
      this.$axios
        .post("/file/upload/resource", readyData)
        .then((res) => {
          console.log("uploading");
          console.log(res);
          if (res.data.code == 200) {
            this.$message({
              message: "恭喜你，上传成功",
              type: "success",
            });
          }
        })
        .catch((e) => {
          console.log(e);
        });

      //发送axiosPost请求
    },
    getHtml(html) {
      this.basicResourceInfo.html = html;
      console.log("queshigaibian" + this.basicResourceInfo.html);
    },
  },
  created() {},
  mounted() {},
};
</script>

<style>
.preview {
  position: fixed;
  top: 0px;
  left: 0px;
  width: 100%;
  height: 100%;
  background-color: #8e8e8e3f;
}

.upload-containner {
  margin: auto;
  width: 1000px;
}

.card-header {
  text-align: left;
}
.float-right {
  float: right;
  margin-bottom: 10px;
}
</style>