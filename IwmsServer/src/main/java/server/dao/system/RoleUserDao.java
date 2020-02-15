package server.dao.system;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import server.entity.system.RoleUser;

@Repository
public interface RoleUserDao extends MongoRepository<RoleUser,String> {
    RoleUser findByMobile(String mobile);
}
