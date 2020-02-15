package server.controller.lgdb;

import com.alibaba.fastjson.JSONObject;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import server.base.Response;
import server.base.SystemReq;
import server.entity.system.RoleUser;
import server.entity.system.SysUser;
import server.entity.system.UserType;
import server.service.system.RoleUserService;
import server.service.system.UserTypeService;
import server.util.JwtUtil;

import java.util.List;

import static server.util.Util.isMobile;


@RestController
@CrossOrigin
@RequestMapping("/roleUser")
public class RoleUserController {
    @Autowired
    RoleUserService roleUserService;
    @Autowired
    UserTypeService userTypeService;

    /**
     * 添加用户
     *
     * @param req
     * @return
     */
    @RequestMapping("/add")
    public Response addRoleUser(@RequestBody RoleUser req) {
        String mobile = req.getMobile();
        RoleUser roleUser = roleUserService.findByMobile(mobile);
        if (roleUser != null) {
            return Response.failed(-1, "用户已存在");
        }else if(!isMobile(mobile)){
            return Response.failed(-1,"手机号码不正确");
        } else {
            roleUserService.addRoleUser(req);
            return Response.success(0,"添加用户成功");
        }
    }

    /**
     * 查看用户列表
     * 查看系统用户
     * @return
     */
    @RequestMapping("/list")
    public Response findAll( @RequestHeader(value = "Authorization") String token) {
        System.out.println("token=" + token);
        String userId = JwtUtil.getUserId(token);
        System.out.println(userId);
        JSONObject jsonObject =(JSONObject) JSONObject.parseObject(userId);
        SysUser sysUser = jsonObject.toJavaObject(jsonObject, SysUser.class);
        String fid = sysUser.getFid();
        List<RoleUser> all;
        if(fid.equals("admin")){
            System.out.println("查询所有");
            all = roleUserService.findAll();
        }else{
            System.out.println("查询工厂里的");
            System.out.println(fid);
            all = roleUserService.findAll(fid);
        }
        return Response.success(all);
    }

    @RequestMapping("/customers")
    public Response findAllCustomer( @RequestHeader(value = "Authorization") String token) {
        String userId = JwtUtil.getUserId(token);
        System.out.println(userId);
        JSONObject jsonObject =(JSONObject) JSONObject.parseObject(userId);
        String fid =(String) jsonObject.get("fid");
        UserType customer = userTypeService.findByName("客户");
        String utid = customer.getId();
        List<RoleUser> all;
        all = roleUserService.findAll(fid,utid);
        return Response.success(all);
    }
    /**
     * 通过id查询用户
     * @param req
     * @return
     */
    @RequestMapping("/findOne")
    public Response findOne(@RequestBody SystemReq req) {
        return Response.success(roleUserService.findById(req));
    }

    /**
     * 通过id删除用户
     * @param req
     * @return
     */
    @RequestMapping("/delete")
    public Response deleteById(@RequestBody SystemReq req){
        roleUserService.deleteById(req);
        return Response.success(0,"删除用户成功");
    }

    /**
     * 更新用户信息
     * @param req
     * @return
     */
    @RequestMapping("/update")
    public Response updateById(@RequestBody RoleUser req){
        String mobile = req.getMobile();
        String id = req.getId();
        if(!isMobile(mobile)){
            return Response.failed("手机号码不正确");
        }else{
            roleUserService.updateById(id,req);
            return Response.success(0,"更新成功");
        }
    }
}
