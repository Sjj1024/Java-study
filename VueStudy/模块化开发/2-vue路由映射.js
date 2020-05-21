import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'

// 挂在路由模块，说明使用的是前端路由映射
Vue.use(VueRouter)

// 创建一个路由映射对象数组，将组件和路由映射起来
const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/about',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  }
]

// 将路由映射对象注册到路由中
const router = new VueRouter({
  routes
})

// 将路由暴露出来
export default router
