package cn.kion.kionhub.mapper;

import cn.kion.kionhub.entity.Permission;
import cn.kion.kionhub.entity.Role;
import cn.kion.kionhub.entity.RolePermissionVO;
import cn.kion.kionhub.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author Kion
 * @Date 2020-08-26 18:26
 */
@Mapper
public interface RoleMapper {
    /**
     * 根据用户名查询权限
     *
     * @Param   name       用户名
     * @Return  java.util.List<cn.kion.kionhub.entity.Permission>
     *
     * @Date    2020-08-26 18:28
     */
    List<Permission> selectListByUser(@Param("name") String name );

    /**
     * 获取全部角色
     *
     * @Param
     * @Return  java.util.List<cn.kion.kionhub.entity.Role>
     *
     * @Date    2020-08-28 13:39
     */
    List<RolePermissionVO> getAllRolesPermission();
    /**
     * 设置用户的角色
     *
     * @Param   uid
     * @Param   rid
     * @Return  boolean
     *
     * @Date    2020-08-28 11:39
     */
    boolean setUserRole(@Param("uid")Long uid,@Param("rid")Long rid);
    /**
     * 创建角色
     *
     * @Param   roleName
     * @Param   roleDescription
     * @Return  boolean
     *
     * @Date    2020-08-30 13:17
     */
    boolean createRole(@Param("roleName")String roleName,@Param("roleDescription")String roleDescription);
    /**
     * 删除角色
     *
     * @Param   id
     * @Return  boolean
     *
     * @Date    2020-08-30 21:07
     */
    boolean delRole(@Param("id")Long id);
    /**
     * 新增角色权限
     *
     * @Param   rid
     * @Param   pid
     * @Return  boolean
     *
     * @Date    2020-08-30 21:03
     */
    boolean setRolePermission(@Param("rid") Long rid,@Param("pid") Long pid);
    /**
     * 删除角色权限
     *
     * @Param   rid
     * @Param   pid
     * @Return  boolean
     *
     * @Date    2020-08-30 21:04
     */
    boolean delRolePermission(@Param("rid")Long rid,@Param("pid")Long pid);
}
