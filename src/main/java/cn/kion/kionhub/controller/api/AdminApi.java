package cn.kion.kionhub.controller.api;

import cn.kion.kionhub.entity.Role;
import cn.kion.kionhub.entity.RolePermissionVO;
import cn.kion.kionhub.entity.User;
import cn.kion.kionhub.response.JsonResult;
import cn.kion.kionhub.response.ResultTool;
import cn.kion.kionhub.service.AdminService;
import cn.kion.kionhub.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
    @PutMapping("/role")
    public JsonResult changeRole(){

        return ResultTool.success();
    }
}
