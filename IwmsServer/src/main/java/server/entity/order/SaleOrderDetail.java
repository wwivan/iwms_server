package server.entity.order;

import lombok.Data;
import org.springframework.data.annotation.Id;
import server.base.SnowflakeIdWorker;
import server.entity.material.Material;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class SaleOrderDetail {
    @Id
    private String id;
    private SaleOrder saleOrder;//销售单号
    private Material material;//物料
    private String barcode;//物料编码
    private String orderNo;//订单编号
    private Long qty;//销售数量
    private Long outQty;//总出库数量
    private Long retQty;//退货数量

    private Long price;//物料单价 (销售价格)
    private String remark;//备注
    private Date createTime;// 创建时间
    private Date lastTime;// 更新时间
    private Date orderTime;//交期
    private String status;//状态    99  删除
    /*--------------------------------------------*/
    private int realPrice;//实际价格(未使用 cy)
    private int amount;//金额(未使用 cy)
    private BigDecimal weight;// 质量（kg）(未使用 cy)
    private String type;//是否虚拟商品 0普通商品 1虚拟商品(未使用 cy)
    private String orderSource;//订单来源 1 POS  2 手持  3微信 4支付宝 5 QQ 6 新浪微博 7百度糯米(未使用 cy)
    private Integer costPrice;//进货价格(未使用 cy)

    private Long deliveryQty;//未到货数量
    private Long arriveQty;//累计已到货数量

    private String percent;//明细完成情况
    private Long taxRate;//税率

    private Long orderArrived;//订单未发货数量，用于入库明细

    private Long orderQuantity;//订单剩余数量，用于入库对账

    private Long sumAmout;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo() {
        SnowflakeIdWorker snowflakeIdWorker = new SnowflakeIdWorker(0,0);
        Long orderNo = snowflakeIdWorker.nextId();
        this.orderNo = orderNo.toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SaleOrder getSaleOrder() {
        return saleOrder;
    }

    public void setSaleOrder(SaleOrder saleOrder) {
        this.saleOrder = saleOrder;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public Long getQty() {
        return qty;
    }

    public void setQty(Long qty) {
        this.qty = qty;
    }

    public Long getOutQty() {
        return outQty;
    }

    public void setOutQty(Long outQty) {
        this.outQty = outQty;
    }

    public Long getRetQty() {
        return retQty;
    }

    public void setRetQty(Long retQty) {
        this.retQty = retQty;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getRealPrice() {
        return realPrice;
    }

    public void setRealPrice(int realPrice) {
        this.realPrice = realPrice;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOrderSource() {
        return orderSource;
    }

    public void setOrderSource(String orderSource) {
        this.orderSource = orderSource;
    }

    public Integer getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(Integer costPrice) {
        this.costPrice = costPrice;
    }

    public Long getDeliveryQty() {
        return deliveryQty;
    }

    public void setDeliveryQty(Long deliveryQty) {
        this.deliveryQty = deliveryQty;
    }

    public Long getArriveQty() {
        return arriveQty;
    }

    public void setArriveQty(Long arriveQty) {
        this.arriveQty = arriveQty;
    }

    public String getPercent() {
        return percent;
    }

    public void setPercent(String percent) {
        this.percent = percent;
    }

    public Long getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(Long taxRate) {
        this.taxRate = taxRate;
    }

    public Long getOrderArrived() {
        return orderArrived;
    }

    public void setOrderArrived(Long orderArrived) {
        this.orderArrived = orderArrived;
    }

    public Long getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(Long orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public Long getSumAmout() {
        return sumAmout;
    }

    public void setSumAmout(Long sumAmout) {
        this.sumAmout = sumAmout;
    }
}
