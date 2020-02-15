package server.dao.system;

import org.springframework.data.mongodb.repository.MongoRepository;
import server.entity.system.Factory;

public interface FactoryDao extends MongoRepository<Factory,String> {
    Factory findFactoryByFactoryName(String factoryName);
}
