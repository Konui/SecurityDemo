package cn.kion.kionhub.service.impl;

import cn.kion.kionhub.entity.PathPermissionDO;
import cn.kion.kionhub.entity.Permission;
import cn.kion.kionhub.exception.ResultException;
import cn.kion.kionhub.mapper.PermissionMapper;
import cn.kion.kionhub.response.ResultCode;
import cn.kion.kionhub.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @Author Kion
 * @Date 2020-08-26 19:26
 */
@Service
public class PermissionImpl implements PermissionService {
    @Autowired
    PermissionMapper permissionMapper;


    @Override
    public List<Permission> selectListByUser(String name) {
        if(StringUtils.isEmpty(name)){
            throw new ResultException(ResultCode.PARAM_NOT_BLANK);
        }
        return permissionMapper.selectListByUser(name);
    }

    @Override
    public List<Permission> selectListByPath(String url) {
        if(StringUtils.isEmpty(url)){
            throw new ResultException(ResultCode.PARAM_NOT_BLANK);
        }
        return permissionMapper.selectListByPath(url);
    }

    @Override
    public List<PathPermissionDO> selectAll() {
        return permissionMapper.selectAll();
    }
}
