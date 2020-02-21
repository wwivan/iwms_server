package server.controller.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import server.base.Response;
import server.base.SystemReq;
import server.entity.order.SaleOrder;
import server.entity.order.SaleOrderDetail;
import server.entity.system.RoleUser;
import server.entity.util.GetUserInfo;
import server.service.order.SaleOrderDetailService;
import server.service.order.SaleOrderService;
import server.util.JwtToken;

import java.util.List;

@RestController
@RequestMapping("/saleOrderDetail")
@JwtToken
@CrossOrigin
public class SaleOrderDetailController {
    @Autowired
    SaleOrderDetailService saleOrderDetailService;
    @Autowired
    GetUserInfo getUserInfo;
    @Autowired
    SaleOrderService saleOrderService;

    /**
     * 生成子订单
     * @param req
     * @param token
     * @return
     */
    @PostMapping("/add")
    public Response add(@RequestBody SaleOrderDetail req,@RequestHeader(value = "Authorization") String token){
        RoleUser roleUser = getUserInfo.getRoleUser(token);
        String saleOrderNo = req.getSaleOrder().getOrderNo();
        SaleOrder saleOrder = saleOrderService.findByOrderNo(saleOrderNo);
        req.setSaleOrder(saleOrder);
        String orderNo = req.getOrderNo();
        SaleOrderDetail saleOrderDetail = saleOrderDetailService.findByOrderNo(orderNo);
        if(saleOrderDetail!=null){
            return Response.failed(-1,"订单已存在");
        }else{
            saleOrderDetailService.addSaleOrderDetail(req);
            return Response.success(0,"子订单生成");
        }
    }

    /**
     * 查找对应主订单下的子单
     * @param token
     * @param req
     * @return
     */
    @RequestMapping("/list")
    public Response findAll(@RequestHeader(value = "Authorization")String token,@RequestBody SaleOrder req){
        List<SaleOrderDetail> all = saleOrderDetailService.findAll(req);
        return Response.success(all);
    }

    /**
     * 通过id查找订单
     * @param req
     * @return
     */
    @RequestMapping("/findOne")
    public Response findOne(@RequestBody SystemReq req){
        return Response.success(saleOrderDetailService.findById(req));
    }

    /**
     * 删除单个订单
     * @param req
     * @return
     */
    @RequestMapping("/delete")
    public Response deleteById(@RequestBody SystemReq req){
        saleOrderDetailService.deleteById(req);
        return Response.success(0,"删除订单成功");
    }

    /**
     * 更新订单信息
     * @param req
     * @return
     */
    @RequestMapping("/update")
    public Response updateById(@RequestBody SaleOrderDetail req){
        String id = req.getId();
        saleOrderDetailService.updateById(id,req);
        return Response.success(0,"更新订单成功");
    }
}
