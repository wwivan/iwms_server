<template>
  <div class="login-container">
    <el-card header="请先登录"
             class="login-card">
      <el-form @submit.native.prevent="login">
        <el-form-item label="选择工厂">
          <el-select v-model="model.fid">
            <el-option v-for="item in factories"
                       :key="item.id"
                       :label="item.factoryName"
                       :value="item.id"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="手机号">
          <el-input v-model="model.mobile"></el-input>
        </el-form-item>
        <el-form-item label="密码">
          <el-input type="password"
                    v-model="model.password"></el-input>
        </el-form-item>
        <el-button type="primary"
                   native-type="submit">登录</el-button>
      </el-form>
    </el-card>
  </div>
</template>

<script>
  export default {
    data() {
      return {
        model: {},
        factories: []
      };
    },
    created() {
      this.fetchFactories();
    },
    methods: {
      async login() {
        const res = await this.$http.post("login/roleUser", this.model);
        // localStorage.token = res.data.token;
        if(res.data.code==0){
          localStorage.token = res.data.data.token;
          localStorage.fid = res.data.data.fid;
          localStorage.utid= res.data.data.userTypeId;
          this.$message({
            type: "success",
            message: res.data.message
          })
          this.$router.push("/");
        }else{
          this.$message.error(res.data.message);
        }

      },
      async fetchFactories() {
        const res = await this.$http.get("factory/list");
        this.factories = res.data.data
      }

    }
  };
</script>

<style>
  .login-card {
    width: 25rem;
    margin: 10rem auto;
  }
</style>