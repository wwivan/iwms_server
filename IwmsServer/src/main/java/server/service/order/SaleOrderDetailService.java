package server.service.order;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.dao.order.SaleOrderDetailDao;

@Service
public class SaleOrderDetailService {
    @Autowired
    SaleOrderDetailDao saleOrderDetailDao;
}
