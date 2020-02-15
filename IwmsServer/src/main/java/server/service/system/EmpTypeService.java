package server.service.system;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.base.SystemReq;
import server.dao.system.EmpTypeDao;
import server.entity.system.EmployeeType;

import java.util.List;

@Service
public class EmpTypeService {
    @Autowired
    EmpTypeDao empTypeDao;
    public void addEmpType(EmployeeType employeeType){
        empTypeDao.save(employeeType);
    }
    public List<EmployeeType> findAll(){
        return empTypeDao.findAll();
    }
    public EmployeeType findById(SystemReq req){
        String empTypeId = req.getEmpTypeId();
        EmployeeType employeeType = empTypeDao.findById(empTypeId).get();
        return employeeType;
    }
    public EmployeeType findByName(String empTypeName){
        EmployeeType employeeType = empTypeDao.findByEmpTypeName(empTypeName);
        return employeeType;
    }
    public void deleteById(SystemReq req){
        String empTypeId = req.getEmpTypeId();
        empTypeDao.deleteById(empTypeId);
    }
    public void updateById(String id,EmployeeType employeeType){
        employeeType.setId(id);
        empTypeDao.save(employeeType);
    }

}
