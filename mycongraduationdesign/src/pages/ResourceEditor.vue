<template>
  <div class="editor-wrapper">
    <el-card>
      <div ref="editorContent" class="editor"></div>
      <el-row style="margin-top: 20px">
        <el-col :span="4">
          <el-button type="primary" @click="sendData">保存文件</el-button>
        </el-col>
      </el-row>
    </el-card>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  data() {
    return {
      content: ''
    }
  },
  mounted() {
    const editor = new Editor(this.$refs.editorContent)

    // 插入图片时的处理函数，将图片转为base64编码
    editor.customConfig.uploadImgShowBase64 = true

    // 上传图片到服务器的配置
    editor.customConfig.uploadImgServer = 'http://localhost:3030/file/createResource'
    editor.customConfig.uploadImgHooks = {
      customInsert: function (insertImg, result, editor) {
        var url = result.url
        insertImg(url)
      }
    }

    editor.create()

    this.$nextTick(() => {
      this.editor = editor
    })
  },
  methods: {
    // 点击“保存文件”按钮时触发
    sendData() {
      // 获取编辑器内容
      this.content = this.editor.txt.html()
      
      // 发送到后端接口
      axios.post('http://localhost:3030/file/createResource', {
        content: this.content
      }).then(response => {
        // 处理响应结果
      }).catch(error => {
        // 处理错误情况
      })
    }
  }
}
</script>

<style scoped>
.editor-wrapper {
  padding: 20px;
}

.editor {
  height: 400px;
}
</style>
