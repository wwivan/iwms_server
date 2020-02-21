package server.entity.material;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
public class Material {
    @Id
    private String id;
    private String nextSkuList;// 作为下级  所需要的物品barcode 和 数量(例如 一个电风扇 要10个螺丝 1 个电机  1个风扇叶)
    private String materielType;//物料类型 1：原材料 2：成品 cy  3 : 半成品   显示下级物料   但保存的时候 下级物料要反向保存
    private Long stockUseNum;//库存可用数量
    /*=======================================================================*/
    private MaterialCategory materialCategory;// 物料类别 cy
    private String fid;
    private String name;// 物料名称cy
    //    private MaterielUnit materielUnit;// 物料单位cy
    private Long price;// 价格（4位小数）cy 单价
    private Long taxRate;//税率
    private Long weight;// 单件重量（4位小数）  若是 1kg  = 存储 1000cy
    private Long totalWeight;// 总重量（4位小数）  若是 1kg  = 存储 1000cy
    private String model;// 物料型号   /规格cy
    private Date productionDate;// 生产日期 cy
    private String isTray;//是否可以被托盘装载 1:是  0:否 cy
    private String isBatch;//是否可批号管理 1:是  0:否 cy
    private String isUseDate;//是否有效期 1:是  0:否 cy
    private String batchNumber;//批号管理 0:否 1:是 cy
    private Integer selfLife;// 保质期（天）cy
    private Long minStock;//最小库存 cy
    private String barType;// 条码类型 1：rfid 2：纸质条码 cy
    private String barcode;// 条码code cy
    private Date createTime;// 创建时间 cy
    private Date lastTime;// 更新时间 cy
    private Long warehousingPrice;//  入库价格（4位小数） cy
    private String status;// 物料状态 0:禁止 1:正常 cy
    private Long purcharseOrderPrice;//采购价格
    private Long saleOrderPrice;//销售价格
    /*=================================================================================================*/
    private String code;// 物料编码  (未使用 cy)
    private String materielSource;// 物料来源 1：外购 2：自制 3：外协 4：接受无偿赠送 (未使用 cy)
    private String shape;// 物料形状 1：规则固体 2：不规则固体 3：特异物体(未使用 cy)
    private String materielBrand;// 物料品牌(未使用 cy)
    private String meteringType;//计量类型 1 计件  2计重(未使用 cy)
    //    private MaterielAttr materielAttr;//(未使用 cy)
    private Long outgoingPrice;// 预出库价格（4位小数）(未使用 cy)
    private String attrArry;// 物料属性组(未使用 cy)
    private Long maxStock;//最大库存(未使用 cy)
    private Integer sortBy;// 排序号(未使用 cy)
    private Long num;//物料数量

    private Long dhnum;
    private String remark;//备注

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNextSkuList() {
        return nextSkuList;
    }

    public void setNextSkuList(String nextSkuList) {
        this.nextSkuList = nextSkuList;
    }

    public String getMaterielType() {
        return materielType;
    }

    public void setMaterielType(String materielType) {
        this.materielType = materielType;
    }

    public Long getStockUseNum() {
        return stockUseNum;
    }

    public void setStockUseNum(Long stockUseNum) {
        this.stockUseNum = stockUseNum;
    }

    public MaterialCategory getMaterialCategory() {
        return materialCategory;
    }

    public void setMaterialCategory(MaterialCategory materialCategory) {
        this.materialCategory = materialCategory;
    }

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(Long taxRate) {
        this.taxRate = taxRate;
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    public Long getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(Long totalWeight) {
        this.totalWeight = totalWeight;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    public String getIsTray() {
        return isTray;
    }

    public void setIsTray(String isTray) {
        this.isTray = isTray;
    }

    public String getIsBatch() {
        return isBatch;
    }

    public void setIsBatch(String isBatch) {
        this.isBatch = isBatch;
    }

    public String getIsUseDate() {
        return isUseDate;
    }

    public void setIsUseDate(String isUseDate) {
        this.isUseDate = isUseDate;
    }

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    public Integer getSelfLife() {
        return selfLife;
    }

    public void setSelfLife(Integer selfLife) {
        this.selfLife = selfLife;
    }

    public Long getMinStock() {
        return minStock;
    }

    public void setMinStock(Long minStock) {
        this.minStock = minStock;
    }

    public String getBarType() {
        return barType;
    }

    public void setBarType(String barType) {
        this.barType = barType;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    public Long getWarehousingPrice() {
        return warehousingPrice;
    }

    public void setWarehousingPrice(Long warehousingPrice) {
        this.warehousingPrice = warehousingPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getPurcharseOrderPrice() {
        return purcharseOrderPrice;
    }

    public void setPurcharseOrderPrice(Long purcharseOrderPrice) {
        this.purcharseOrderPrice = purcharseOrderPrice;
    }

    public Long getSaleOrderPrice() {
        return saleOrderPrice;
    }

    public void setSaleOrderPrice(Long saleOrderPrice) {
        this.saleOrderPrice = saleOrderPrice;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMaterielSource() {
        return materielSource;
    }

    public void setMaterielSource(String materielSource) {
        this.materielSource = materielSource;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public String getMaterielBrand() {
        return materielBrand;
    }

    public void setMaterielBrand(String materielBrand) {
        this.materielBrand = materielBrand;
    }

    public String getMeteringType() {
        return meteringType;
    }

    public void setMeteringType(String meteringType) {
        this.meteringType = meteringType;
    }

    public Long getOutgoingPrice() {
        return outgoingPrice;
    }

    public void setOutgoingPrice(Long outgoingPrice) {
        this.outgoingPrice = outgoingPrice;
    }

    public String getAttrArry() {
        return attrArry;
    }

    public void setAttrArry(String attrArry) {
        this.attrArry = attrArry;
    }

    public Long getMaxStock() {
        return maxStock;
    }

    public void setMaxStock(Long maxStock) {
        this.maxStock = maxStock;
    }

    public Integer getSortBy() {
        return sortBy;
    }

    public void setSortBy(Integer sortBy) {
        this.sortBy = sortBy;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public Long getDhnum() {
        return dhnum;
    }

    public void setDhnum(Long dhnum) {
        this.dhnum = dhnum;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
