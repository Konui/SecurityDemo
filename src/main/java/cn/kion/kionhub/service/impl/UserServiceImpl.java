package cn.kion.kionhub.service.impl;

import cn.kion.kionhub.entity.User;
import cn.kion.kionhub.exception.ResultException;
import cn.kion.kionhub.mapper.RoleMapper;
import cn.kion.kionhub.mapper.UserMapper;
import cn.kion.kionhub.response.ResultCode;
import cn.kion.kionhub.response.ResultTool;
import cn.kion.kionhub.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

/**
 * @Author Kion
 * @Date 2020-08-23 18:50
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    UserMapper userMapper;

    @Override
    @Transactional
    public boolean register(User user) {
        //判空
        if(StringUtils.isEmpty(user.getName()) ||
            StringUtils.isEmpty(user.getUserName()) ||
            StringUtils.isEmpty(user.getPwd())){
            throw new ResultException(ResultCode.PARAM_NOT_BLANK);
        }
        //判断用户名或昵称是否存在
        if(userMapper.isExistByName(user.getName())&&userMapper.isExistByUserName(user.getUserName())){
            throw new ResultException(ResultCode.USER_NAME_OR_USERNAME_EXIST);
        }
        //注册用户
        user.setPwd(bCryptPasswordEncoder.encode(user.getPwd()));
        boolean flag = userMapper.register(user.getName(),user.getUserName(),user.getPwd());
        //更新角色信息，默认普通用户
        flag=userMapper.registerUserRole(user.getName());
        //判断注册是否成功
        if(!flag){
            throw new ResultException(ResultCode.COMMON_UNKONW_ERROR);
        }
        return true;
    }

    @Override
    public boolean setMail(User user) {
        return false;
    }

    @Override
    public boolean setHeadImg(User user) {
        return false;
    }

    @Override
    public boolean setPwd(User user) {
        return false;
    }

    @Override
    public boolean userExist(String name) {
        return false;
    }

    @Override
    public boolean usernameExist(String username) {
        return false;
    }

    @Override
    public boolean mailExist(String mail) {
        return false;
    }

    @Override
    public User getUserByName(String name) {
        if(StringUtils.isEmpty(name)){
            throw new ResultException(ResultCode.PARAM_NOT_BLANK);
        }
        User u=userMapper.selectUserByName(name);
        if(u==null){
            throw new ResultException(ResultCode.USER_ACCOUNT_NOT_EXIST);
        }
        return u;
    }

    @Override
    public boolean setUserName(Long id,String username) {
        if(StringUtils.isEmpty(username)){
            throw new ResultException(ResultCode.PARAM_NOT_BLANK);
        }
        if(userMapper.isExistByUserName(username)){
            throw new ResultException(ResultCode.USER_NAME_OR_USERNAME_EXIST);
        }
        boolean flag = userMapper.setUserName(id,username);
        if(!flag){
            throw new ResultException(ResultCode.COMMON_UNKONW_ERROR);
        }
        return true;
    }
}
