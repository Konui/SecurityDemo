package cn.kion.kionhub.mapper;

import cn.kion.kionhub.entity.PathPermissionDO;
import cn.kion.kionhub.entity.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author Kion
 * @Date 2020-08-26 19:18
 */
@Mapper
public interface PermissionMapper {
    /**
     * 查询用户对应权限
     *
     * @Param   name
     * @Return  java.util.List<cn.kion.kionhub.entity.Permission>
     *
     * @Date    2020-08-31 16:48
     */
    List<Permission> selectListByUser(@Param("name")String name);
    /**
     * 查询地址对应权限
     *
     * @Param   url
     * @Return  java.util.List<cn.kion.kionhub.entity.Permission>
     *
     * @Date    2020-08-31 16:47
     */
    List<Permission> selectListByPath(@Param("url")String url);
    /**
     * 获取全部地址对应的权限
     *
     * @Param
     * @Return  java.util.List<cn.kion.kionhub.entity.PathPermissionDO>
     *
     * @Date    2020-08-31 16:44
     */
    List<PathPermissionDO> selectAll();
    /**
     * 新增权限
     *
     * @Param   permissionCode
     * @Param   name
     * @Return  boolean
     *
     * @Date    2020-08-31 16:44
     */
    boolean createPermission(@Param("permissionCode")String permissionCode,@Param("permissionName")String name);
    /**
     * 删除权限
     *
     * @Param   id
     * @Return  boolean
     *
     * @Date    2020-08-31 16:44
     */
    boolean delPermission(@Param("id")Long id);
    /**
     * 新增地址
     *
     * @Param   url
     * @Param   descrpition
     * @Return  boolean
     *
     * @Date    2020-08-31 16:44
     */
    boolean createPath(@Param("url")String url,@Param("description")String descrpition);
    /**
     * 删除地址
     *
     * @Param   id
     * @Return  boolean
     *
     * @Date    2020-08-31 16:44
     */
    boolean delPath(@Param("id")Long id);
    /**
     * 新增地址权限
     *
     * @Param   uid
     * @Param   pid
     * @Return  boolean
     *
     * @Date    2020-08-31 16:44
     */
    boolean setPathPermission(@Param("uid")Long uid,@Param("pid")Long pid);
    /**
     * 删除地址权限
     *
     * @Param   uid
     * @Param   pid
     * @Return  boolean
     *
     * @Date    2020-08-31 16:43
     */
    boolean delPathPermission(@Param("uid")Long uid,@Param("pid")Long pid);
}
