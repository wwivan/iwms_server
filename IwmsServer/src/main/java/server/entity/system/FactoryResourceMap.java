package server.entity.system;

import lombok.Data;

import java.util.List;

/**
 * 工厂跟资源的集合
 */
@Data
public class FactoryResourceMap {
    private Factory factory;
    private List<UserTypeAndResources> userTypeAndResourcesList;
}
