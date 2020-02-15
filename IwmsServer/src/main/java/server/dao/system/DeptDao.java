package server.dao.system;


import org.springframework.data.mongodb.repository.MongoRepository;
import server.entity.system.Department;

public interface DeptDao extends MongoRepository<Department,String> {
    Department findDepartmentByDeptName(String deptName);
}
