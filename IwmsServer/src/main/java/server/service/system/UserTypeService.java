package server.service.system;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.base.SystemReq;
import server.dao.system.UserTypeDao;
import server.entity.system.UserType;

import java.util.List;

@Service
public class UserTypeService {
    @Autowired
    UserTypeDao userTypeDao;



    public void addUserType(UserType userType){
        userTypeDao.save(userType);
    }
    public List<UserType> findAll(){
        List<UserType> all = userTypeDao.findAll();
        return all;
    }
    public UserType findById(SystemReq req){
        String userTypeId = req.getUserTypeId();
        UserType userType = userTypeDao.findById(userTypeId).get();
        return userType;
    }

    public UserType findByName(String userTypeName){
        UserType userType = userTypeDao.findUserTypesByType(userTypeName);
        return userType;
    }
    public void deleteById(SystemReq req){
        String userTypeId = req.getUserTypeId();
        userTypeDao.deleteById(userTypeId);
    }
    public void updateById(String id, UserType userType){
        userType.setId(id);
        userTypeDao.save(userType);
    }
}
