package cn.kion.kionhub.entity;

import lombok.Data;

import java.util.List;

/**
 * 路径权限
 * @Author Kion
 * @Date 2020-08-29 22:21
 */
@Data
public class PathPermissionDO {
    Long id;
    String url;
    List<Permission> permissionList;
}
