package server.entity.system;

import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * 职位
 */
@Data
public class EmployeeType {
    @Id
    private String id;
    private String empTypeName;
    private String deptId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmpTypeName() {
        return empTypeName;
    }

    public void setEmpTypeName(String empTypeName) {
        this.empTypeName = empTypeName;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }
}
