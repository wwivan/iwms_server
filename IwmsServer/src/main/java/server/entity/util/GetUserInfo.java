package server.entity.util;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;
import server.entity.system.RoleUser;
import server.entity.system.SysUser;
import server.util.JwtUtil;
@Component
public class GetUserInfo {
    /**
     * 根据token获取相应的角色用户
     * @param token
     * @return
     */
    public RoleUser getRoleUser(String token){
        String userId = JwtUtil.getUserId(token);
        JSONObject jsonObject = (JSONObject) JSONObject.parse(userId);
        RoleUser roleUser = jsonObject.toJavaObject(jsonObject, RoleUser.class);
        return roleUser;
    }

    /**
     * 根据token获取相应的系统用户
     * @param token
     * @return
     */
    public SysUser getSysUser(String token){
        String userId = JwtUtil.getUserId(token);
        JSONObject jsonObject = (JSONObject) JSONObject.parse(userId);
        SysUser sysUser = jsonObject.toJavaObject(jsonObject, SysUser.class);
        return sysUser;
    }
}
