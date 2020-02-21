package server.service.material;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import server.base.SystemReq;
import server.dao.material.MaterialDao;
import server.entity.material.Material;

import java.util.List;

@Service
public class MaterialService {
    @Autowired
    MaterialDao materialDao;

    public void addMaterial(Material material){
        materialDao.save(material);
    }
    public List<Material> findAll(String fid){
        Material material = new Material();
        material.setFid(fid);
        Example<Material> example = Example.of(material);
        return materialDao.findAll(example);
    }
    public Material findById(SystemReq req){
        String materialId = req.getMaterialId();
        return materialDao.findById(materialId).get();
    }
    public Material findByCode(String code){
        return materialDao.findByCode(code);
    }
    public void deleteById(SystemReq req){
        String materialId = req.getMaterialId();
        materialDao.deleteById(materialId);
    }
    public void updateById(String id,Material material){
        material.setId(id);
        materialDao.save(material);
    }
}
