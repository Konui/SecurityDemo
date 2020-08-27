package cn.kion.kionhub.security;

import cn.kion.kionhub.entity.Permission;
import cn.kion.kionhub.entity.User;
import cn.kion.kionhub.exception.ResultException;
import cn.kion.kionhub.response.ResultCode;
import cn.kion.kionhub.response.ResultTool;
import cn.kion.kionhub.service.PermissionService;
import cn.kion.kionhub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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
    @Autowired
    PermissionService permissionService;
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
        List<Permission> permissionList=permissionService.selectListByUser(s);
        permissionList.forEach(permission -> {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permission.getPermissionCode());
            grantedAuthorities.add(grantedAuthority);
        });
        return new org.springframework.security.core.userdetails.User(
                user.getName(),
                user.getPwd(),
                user.getStatus()==1?true:false,
                false,
                false,
                false,
                grantedAuthorities
        );
    }


}
