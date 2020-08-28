package cn.kion.kionhub.service;

import cn.kion.kionhub.entity.RolePermissionVO;
import cn.kion.kionhub.entity.User;

import java.util.List;

/**
 * @Author Kion
 * @Date 2020-08-24 17:03
 */
public interface AdminService {
    List<User> getAllUser();
    List<RolePermissionVO> getAllRolesPermission();
}
