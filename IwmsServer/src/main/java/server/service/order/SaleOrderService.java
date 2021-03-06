package server.service.order;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import server.base.SystemReq;
import server.dao.order.SaleOrderDao;
import server.entity.order.SaleOrder;

import java.util.List;

@Service
public class SaleOrderService {
    @Autowired
    SaleOrderDao saleOrderDao;

    public void addSaleOrder(SaleOrder saleOrder){
        saleOrderDao.save(saleOrder);
    }
    public List<SaleOrder> findAll(String roleUserId,String fid){
        SaleOrder saleOrder = new SaleOrder();
        saleOrder.setFid(fid);
        saleOrder.setSalesManId(roleUserId);
        Example example = Example.of(saleOrder);
        return saleOrderDao.findAll(example);
    }
    public SaleOrder findById(SystemReq req){
        String saleOrderId = req.getSaleOrderId();
        return saleOrderDao.findById(saleOrderId).get();
    }
    public SaleOrder findByOrderNo(String orderNo){
        return saleOrderDao.findByOrderNo(orderNo);
    }
    public void deleteById(SystemReq req){
        String saleOrderId = req.getSaleOrderId();
        saleOrderDao.deleteById(saleOrderId);
    }
    public void updateById(String id,SaleOrder saleOrder){
        saleOrder.setId(id);
        saleOrderDao.save(saleOrder);
    }
}
