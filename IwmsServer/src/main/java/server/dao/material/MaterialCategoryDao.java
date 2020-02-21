package server.dao.material;

import org.springframework.data.mongodb.repository.MongoRepository;
import server.entity.material.MaterialCategory;

public interface MaterialCategoryDao extends MongoRepository<MaterialCategory,String> {
    MaterialCategory findByCode(String code);
}
