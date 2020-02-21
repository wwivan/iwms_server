package server.controller.order;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import server.base.Response;
import server.base.SystemReq;
import server.entity.order.SaleOrder;
import server.entity.system.RoleUser;
import server.entity.util.GetUserInfo;
import server.service.order.SaleOrderService;
import server.util.JwtToken;
import server.util.JwtUtil;

import java.util.List;
@JwtToken
@RestController
@CrossOrigin
@RequestMapping("/saleOrder")
public class SaleOrderController {
    @Autowired
    SaleOrderService saleOrderService;
    @Autowired
    GetUserInfo getUserInfo;

    /**
     * 生成订单
     * @param req
     * @return
     */
    @PostMapping("/add")
    public Response add(@RequestBody SaleOrder req, @RequestHeader(value = "Authorization") String token){
        RoleUser roleUser = getUserInfo.getRoleUser(token);
        String roleUserId = roleUser.getId();
        String directorId = roleUser.getDirectorId();
        String fid = roleUser.getFid();
        SaleOrder saleOrder = saleOrderService.findByOrderNo(req.getId());
        req.setOrderNo();
        req.setSalesManId(roleUserId);
        req.setApproverUserId(directorId);
        req.setFid(fid);
        if(saleOrder!=null){
            return Response.failed(-1,"订单已存在");
        }else{
            saleOrderService.addSaleOrder(req);
            return Response.success(0,"主单生成");
        }
    }

    /**
     * 所有订单列表
     * @return
     */
    @RequestMapping("/list")
    public Response findAll(@RequestHeader(value = "Authorization") String token){
        RoleUser roleUser = getUserInfo.getRoleUser(token);
        String roleUserId = roleUser.getId();
        String fid = roleUser.getFid();
        List<SaleOrder> all = saleOrderService.findAll(roleUserId,fid);
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
