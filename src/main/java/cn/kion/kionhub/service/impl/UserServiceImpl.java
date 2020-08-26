package cn.kion.kionhub.service.impl;

import cn.kion.kionhub.entity.User;
import cn.kion.kionhub.exception.ResultException;
import cn.kion.kionhub.mapper.UserMapper;
import cn.kion.kionhub.response.ResultCode;
import cn.kion.kionhub.response.ResultTool;
import cn.kion.kionhub.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
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
    public boolean register(User user) {
        //判空
        if(StringUtils.isEmpty(user.getName()) ||
            StringUtils.isEmpty(user.getUserName()) ||
            StringUtils.isEmpty(user.getPwd())){
            throw new ResultException(ResultCode.PARAM_NOT_BLANK);
        }
        user.setPwd(bCryptPasswordEncoder.encode(user.getPwd()));
        boolean flag = userMapper.register(user.getName(),user.getUserName(),user.getPwd());
        //判断注册是否成功
        if(!flag){
            throw new ResultException(ResultCode.COMMON_UNKONW_ERROR);
        }
        return true;
    }

    @Override
    public boolean login() {
        return false;
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
}
