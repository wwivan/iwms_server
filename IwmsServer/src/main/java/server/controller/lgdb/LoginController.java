package server.controller.lgdb;

import com.alibaba.fastjson.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import server.base.Response;
import server.entity.system.FactoryUserTypeMap;
import server.entity.system.RoleUser;
import server.entity.system.SysUser;
import server.service.system.RoleUserService;
import server.service.system.SysUserService;
import server.util.JwtUtil;

import java.util.List;

@RestController
@RequestMapping("/login")
@CrossOrigin
public class LoginController {
    @Autowired
    SysUserService sysUserService;
    @Autowired
    RoleUserService roleUserService;

    /**
     * 系统管理员登录
     * @param req
     * @return
     */
    @RequestMapping("/sysUser")
    public Response SysUserLogin(@RequestBody SysUser req){
        String userName = req.getUserName();
        SysUser sysUser = sysUserService.findByName(userName);
        boolean login = sysUserService.login(req);
        if(!login){
            return Response.failed(-1,"登陆失败");
        }else{
            JSONObject object=new JSONObject();
            object.put("id",sysUser.getId());
            object.put("userName",sysUser.getUserName());
            object.put("fid",sysUser.getFid());
            String token= JwtUtil.sign(object.toString());
            JSONObject data = new JSONObject();
            data.put("token",token);
            data.put("fid",sysUser.getFid());
            return Response.success(data);
        }
    }

    /**
     * 用户登录
     * @param req
     * @return
     */
    @RequestMapping("/roleUser")
    public Response roleUserLogin(@RequestBody RoleUser req){
        String mobile = req.getMobile();
        String fid = req.getFid();
        RoleUser roleUser = roleUserService.findByMobile(mobile);
        boolean login = roleUserService.login(req);
        if(!login){
            return Response.failed(-1,"登陆失败");
        }else if(fid==null){
            return Response.failed(-1,"请选择所在工厂");
        }else{

            JSONObject object=new JSONObject();
            object.put("id",roleUser.getId());
            object.put("userName",roleUser.getUsername());
            /**
             * 根据已经获得的fid遍历对应的userTypeId
             */
            String userTypeId = null;
            List<FactoryUserTypeMap> factoryUserTypeMapList = roleUser.getFactoryUserTypeMapList();
            for (FactoryUserTypeMap factoryUserTypeMap : factoryUserTypeMapList) {
                if(factoryUserTypeMap.getFid().equals(fid)){
                    userTypeId = factoryUserTypeMap.getUtid();
                }
            }
            object.put("userTypeId",userTypeId);
            object.put("mobile",roleUser.getMobile());
            object.put("fid",fid);
            if(roleUser.getDirectorId()!=null){
                object.put("directorId",roleUser.getDirectorId());
            }
            String token= JwtUtil.sign(object.toString());
            JSONObject data = new JSONObject();
            data.put("token",token);
            data.put("fid",fid);
            data.put("userTypeId",userTypeId);
            return Response.success(data);
        }
    }

    @RequestMapping("/getInfo")
    public Response getInfo(@RequestBody RoleUser req){
        String mobile = req.getMobile();
        RoleUser roleUser = roleUserService.findByMobile(mobile);
        if(roleUser!=null){
            List<FactoryUserTypeMap> factoryUserTypeMapList = roleUser.getFactoryUserTypeMapList();
            return Response.success(factoryUserTypeMapList);
        }else{
            return Response.failed(-1,"没有该用户");
        }
    }
}
