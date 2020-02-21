<template>
    <div>
        <el-button @click="$router.push('/saleOrder/create')" type="primary">+新增订单</el-button>
        <h1>工厂列表</h1>
        <el-table :data="orders">
            <el-table-column prop="id"
                             label="ID"
                             width="230">
            </el-table-column>
            <!-- <el-table-column prop="parent.name"
                             label="上级分类">
            </el-table-column> -->
            <el-table-column prop="orderNo"
                             label="订单号">
            </el-table-column>

            <el-table-column fixed="right"
                             label="操作"
                             width="180">
                <template slot-scope="scope">
                    <el-button type="primary"
                               size="small"
                               @click="$router.push(`/saleOrder/edit/${scope.row.id}`)">编辑
                    </el-button>
                    <el-button type="text"
                               size="small"
                               @click="remove(scope.row)">删除
                    </el-button>
                </template>
            </el-table-column>
        </el-table>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                orders: [],
                dialog: false,
            };
        },
        methods: {
            async fetch() {
                const res = await this.$http.get("saleOrder/list");
                this.orders = res.data.data;
            },
            async remove(row) {
                this.$confirm(`是否确定要删除工厂"${row.orderNo}"`, "提示", {
                    confirmButtonText: "确定",
                    cancelButtonText: "取消",
                    type: "warning"
                }).then(async () => {
                    await this.$http.post("factory/delete", {saleOrderId: row.id});
                    this.$message({
                        type: "success",
                        message: "删除成功!"
                    });
                    this.fetch();
                });
            }
        },
        created() {
            this.fetch();
        }
    };
</script>