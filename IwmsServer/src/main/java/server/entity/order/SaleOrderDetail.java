package server.entity.order;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class SaleOrderDetail {
    @Id
    private String id;
    private SaleOrder saleOrder;//销售单号
//    private MaterielSku materielSku;//物料
    private String barcode;//物料编码

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


}
