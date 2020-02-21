<template>
  <div>
    <h1>物料列表</h1>
    <el-table :data="materials">
      <el-table-column prop="id"
                       label="ID"
                       width="300">
      </el-table-column>
      <!-- <el-table-column prop="parent.name"
                       label="上级分类">
      </el-table-column> -->
      <el-table-column prop="name"
                       label="物料分类">
      </el-table-column>

      <el-table-column fixed="right"
                       label="操作"
                       width="180">
        <template slot-scope="scope">
          <el-button type="primary"
                     size="small"
                     @click="$router.push(`/material/edit/${scope.row.id}`)">编辑</el-button>
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
        materials: []
      };
    },
    methods: {
      async fetch() {
        const res = await this.$http.get("material/list");
        this.materials = res.data.data;
      },
      async remove(row) {
        this.$confirm(`是否确定要删除物料"${row.name}"`, "提示", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(async () => {
          await this.$http.post("material/delete",{materialId:row.id});
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