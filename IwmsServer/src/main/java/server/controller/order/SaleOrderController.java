package server.controller.order;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import server.base.Response;
import server.base.SystemReq;
import server.entity.order.SaleOrder;
import server.service.order.SaleOrderService;

import java.util.List;

@RestController
@RequestMapping("/saleOrder")
public class SaleOrderController {
    @Autowired
    SaleOrderService saleOrderService;

    /**
     * 生成订单
     * @param req
     * @return
     */
    @RequestMapping("/add")
    public Response add(@RequestBody SaleOrder req){
        SaleOrder saleOrder = saleOrderService.findByOrderNo(req.getOrderNo());
        if(saleOrder!=null){
            return Response.failed(-1,"订单已存在");
        }else{
            saleOrderService.addSaleOrder(saleOrder);
            return Response.success(0,"订单生成");
        }
    }

    /**
     * 所有订单列表
     * @return
     */
    @RequestMapping("/list")
    public Response findAll(){
        List<SaleOrder> all = saleOrderService.findAll();
        return Response.success(all);
    }

    /**
     * 通过id查询单个订单
     * @param req
     * @return
     */
    @RequestMapping("/findOne")
    public Response findOne(@RequestBody SystemReq req){
        SaleOrder saleOrder = saleOrderService.findById(req);
        return Response.success(saleOrder);
    }

    /**
     * 删除单个订单
     * @param req
     * @return
     */
    @RequestMapping("/delete")
    public Response deleteById(@RequestBody SystemReq req){
        saleOrderService.deleteById(req);
        return Response.success(0,"删除成功");
    }

    /**
     * 更新订单信息
     * @param req
     * @return
     */
    @RequestMapping("/update")
    public Response updateById(@RequestBody SaleOrder req){
        String id = req.getId();
        saleOrderService.updateById(id,req);
        return Response.success(0,"更新成功");
    }
}
