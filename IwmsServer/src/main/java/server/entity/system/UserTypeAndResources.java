package server.entity.system;

import lombok.Data;
import server.entity.system.RoleResource;

import java.util.List;

/**
 * 用户类型与资源的集合
 */
@Data
public class UserTypeAndResources {
    private String userType;
    private List<RoleResource> resources;
}
