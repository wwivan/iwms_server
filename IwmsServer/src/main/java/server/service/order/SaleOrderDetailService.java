package server.service.order;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import server.base.SystemReq;
import server.dao.order.SaleOrderDetailDao;
import server.entity.order.SaleOrder;
import server.entity.order.SaleOrderDetail;

import java.util.List;

@Service
public class SaleOrderDetailService {
    @Autowired
    SaleOrderDetailDao saleOrderDetailDao;
    public void addSaleOrderDetail(SaleOrderDetail saleOrderDetail){
        saleOrderDetailDao.save(saleOrderDetail);
    }

    public List<SaleOrderDetail> findAll(SaleOrder saleOrder){
        SaleOrderDetail saleOrderDetail = new SaleOrderDetail();
        saleOrderDetail.setSaleOrder(saleOrder);
        Example<SaleOrderDetail> example = Example.of(saleOrderDetail);
        return saleOrderDetailDao.findAll(example);
    }

    public SaleOrderDetail findById(SystemReq req){
        String saleOrderDetailId = req.getSaleOrderDetailId();
        return saleOrderDetailDao.findById(saleOrderDetailId).get();
    }
    public SaleOrderDetail findByOrderNo(String orderNo){
        return saleOrderDetailDao.findByOrderNo(orderNo);
    }
    public void deleteById(SystemReq req){
        String saleOrderDetailId = req.getSaleOrderDetailId();
        saleOrderDetailDao.deleteById(saleOrderDetailId);
    }
    public void updateById(String id,SaleOrderDetail saleOrderDetail){
        saleOrderDetail.setId(id);
        saleOrderDetailDao.save(saleOrderDetail);
    }

}
