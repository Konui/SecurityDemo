package cn.kion.kionhub.service;

import cn.kion.kionhub.entity.PathPermissionDO;
import cn.kion.kionhub.entity.Permission;
import cn.kion.kionhub.entity.User;

import java.util.List;

/**
 * @Author Kion
 * @Date 2020-08-26 19:25
 */
public interface PermissionService {
    List<Permission> selectListByUser(String name);
    List<Permission> selectListByPath(String url);
    List<PathPermissionDO> selectAll();
}
