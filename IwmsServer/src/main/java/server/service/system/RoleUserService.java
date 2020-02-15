package server.service.system;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import server.base.SystemReq;
import server.dao.system.RoleUserDao;
import server.entity.system.FactoryUserTypeMap;
import server.entity.system.RoleUser;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleUserService {
    @Autowired
    RoleUserDao roleUserDao;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public void addRoleUser(RoleUser roleUser){
        roleUser.setPassword(bCryptPasswordEncoder.encode(roleUser.getPassword()));
        roleUserDao.save(roleUser);
    }
    public List<RoleUser> findAll(){
       return roleUserDao.findAll();
    }
    public List<RoleUser> findAll(String factoryId){
        List<RoleUser> all = findAll();
        List<RoleUser> all1=new ArrayList<RoleUser>();
        for (RoleUser roleUser : all) {
            List<FactoryUserTypeMap> factoryUserTypeMapList = roleUser.getFactoryUserTypeMapList();
            for (FactoryUserTypeMap factoryUserTypeMap : factoryUserTypeMapList) {
                if(factoryUserTypeMap.getFid().equals(factoryId)){
                    all1.add(roleUser);
                }
            }
        }
        return all1;
    }

    /**
     * 根据用户类型查询
     * @param fid
     * @param utid
     * @return
     */
    public List<RoleUser> findAll(String fid,String utid){
        RoleUser roleUser = new RoleUser();
        FactoryUserTypeMap factoryUserTypeMap = new FactoryUserTypeMap();
        factoryUserTypeMap.setUtid(utid);
        factoryUserTypeMap.setFid(fid);
        List<FactoryUserTypeMap> factoryUserTypeMapList = new ArrayList<FactoryUserTypeMap>();
        factoryUserTypeMapList.add(factoryUserTypeMap);
        roleUser.setFactoryUserTypeMapList(factoryUserTypeMapList);
        return roleUserDao.findAll(Example.of(roleUser));
    }
    public RoleUser findById(SystemReq req){
        String roleUserId = req.getRoleUserId();
        return roleUserDao.findById(roleUserId).get();
    }
    public RoleUser findByMobile(String mobile){
        return roleUserDao.findByMobile(mobile);
    }
    public void deleteById(SystemReq req){
        String roleUserId = req.getRoleUserId();
        roleUserDao.deleteById(roleUserId);
    }
    public void updateById(String id,RoleUser roleUser){
        roleUser.setId(id);
        RoleUser roleUser1 = roleUserDao.findById(id).get();
        if(roleUser1.getPassword().equals(roleUser.getPassword())){
            roleUserDao.save(roleUser);
        }else{
            roleUser.setPassword(bCryptPasswordEncoder.encode(roleUser.getPassword()));
            roleUserDao.save(roleUser);
        }
    }

    public boolean login(RoleUser req){
        String mobile = req.getMobile();
        RoleUser roleUser = roleUserDao.findByMobile(mobile);
        String password = req.getPassword();
        return bCryptPasswordEncoder.matches(password,roleUser.getPassword());
    }
}
