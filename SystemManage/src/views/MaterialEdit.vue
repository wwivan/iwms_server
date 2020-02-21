<template>
    <div>
        <h1>{{id?'编辑':'新增'}}物料分类</h1>
        <el-form label-width="120px"
                 @submit.native.prevent="save">
            <el-tabs value="basic"
                     type="border-card">
                <el-tab-pane label="基本信息"
                             name="basic">
                    <el-form-item label="物料分类名称">
                        <el-input v-model="model.name"></el-input>
                    </el-form-item>
                    <el-form-item label="code">
                        <el-input v-model="model.code"></el-input>
                    </el-form-item>
                    <el-form-item label="型号">
                        <el-input v-model="model.model"></el-input>
                    </el-form-item>
                    <el-form-item label="最小库存">
                        <el-input v-model="model.minStock"></el-input>
                    </el-form-item>
                    <el-form-item label="所属物料分类">
                        <el-select v-model="model.materialCategory" value-key="id">
                            <el-option v-for="item of materialCategories"
                                       :key="item.id"
                                       :label="item.name"
                                       :value="item"></el-option>
                        </el-select>
                    </el-form-item>
                    <el-form-item label="建议价格">
                        <el-input v-model="model.price"></el-input>
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
            id: {}
        },
        data() {
            return {
                model: {},
                materialCategories:[]
            };
        },
        methods: {

            async save() {
                let res;
                if (this.id) {
                    this.model.id = this.id;
                    res = await this.$http.post(`material/update`, this.model);
                } else {
                    res = await this.$http.post("material/add", this.model);
                }
                this.$router.push("/material/list");
                this.$message({
                    type: "success",
                    message: res.data.message
                });
            },
            async fetch() {
                const res = await this.$http.post(`material/findOne`, {materialId: this.id});
                this.model = res.data.data;
            },
            async fetchParent(){
                const res = await this.$http.get('materialCategory/list')
                this.materialCategories = res.data.data
            }
        },
        created() {
            this.fetchParent();
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