package server.dao.material;

import org.springframework.data.mongodb.repository.MongoRepository;
import server.entity.material.Material;

public interface MaterialDao extends MongoRepository<Material,String> {
    Material findByCode(String code);
}
