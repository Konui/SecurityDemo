package cn.kion.kionhub.service.impl;

import cn.kion.kionhub.entity.RolePermissionVO;
import cn.kion.kionhub.entity.User;
import cn.kion.kionhub.exception.ResultException;
import cn.kion.kionhub.mapper.LogsMapper;
import cn.kion.kionhub.mapper.PermissionMapper;
import cn.kion.kionhub.mapper.RoleMapper;
import cn.kion.kionhub.mapper.UserMapper;
import cn.kion.kionhub.response.ResultCode;
import cn.kion.kionhub.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @Author Kion
 * @Date 2020-08-24 17:05
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    RoleMapper roleMapper;
    @Autowired
    PermissionMapper permissionMapper;
    @Autowired
    LogsMapper logsMapper;
    @Override
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

    @Override
    public List<RolePermissionVO> getAllRolesPermission() {
        return roleMapper.getAllRolesPermission();
    }

    @Override
    public Boolean changeRole(Long uid, Long rid) {
        return roleMapper.setUserRole(uid,rid);
    }

    @Override
    public Boolean createRole(String roleName, String roleDescription) {
        if(StringUtils.isEmpty(roleName) || StringUtils.isEmpty(roleDescription)){
            throw new ResultException(ResultCode.PARAM_NOT_BLANK);
        }
        return roleMapper.createRole(roleName,roleDescription);
    }

    @Override
    public Boolean delRole(Long id) {
        return roleMapper.delRole(id);
    }

    @Override
    public Boolean setRolePermission(Long rid, Long pid) {
        return roleMapper.setRolePermission(rid,pid);
    }

    @Override
    public Boolean delRolePermission(Long rid, Long pid) {
        return roleMapper.delRolePermission(rid,pid);
    }

    @Override
    public Boolean createPermission(String pCode, String pName) {
        return permissionMapper.createPermission(pCode,pName);
    }

    @Override
    public Boolean delPermission(Long id) {
        return permissionMapper.delPermission(id);
    }

    @Override
    public Boolean createPath(String url, String description) {
        return permissionMapper.createPath(url,description);
    }

    @Override
    public Boolean delPath(Long id) {
        return permissionMapper.delPath(id);
    }

    @Override
    public Boolean setPathPermission(Long uid, Long pid) {
        return permissionMapper.setPathPermission(uid,pid);
    }

    @Override
    public Boolean delPathPermission(Long uid, Long pid) {
        return permissionMapper.delPathPermission(uid,pid);
    }

    @Async("asyncTask")
    @Override
    public void insertLogs(String username, String requestUrl, String params, String operationDescription) {
        logsMapper.insertLog(username,requestUrl,params,operationDescription);
    }

}
