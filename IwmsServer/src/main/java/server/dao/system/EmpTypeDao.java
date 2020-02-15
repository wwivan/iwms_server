package server.dao.system;


import org.springframework.data.mongodb.repository.MongoRepository;
import server.entity.system.EmployeeType;

public interface EmpTypeDao extends MongoRepository<EmployeeType,String> {
    EmployeeType findByEmpTypeName(String empTypeName);
}
