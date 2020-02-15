package server.dao.order;

import org.springframework.data.mongodb.repository.MongoRepository;
import server.entity.order.SaleOrder;

public interface SaleOrderDao extends MongoRepository<SaleOrder,String> {
    SaleOrder findByOrderNo(String orderNo);
}
