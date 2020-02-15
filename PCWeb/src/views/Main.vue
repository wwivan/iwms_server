<template>
    <el-container style="height: 100vh;">
        <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
            <el-menu router :default-openeds="['1']" unique-opened :default-active="$route.path">
                <el-submenu index="1">
                    <template slot="title">
                        <i class="el-icon-message"></i>订单管理
                    </template>
                    <el-menu-item-group>
                        <template slot="title">销售管理</template>
                        <el-menu-item index="/factory/create">报价单</el-menu-item>
                        <el-menu-item index="/factory/list">报价订单审核</el-menu-item>
                        <el-menu-item index="/saleOrder/list">销售单</el-menu-item>
                        <el-menu-item index="/factory/list">销售订单报告</el-menu-item>
                    </el-menu-item-group>
                    <el-menu-item-group>
                        <template slot="title">采购管理</template>
                        <el-menu-item index="/userType/create">物料需求</el-menu-item>
                        <el-menu-item index="/userType/list">物料需求审核</el-menu-item>
                        <el-menu-item index="/userType/list">采购计划</el-menu-item>
                        <el-menu-item index="/userType/list">采购计划审核</el-menu-item>
                        <el-menu-item index="/userType/list">采购订单</el-menu-item>
                        <el-menu-item index="/userType/list">采购订单报告</el-menu-item>
                    </el-menu-item-group>
                </el-submenu>
            </el-menu>
        </el-aside>

        <el-container>
            <el-header style="text-align: right; font-size: 12px">
                <el-dropdown>
                    <i class="el-icon-setting" style="margin-right: 15px"></i>
                    <el-dropdown-menu slot="dropdown">
                        <el-dropdown-item>查看</el-dropdown-item>
                        <el-dropdown-item>新增</el-dropdown-item>
                        <el-dropdown-item>删除</el-dropdown-item>
                    </el-dropdown-menu>
                </el-dropdown>
                <span>{{item.name}}</span>
            </el-header>

            <el-main>
                <router-view :key="$route.path"></router-view>
            </el-main>
        </el-container>
    </el-container>
</template>


<style>
    .el-header {
        background-color: #b3c0d1;
        color: #333;
        line-height: 60px;
    }

    .el-aside {
        color: #333;
    }
</style>

<script>
    export default {
        data() {
            return {
                item: {
                    date: "2016-05-02",
                    name: "王小虎",
                    address: "上海市普陀区金沙江路 1518 弄"
                },
                index:undefined,
                fid:undefined
            };
        },
        mounted() {
            this.fid = localStorage.fid
        },
        methods:{
        }
    };
</script>