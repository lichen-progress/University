// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router/index.js'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import axios from 'axios'
import Cookies from 'js-cookie'

 


Vue.config.productionTip = false;
Vue.use(ElementUI);

axios.defaults.baseURL="http://localhost:3030";
axios.defaults.headers.common['Authorization'] = Cookies.get("token");

Vue.prototype.$axios = axios;
Vue.prototype.$cookies = Cookies;


// import Quill from 'vue-quill-editor'
// import Quill from 'quill';

// import ImageResize from 'quill-image-resize-module';
// import { ImageDrop } from 'quill-image-drop-module'; // 图片拖动组件引用
 
// Quill.register('modules/imageResize', ImageResize); // 注册
// Quill.register('modules/imageDrop', ImageDrop); // 注册

// window.Quill = Quill;


/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: {
    App
  },
  template: '<App/>'
})
