package server.controller.material;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import server.base.Response;
import server.base.SystemReq;
import server.entity.material.MaterialCategory;
import server.entity.system.RoleUser;
import server.entity.system.SysUser;
import server.entity.util.GetUserInfo;
import server.service.material.MaterialCategoryService;
import server.util.JwtToken;

import java.util.List;
@JwtToken
@RestController
@RequestMapping("/materialCategory")
@CrossOrigin
public class MaterialCategoryController {
    @Autowired
    MaterialCategoryService materialCategoryService;
    @Autowired
    GetUserInfo getUserInfo;

    /**
     * 添加物料分类
     * @param token
     * @param req
     * @return
     */
    @RequestMapping("/add")
    public Response add( @RequestHeader(value = "Authorization") String token,@RequestBody MaterialCategory req){
        SysUser sysUser = getUserInfo.getSysUser(token);
        MaterialCategory materialCategory = materialCategoryService.findByCode(req.getCode());
        if(materialCategory!=null){
            return Response.failed(-1,"物料分类已存在");
        }else{
            String fid = sysUser.getFid();
            req.setFid(fid);
            materialCategoryService.addMaterialCategory(req);
            return Response.success(0,"物料分类添加成功");
        }
    }

    /**
     * 工厂所对应的物料分类
     * @param token
     * @return
     */
    @RequestMapping("/list")
    public Response findList(@RequestHeader(value = "Authorization") String token){
        SysUser sysUser = getUserInfo.getSysUser(token);
        String fid = sysUser.getFid();
        List<MaterialCategory> all = materialCategoryService.findAll(fid);
        return Response.success(all);
    }

    /**
     * 工厂所对应的物料分类
     * @param token
     * @return
     */
    @RequestMapping("/all")
    public Response findAll(@RequestHeader(value = "Authorization") String token){
        RoleUser roleUser = getUserInfo.getRoleUser(token);
        String fid = roleUser.getFid();
        List<MaterialCategory> all = materialCategoryService.findAll(fid);
        return Response.success(all);
    }

    /**
     * 通过id查询单个物料分类
     * @param req
     * @return
     */
    @RequestMapping("/findOne")
    public Response findOne(@RequestBody SystemReq req){
        MaterialCategory materialCategory = materialCategoryService.findById(req);
        return Response.success(materialCategory);
    }

    /**
     * 删除单个物料分类
     * @param req
     * @return
     */
    @RequestMapping("/delete")
    public Response delete(@RequestBody SystemReq req){
        materialCategoryService.deleteById(req);
        return Response.success(0,"删除成功");
    }

    /**
     * 更新物料分类信息
     * @param req
     * @return
     */
    @RequestMapping("/update")
    public Response update(@RequestBody MaterialCategory req){
        String id = req.getId();
        materialCategoryService.updateById(id,req);
        return Response.success(0,"更新成功");
    }

}
