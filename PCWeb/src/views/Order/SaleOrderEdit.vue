<template>
    <div>
        <h1>{{id?'编辑':'新增'}}订单</h1>
        <el-steps :active="active" finish-status="success">
            <el-step title="新建销售主单"></el-step>
            <el-step title="新增销售明细单"></el-step>
            <el-step title="选择物料"></el-step>
        </el-steps>
        <el-button style="margin-top: 12px;" @click="next">下一步</el-button>
        <el-form label-width="120px"
                 @submit.native.prevent="save">
            <el-tabs value="basic"
                     type="border-card">
                <el-tab-pane label="基本信息"
                             name="basic">
                    <el-form-item label="销售单号">
                        <el-input v-model="model.orderNo"></el-input>
                    </el-form-item>
                    <el-form-item label="应付金额">
                        <el-input v-model="model.amount"></el-input>
                    </el-form-item>
                    <el-form-item label="收款金额">
                        <el-input v-model="model.price"></el-input>
                    </el-form-item>
                    <el-form-item label="所属工厂">
                        <el-input v-model="model.fid"></el-input>
                    </el-form-item>
                    <el-form-item label="客户">
                        <el-select v-model="model.customerId">
                            <el-option v-for="item of customers"
                                       :key="item.id"
                                       :label="item.username"
                                       :value="item.id"></el-option>
                        </el-select>
                    </el-form-item>
                </el-tab-pane>
                <el-tab-pane label="详细信息"
                             name="detail">
                </el-tab-pane>
            </el-tabs>
            <el-form-item>
                <el-button type="primary"
                           native-type="submit">保存
                </el-button>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
    export default {
        props: {
            id: {},
        },
        data() {
            return {
                model: {},
                ruleForm: {},
                customers:[],
                active: 0
            };
        },
        methods: {
            //这个才是最主要的
            handleAvatarSuccess(res) {
                this.model.logo = res.data
            },
            next() {
                if (this.active++ > 2) this.active = 0;
            },
            async save() {
                let res;
                if (this.id) {
                    this.model.id = this.id;
                    res = await this.$http.post(`saleOrder/update`, this.model);
                } else {
                    res = await this.$http.post("saleOrder/addSaleOrder", this.model);
                }
                this.$router.push("/saleOrder/list");
                this.$message({
                    type: "success",
                    message: res.data.message
                });
            },
            async fetch() {
                const res = await this.$http.post(`saleOrder/findOne`, {saleOrderId: this.id});
                this.model = res.data.data;
            },
            async fetchCustomers(){
                const res = await this.$http.post('roleUser/customers')
                this.customers = res.data.data;
            }
        },
        created() {
            this.fetchCustomers();
            this.id && this.fetch();
        }
    };
</script>
<style>
    .avatar-uploader .el-upload {
        border: 1px dashed #d9d9d9;
        border-radius: 6px;
        cursor: pointer;
        position: relative;
        overflow: hidden;
    }

    .avatar-uploader .el-upload:hover {
        border-color: #409eff;
    }

    .avatar-uploader-icon {
        font-size: 28px;
        color: #8c939d;
        width: 178px;
        height: 178px;
        line-height: 178px;
        text-align: center;
    }

    .avatar {
        width: 178px;
        height: 178px;
        display: block;
    }
</style>