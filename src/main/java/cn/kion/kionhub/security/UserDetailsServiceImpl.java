package cn.kion.kionhub.security;

import cn.kion.kionhub.entity.Permission;
import cn.kion.kionhub.entity.User;
import cn.kion.kionhub.exception.ResultException;
import cn.kion.kionhub.response.ResultCode;
import cn.kion.kionhub.response.ResultTool;
import cn.kion.kionhub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户登录认证逻辑
 *
 * @Author Kion
 * @Date 2020-08-25 16:37
 */

public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserService userService;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        if(StringUtils.isEmpty(s)){
            throw new ResultException(ResultCode.PARAM_NOT_BLANK);
        }
        User user = userService.getUserByName(s);
        if(user == null ){
            throw new ResultException(ResultCode.USER_ACCOUNT_NOT_EXIST);
        }
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        List<Permission> permissionList;
        return null;
    }


}
