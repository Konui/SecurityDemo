package cn.kion.kionhub.service.impl;

import cn.kion.kionhub.entity.RolePermissionVO;
import cn.kion.kionhub.entity.User;
import cn.kion.kionhub.exception.ResultException;
import cn.kion.kionhub.mapper.RoleMapper;
import cn.kion.kionhub.mapper.UserMapper;
import cn.kion.kionhub.response.ResultCode;
import cn.kion.kionhub.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
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

}
