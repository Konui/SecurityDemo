package cn.kion.kionhub.service.impl;

import cn.kion.kionhub.entity.User;
import cn.kion.kionhub.mapper.UserMapper;
import cn.kion.kionhub.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Kion
 * @Date 2020-08-24 17:05
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }
}
