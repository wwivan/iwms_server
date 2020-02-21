package server.service.material;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import server.base.SystemReq;
import server.dao.material.MaterialCategoryDao;
import server.entity.material.MaterialCategory;

import java.util.List;
@Service
public class MaterialCategoryService {
    @Autowired
    MaterialCategoryDao materialCategoryDao;

    public void addMaterialCategory(MaterialCategory materialCategory){
      materialCategoryDao.save(materialCategory);
    }
    public List<MaterialCategory> findAll(String fid){
        MaterialCategory materialCategory = new MaterialCategory();
        materialCategory.setFid(fid);
        Example<MaterialCategory> example = Example.of(materialCategory);
        return materialCategoryDao.findAll(example);
    }

    public MaterialCategory findById(SystemReq req){
        String materialGategoryId = req.getMaterialCategoryId();
        return materialCategoryDao.findById(materialGategoryId).get();
    }
    public MaterialCategory findByCode(String code){
        return materialCategoryDao.findByCode(code);
    }
    public void deleteById(SystemReq req){
        String materialGategoryId = req.getMaterialCategoryId();
        materialCategoryDao.deleteById(materialGategoryId);
    }
    public void updateById(String id,MaterialCategory materialCategory){
        materialCategory.setId(id);
        materialCategoryDao.save(materialCategory);
    }

}
