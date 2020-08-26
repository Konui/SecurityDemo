package cn.kion.kionhub.mapper;

import cn.kion.kionhub.entity.Permission;
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
}
