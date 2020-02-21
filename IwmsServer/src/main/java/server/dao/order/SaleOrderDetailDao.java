package server.dao.order;


import org.springframework.data.mongodb.repository.MongoRepository;
import server.entity.order.SaleOrderDetail;

public interface SaleOrderDetailDao extends MongoRepository<SaleOrderDetail,String> {
    SaleOrderDetail findByOrderNo(String orderNo);
}
