package cn.kion.kionhub.service;

import cn.kion.kionhub.entity.RolePermissionVO;
import cn.kion.kionhub.entity.User;

import java.util.List;

/**
 * @Author Kion
 * @Date 2020-08-24 17:03
 */
public interface AdminService {
    /**
     * 获取全部角色信息
     *
     * @Param
     * @Return  java.util.List<cn.kion.kionhub.entity.User>
     *
     * @Date    2020-08-30 21:08
     */
    List<User> getAllUser();
    /**
     * 获取全部角色的权限信息
     *
     * @Param
     * @Return  java.util.List<cn.kion.kionhub.entity.RolePermissionVO>
     *
     * @Date    2020-08-30 21:08
     */
    List<RolePermissionVO> getAllRolesPermission();
    /**
     * 改变用户的角色
     *
     * @Param   uid
     * @Param   rid
     * @Return  java.lang.Boolean
     *
     * @Date    2020-08-30 21:08
     */
    Boolean changeRole(Long uid,Long rid);
    /**
     * 创建角色
     *
     * @Param   roleName
     * @Param   roleDescription
     * @Return  java.lang.Boolean
     *
     * @Date    2020-08-30 21:11
     */
    Boolean createRole(String roleName,String roleDescription);
    /**
     * 删除角色
     *
     * @Param   id
     * @Return  java.lang.Boolean
     *
     * @Date    2020-08-30 21:11
     */
    Boolean delRole(Long id);
    /**
     * 新增角色权限
     *
     * @Param   rid
     * @Param   pid
     * @Return  java.lang.Boolean
     *
     * @Date    2020-08-30 21:13
     */
    Boolean setRolePermission(Long rid,Long pid);
    /**
     * 删除角色权限
     *
     * @Param   rid
     * @Param   pid
     * @Return  java.lang.Boolean
     *
     * @Date    2020-08-30 21:13
     */
    Boolean delRolePermission(Long rid,Long pid);
}
