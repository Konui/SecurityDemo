package cn.kion.kionhub.entity;

import lombok.Data;

import java.util.List;

/**
 * 用户角色权限显示模型
 *
 * @Author Kion
 * @Date 2020-08-28 13:43
 */
@Data
public class RolePermissionVO {
    Integer id;
    Role role;
    List<Permission> permissionList;
}
