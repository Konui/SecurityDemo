package cn.kion.kionhub.controller.api;

import cn.kion.kionhub.entity.Role;
import cn.kion.kionhub.entity.RolePermissionVO;
import cn.kion.kionhub.entity.User;
import cn.kion.kionhub.exception.ResultException;
import cn.kion.kionhub.response.JsonResult;
import cn.kion.kionhub.response.ResultCode;
import cn.kion.kionhub.response.ResultTool;
import cn.kion.kionhub.service.AdminService;
import cn.kion.kionhub.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Kion
 * @Date 2020-08-24 17:02
 */
@Slf4j
@RestController
@RequestMapping("/admin")
public class AdminApi {
    //角色->权限->路径

    @Autowired
    AdminService adminService;
    /**
     * 获取全部用户的详细信息
     *
     * @Param
     * @Return  cn.kion.kionhub.response.JsonResult<java.util.List<cn.kion.kionhub.entity.User>>
     *
     * @Date    2020-08-28 13:37
     */
    @GetMapping("/users")
    public JsonResult<List<User>> getAllUser(){
        List<User> list = adminService.getAllUser();
        return ResultTool.success(list);
    }
    /**
     * 获取全部角色的权限信息
     *
     * @Param
     * @Return  cn.kion.kionhub.response.JsonResult<java.util.List<cn.kion.kionhub.entity.RolePermissionVO>>
     *
     * @Date    2020-08-28 14:02
     */
    @GetMapping("/roles")
    public JsonResult<List<RolePermissionVO>> getAllRoles(){
        List<RolePermissionVO> list = adminService.getAllRolesPermission();
        return ResultTool.success(list);
    }
    /**
     * 更改用户角色
     *
     * @Param   uid     用户id
     * @Param   rid     角色id
     * @Return  cn.kion.kionhub.response.JsonResult
     *
     * @Date    2020-08-30 13:06
     */
    @PutMapping("/role/{uid}/{rid}")
    public JsonResult changeRole(@PathVariable("uid")Long uid,@PathVariable("rid")Long rid){
        if(!adminService.changeRole(uid,rid)){
            return ResultTool.fail();
        }
        return ResultTool.success();
    }
    /**
     * 创建角色
     *
     * @Param   role
     * @Return  cn.kion.kionhub.response.JsonResult
     *
     * @Date    2020-08-30 21:09
     */
    @PostMapping("/role")
    public JsonResult createRole(Role role){
        if(ObjectUtils.isEmpty(role)){
            throw new ResultException(ResultCode.PARAM_NOT_VALID);
        }
        adminService.createRole(role.getRoleName(),role.getRoleDescription());
        return ResultTool.success();
    }
    /**
     * 删除角色
     *
     * @Param   role
     * @Return  cn.kion.kionhub.response.JsonResult
     *
     * @Date    2020-08-30 21:19
     */
    @DeleteMapping("/role")
    public JsonResult delRole(Role role){
        if(ObjectUtils.isEmpty(role)){
            throw new ResultException((ResultCode.PARAM_NOT_VALID));
        }
        if(adminService.delRole(role.getId())){
            return ResultTool.fail();
        }
        return ResultTool.success();
    }
    //新增角色权限
    //删除角色权限
}
