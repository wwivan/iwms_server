package server.dao.system;


import org.springframework.data.mongodb.repository.MongoRepository;
import server.entity.system.RoleResource;

public interface RoleResourceDao extends MongoRepository<RoleResource,String> {
}
