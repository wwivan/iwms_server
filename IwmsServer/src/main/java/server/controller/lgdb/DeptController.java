package server.controller.lgdb;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import server.base.Response;
import server.base.SystemReq;
import server.entity.system.Department;
import server.service.system.DeptService;
import server.util.JwtToken;

import java.util.List;
@JwtToken
@RestController
@CrossOrigin
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    DeptService deptService;

    /**
     * 添加部门
     * @param req
     * @return
     */
    @RequestMapping("/add")
    public Response addDept(@RequestBody Department req){
        Department department = deptService.findByName(req.getDeptName());
        if(department!=null){
            return Response.failed(-1,"部门已存在");
        }else{
            deptService.addDept(req);
            return Response.success(0,"添加成功");
        }
    }

    /**
     * 查看部门列表
     * @return
     */
    @RequestMapping("/list")
    public Response findAll(){
        List<Department> all = deptService.findAll();
        return Response.success(all);
    }

    /**
     * 通过id查询部门
     * @param req
     * @return
     */
    @RequestMapping("/findOne")
    public Response findOne(@RequestBody SystemReq req){
        Department department = deptService.findById(req);
        return Response.success(department);
    }

    /**
     * 删除部门
     * @param req
     * @return
     */
    @RequestMapping("/delete")
    public Response deleteById(@RequestBody SystemReq req){
        deptService.deleteById(req);
        return Response.success(0,"删除成功");
    }

    /**
     * 更新部门信息
     * @param req
     * @return
     */
    @RequestMapping("/update")
    public Response updateById(@RequestBody Department req){
        String id = req.getId();
        deptService.updateById(id,req);
        return Response.success(0,"更新成功");
    }

}
