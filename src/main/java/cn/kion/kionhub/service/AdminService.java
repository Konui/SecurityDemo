package cn.kion.kionhub.service;

import cn.kion.kionhub.entity.Logs;
import cn.kion.kionhub.entity.RolePermissionVO;
import cn.kion.kionhub.entity.User;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
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
    /**
     * 新增权限
     *
     * @Param   pCode
     * @Param   pName
     * @Return  java.lang.Boolean
     *
     * @Date    2020-08-31 16:55
     */
    Boolean createPermission(String pCode,String pName);
    /**
     * 删除权限
     *
     * @Param   id
     * @Return  java.lang.Boolean
     *
     * @Date    2020-08-31 16:56
     */
    Boolean delPermission(Long id);
    /**
     * 新增路径
     *
     * @Param   url
     * @Param   description
     * @Return  java.lang.Boolean
     *
     * @Date    2020-08-31 16:56
     */
    Boolean createPath(String url,String description);
    /**
     * 删除路径
     *
     * @Param   id
     * @Return  java.lang.Boolean
     *
     * @Date    2020-08-31 16:56
     */
    Boolean delPath(Long id);
    /**
     * 新增路径所需权限
     *
     * @Param   uid
     * @Param   pid
     * @Return  java.lang.Boolean
     *
     * @Date    2020-08-31 16:56
     */
    Boolean setPathPermission(Long uid,Long pid);
    /**
     * 删除路径所需权限
     *
     * @Param   uid
     * @Param   pid
     * @Return  java.lang.Boolean
     *
     * @Date    2020-08-31 16:56
     */
    Boolean delPathPermission(Long uid,Long pid);
    /**
     * 新增日志
     *
     * @param servletRequest
     * @param servletResponse
     * @param start
     * @param current
     * @return
     */
    void insertLogs(ServletRequest servletRequest, ServletResponse servletResponse, Long start, Long current);
    /**
     * 查询全部日志
     *
     * @Return  java.util.List<cn.kion.kionhub.entity.Logs>
     *
     * @Date    2020-09-09 09:21
     */
    List<Logs> selectAll();
}
