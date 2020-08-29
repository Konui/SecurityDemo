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
    List<Permission> selectListByUser(@Param("name")String name);
    List<Permission> selectListByPath(@Param("url")String url);
    List<PathPermissionDO> selectAll();
}
