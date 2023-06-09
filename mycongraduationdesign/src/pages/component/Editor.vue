<template>
  <div class="left">
    <quill-editor
      class="ql-editor"
      v-model="content"
      ref="myQuillEditor"
      :options="editorOption"
      @blur="onEditorBlur($event)"
      @focus="onEditorFocus($event)"
      @change="onEditorChange($event)"
    >
    </quill-editor>
  </div>
</template>


<script>
import { quillEditor } from "vue-quill-editor";

import "quill/dist/quill.core.css";
import "quill/dist/quill.snow.css";
import "quill/dist/quill.bubble.css";


export default {
  name: "Editor",
  components: { quillEditor },

  data() {
    return {
      content: `<p>这是 vue-quill-editor 的内容！</p>`, //双向数据绑定数据
      // 富文本编辑器配置
      editorOption: {
        modules: {
          toolbar: [
            ["bold", "italic", "underline", "strike"], // 加粗 斜体 下划线 删除线
            ["blockquote", "code-block"], // 引用  代码块
            [{ header: 1 }, { header: 2 }], // 1、2 级标题
            [{ list: "ordered" }, { list: "bullet" }], // 有序、无序列表
            [{ script: "sub" }, { script: "super" }], // 上标/下标
            [{ indent: "-1" }, { indent: "+1" }], // 缩进
            [{ direction: "rtl" }], // 文本方向
            [{ size: ["12px", false, "16px", "18px", "20px", "30px"] }], // 字体大小
            [{ header: [1, 2, 3, 4, 5, 6, false] }], // 标题
            [{ color: [] }, { background: [] }], // 字体颜色、字体背景颜色
            [
              {
                font: [
                  false,
                  "SimSun",
                  "SimHei",
                  "Microsoft-YaHei",
                  "KaiTi",
                  "FangSong",
                  "Arial",
                ],
              },
            ], // 字体种类
            [{ align: [] }], // 对齐方式
            ["clean"], // 清除文本格式
            ["link", "image"], // 链接、图片
          ],
          // imageDrop: true, //图片拖拽
          // imageResize: {
          //   //放大缩小
          //   displayStyles: {
          //     backgroundColor: "black",
          //     border: "none",
          //     color: "white",
          //   },
          //   modules: ["Resize", "DisplaySize", "Toolbar"],
          // },
        },
        placeholder: "请输入正文",
      },
    };
  },

  methods: {
    sendHtml(html) {
      this.$emit("htmlChange", html);
    },

    // 失去焦点事件
    onEditorBlur(quill) {
      console.log("editor blur!", quill);
    },
    // 获得焦点事件
    onEditorFocus(quill) {
      console.log("editor focus!", quill);
    },
    // 准备富文本编辑器
    onEditorReady(quill) {
      console.log("editor ready!", quill);
    },
    // 内容改变事件
    onEditorChange({ quill, html, text }) {
      console.log("editor change!", quill, html, text);
      this.content = html;
      this.sendHtml(html);
    },

    //test
    testFunc() {
      this.quill;
    },
  },

  mounted() {
    // 模拟 ajax 请求，异步渲染编辑器
    setTimeout(() => {
      this.html = "<p>模拟 Ajax 异步设置内容 HTML</p>";
    }, 1500);
  },

  beforeDestroy() {
    const editor = this.editor;
    if (editor == null) return;
    editor.destroy(); // 组件销毁时，及时销毁编辑器
  },
};
</script>
<style>
.left {
  text-align: left;
}
</style>

