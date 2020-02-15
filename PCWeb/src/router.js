import Vue from 'vue'
import Router from 'vue-router'
import Main from './views/Main.vue'
import Login from './views/Login.vue'
import SaleOrderEdit from "./views/Order/SaleOrderEdit";
import SaleOrderList from "./views/Order/SaleOrderList";

Vue.use(Router)

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [{
      path: '/login',
      name: 'login',
      component: Login,
      meta: {
        isPublic: true
      }
    },
    {
      path: '/',
      name: 'main',
      component: Main,
      children: [
          {
              path: "/saleOrder/create",
              component: SaleOrderEdit
          },
          {
              path: "/saleOrder/edit/:id",
              component: SaleOrderEdit,
              props: true
          },
          {
              path: "/saleOrder/list",
              component: SaleOrderList
          },
      ]
    },
  ]
})
router.beforeEach((to, from, next) => {//客户端路由限制
  if (!to.meta.isPublic && !localStorage.token) {
    return next('/login')
  }
  next()
})
export default router