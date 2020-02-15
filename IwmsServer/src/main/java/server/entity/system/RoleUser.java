package server.entity.system;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * 用户
 */
@Document(collection = "role_user")
@Data
@AllArgsConstructor //全参构造
@NoArgsConstructor //无参构造函数
@ToString
public class RoleUser {
    @Id
    private String id;
    private String directorId;//部门主管id
    private String mobile;//手机号
    private String openId;//微信openid 需关注公众号
    private String username;
    private String password;
//    private List<String> subordinateEmpId;//下属员工id
    private String empType;//职位
    private List<FactoryUserTypeMap> factoryUserTypeMapList ;//工厂与用户类型的集合
    private String fid; //临时储存fid

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDirectorId() {
        return directorId;
    }

    public void setDirectorId(String directorId) {
        this.directorId = directorId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmpType() {
        return empType;
    }

    public void setEmpType(String empType) {
        this.empType = empType;
    }

    public List<FactoryUserTypeMap> getFactoryUserTypeMapList() {
        return factoryUserTypeMapList;
    }

    public void setFactoryUserTypeMapList(List<FactoryUserTypeMap> factoryUserTypeMapList) {
        this.factoryUserTypeMapList = factoryUserTypeMapList;
    }
}
