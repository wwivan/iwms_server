package server.controller.material;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import server.base.Response;
import server.base.SystemReq;
import server.entity.material.Material;
import server.entity.system.RoleUser;
import server.entity.system.SysUser;
import server.entity.util.GetUserInfo;
import server.service.material.MaterialService;
import server.util.JwtToken;

import java.util.List;

@JwtToken
@RestController
@RequestMapping("/material")
@CrossOrigin
public class MaterialController {
    @Autowired
    MaterialService materialService;
    @Autowired
    GetUserInfo getUserInfo;

    /**
     * 运营管理添加物料
     *
     * @param token
     * @param req
     * @return
     */
    @RequestMapping("/add")
    public Response add(@RequestHeader(value = "Authorization") String token,@RequestBody Material req) {
//        RoleUser roleUser = getUserInfo.getRoleUser(token);
        SysUser sysUser = getUserInfo.getSysUser(token);
        Material material = materialService.findByCode(req.getCode());
        if (material != null) {
            return Response.failed(-1, "物料已存在");
        } else {
            String fid = sysUser.getFid();
            req.setFid(fid);
            materialService.addMaterial(req);
            return Response.success(0, "物料添加成功");
        }
    }

    /**
     * 所有物料
     *
     * @param token
     * @return
     */
    @RequestMapping("/list")
    public Response findList(@RequestHeader(value = "Authorization") String token) {
//        RoleUser roleUser = getUserInfo.getRoleUser(token);
        SysUser sysUser = getUserInfo.getSysUser(token);
        String fid = sysUser.getFid();
        List<Material> all = materialService.findAll(fid);
        return Response.success(all);
    }

    /**
     * 所有物料
     *
     * @param token
     * @return
     */
    @RequestMapping("/all")
    public Response findAll(@RequestHeader(value = "Authorization") String token) {
        RoleUser roleUser = getUserInfo.getRoleUser(token);
        String fid = roleUser.getFid();
        List<Material> all = materialService.findAll(fid);
        return Response.success(all);
    }

    /**
     * 根据id查找物料
     *
     * @param req
     * @return
     */
    @RequestMapping("/findOne")
    public Response findOne(@RequestBody SystemReq req) {
        Material material = materialService.findById(req);
        return Response.success(material);
    }

    /**
     * 根据id删除物料
     *
     * @param req
     * @return
     */
    @RequestMapping("/delete")
    public Response delete(@RequestBody SystemReq req) {
        materialService.deleteById(req);
        return Response.success(0, "删除成功");
    }

    /**
     * 更新物料信息
     *
     * @param req
     * @return
     */
    @RequestMapping("/update")
    public Response update(@RequestBody Material req) {
        String id = req.getId();
        materialService.updateById(id, req);
        return Response.success(0, "更新成功");
    }

}
