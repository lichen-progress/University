import Vue from 'vue';
import Router from 'vue-router';
import Login from '../pages/Login.vue'


import MainPage from '../pages/MainPage';
import UserPage from '../pages/UserPage';
import Search from "../pages/Search.vue";
import Resource from "../pages/Resource.vue"
import Manager from "../pages/Manager.vue"
import ResourceEditor from "../pages/ResourceEditor.vue"


const originalPush = Router.prototype.push
Router.prototype.push = function push(location) {
  return originalPush.call(this, location).catch(err => err)
}

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'MainPage',
      component: MainPage
    },
    {
      path: '/user',
      name: 'UserPage',
      component: UserPage
    },
    {
      path:'/search',
      name:'Search',
      component:Search
    },
    {
      path:'/comment',
      name:'Comment',
      component:Search
    },
    {
      path:'/manager',
      name:'Manager',
      component:Manager
    },
    {
      path:'/login',
      name:'Login',
      component:Login
    },
    {
      path:'/resource',
      name:'Resource',
      component:Resource
    },


  ]
})
