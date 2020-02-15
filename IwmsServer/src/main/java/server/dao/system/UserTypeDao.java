package server.dao.system;


import org.springframework.data.mongodb.repository.MongoRepository;
import server.entity.system.UserType;

public interface UserTypeDao extends MongoRepository<UserType,String> {
    UserType findUserTypesByType(String type);
}
