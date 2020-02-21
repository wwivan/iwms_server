<template>
  <div>
<!--    <el-button @click="getCustomer" type="primary">客户列表</el-button>-->
    <el-form>
      <el-form-item label="选择用户类型">
        <el-select v-model="index">
          <el-option v-for="item of status"
                     :key="item.status"
                     :label="item.name"
                     :value="item.status"></el-option>
        </el-select>
      </el-form-item>
    </el-form>

    <h1>用户列表</h1>
    <el-table :data="roleUsers" v-if="this.index==1">
      <el-table-column prop="id"
                       label="ID"
                       width="230">
      </el-table-column>
      <!-- <el-table-column prop="parent.name"
                       label="上级分类">
      </el-table-column> -->
      <el-table-column prop="username"
                       label="用户名">
      </el-table-column>
      <el-table-column prop="empType"
                       label="用户类别">
      </el-table-column>
      <el-table-column fixed="right"
                       label="操作"
                       width="180">
        <template slot-scope="scope">
          <el-button type="primary"
                     size="small"
                     @click="$router.push(`/roleUser/edit/${scope.row.id}`)">编辑</el-button>
          <el-button type="text"
                     size="small"
                     @click="remove(scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-table :data="customers" v-if="this.index==2">
      <el-table-column prop="id"
                       label="ID"
                       width="230">
      </el-table-column>
      <!-- <el-table-column prop="parent.name"
                       label="上级分类">
      </el-table-column> -->
      <el-table-column prop="username"
                       label="用户名">
      </el-table-column>
      <el-table-column prop="empType"
                       label="用户类别">
      </el-table-column>
      <el-table-column fixed="right"
                       label="操作"
                       width="180">
        <template slot-scope="scope">
          <el-button type="primary"
                     size="small"
                     @click="$router.push(`/roleUser/edit/${scope.row.id}`)">编辑</el-button>
          <el-button type="text"
                     size="small"
                     @click="remove(scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-table :data="suppliers" v-if="this.index==3">
      <el-table-column prop="id"
                       label="ID"
                       width="230">
      </el-table-column>
      <!-- <el-table-column prop="parent.name"
                       label="上级分类">
      </el-table-column> -->
      <el-table-column prop="username"
                       label="用户名">
      </el-table-column>
      <el-table-column prop="empType"
                       label="用户类别">
      </el-table-column>
      <el-table-column fixed="right"
                       label="操作"
                       width="180">
        <template slot-scope="scope">
          <el-button type="primary"
                     size="small"
                     @click="$router.push(`/roleUser/edit/${scope.row.id}`)">编辑</el-button>
          <el-button type="text"
                     size="small"
                     @click="remove(scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
  export default {
    data() {
      return {
        roleUsers: [],
        customers:[],
        suppliers:[],
        index:1,
        status: [
          {
            status: 1,
            name: "所有用户"
          },
          {
            status: 2,
            name: "客户"
          },
          {
            status: 3,
            name: "供应商"
          }
        ]
      };
    },
    methods: {
      getCustomer(){
        this.index=2
      },
      async fetch() {
        const res = await this.$http.get("roleUser/list");
        this.roleUsers = res.data.data;
      },
      async fetchCustomers() {
        const res = await this.$http.get("roleUser/customers");
        this.customers = res.data.data;
      },
      async fetchSuppliers() {
        const res = await this.$http.get("roleUser/suppliers");
        this.suppliers = res.data.data;
      },
      async remove(row) {
        this.$confirm(`是否确定要删除角色"${row.username}"`, "提示", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(async () => {
          await this.$http.post("roleUser/delete",{roleUserId:row.id});
          this.$message({
            type: "success",
            message: "删除成功!"
          });
          this.fetch();
        });
      }
    },
    created() {
      this.fetchSuppliers();
      this.fetchCustomers();
      this.fetch();
    }
  };
</script>