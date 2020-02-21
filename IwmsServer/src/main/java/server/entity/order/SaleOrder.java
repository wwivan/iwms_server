package server.entity.order;

import lombok.Data;
import org.springframework.data.annotation.Id;
import server.base.SnowflakeIdWorker;
import server.entity.system.RoleUser;

import java.util.Date;

@Data
public class SaleOrder {



    @Id
    private String id;
    private String orderNo;
    private Long amount;// 应付金额( 总金额 )
    private Long price;//收款金额   (预付款)
    private String fid; //所属工厂
    private String customerId; //客户id
    private RoleUser customer; //客户

    public RoleUser getCustomer() {
        return customer;
    }

    public void setCustomer(RoleUser customer) {
        this.customer = customer;
    }

    private String salesManId; //  销售员id
    private String approverUserId;//审批人

    private String type;//单据类型（0销售单，1退货单  2已退单）


    private String remark;//备注
    private String status;//状态   0 正在录入   4  未发货(已录入) 5   部分发货  6 全部发货   99 删除/关闭

//    private ReconciliationOrder reconciliationOrder;//对账单

    /*==============================================================================*/
    private Date orderTime;// 交期       交易时间
    private Date actualTime;//实际交期  最后成交时间
    private Date createTime;//创建时间
    private Date lastTime;//最后修改时间

    private String percent;//订单完成百分比
    private String returnRate;//退货率
    private Long taxRate;//税率
    private String cause;//原因
    private String projectName;//项目名称
    private String inType;//临时变量 存放创建类型

    /*==============================================================================*/
    private String operatorId;//销售员标识(未使用)
    private SaleOrder parentSaleOrder;//引用的销售单id  (未使用)

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public void setOrderNo() {
        SnowflakeIdWorker snowflakeIdWorker = new SnowflakeIdWorker(0,0);
        Long orderNo = snowflakeIdWorker.nextId();
        this.orderNo = orderNo.toString();
    }
    public String getOrderNo() {
        return orderNo;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getSalesManId() {
        return salesManId;
    }

    public void setSalesManId(String salesManId) {
        this.salesManId = salesManId;
    }

    public String getApproverUserId() {
        return approverUserId;
    }

    public void setApproverUserId(String approverUserId) {
        this.approverUserId = approverUserId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Date getActualTime() {
        return actualTime;
    }

    public void setActualTime(Date actualTime) {
        this.actualTime = actualTime;
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

    public String getPercent() {
        return percent;
    }

    public void setPercent(String percent) {
        this.percent = percent;
    }

    public String getReturnRate() {
        return returnRate;
    }

    public void setReturnRate(String returnRate) {
        this.returnRate = returnRate;
    }

    public Long getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(Long taxRate) {
        this.taxRate = taxRate;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getInType() {
        return inType;
    }

    public void setInType(String inType) {
        this.inType = inType;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public SaleOrder getParentSaleOrder() {
        return parentSaleOrder;
    }

    public void setParentSaleOrder(SaleOrder parentSaleOrder) {
        this.parentSaleOrder = parentSaleOrder;
    }
}
