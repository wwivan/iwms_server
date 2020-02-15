package server.entity.system;

import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * 部门
 */
@Data
public class Department {
    @Id
    private String id;
    private String deptName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}
