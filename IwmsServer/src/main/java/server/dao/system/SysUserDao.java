package server.dao.system;


import org.springframework.data.mongodb.repository.MongoRepository;
import server.entity.system.SysUser;

public interface SysUserDao extends MongoRepository<SysUser,String> {
    SysUser findByUserName(String userName);
}
