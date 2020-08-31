package cn.kion.kionhub.security;

import cn.kion.kionhub.entity.PathPermissionDO;
import cn.kion.kionhub.entity.Permission;
import cn.kion.kionhub.service.PermissionService;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * 路径权限认证
 * @Author Kion
 * @Date 2020-08-27 18:06
 */
@Component
public class CustomizeFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {


    AntPathMatcher antPathMatcher = new AntPathMatcher();
    @Autowired
    PermissionService permissionService;
    public static Cache<String , Object> cache = CacheBuilder.newBuilder().weakValues().recordStats().build();

    {
        cache.put("isExpired",true);
    }
    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        //获取请求地址
        String requestUrl = ((FilterInvocation) o).getRequestUrl();
        //查询具体某个接口的权限
        //List<Permission> permissionList =  permissionService.selectListByPath(requestUrl);
        //获取全部地址的权限
        //判断缓存是否失效，失效重新读取
        if((boolean)cache.getIfPresent("isExpired")){
            List<PathPermissionDO> pathPermissionDOList =  permissionService.selectAll();
            cache.put("pathPermissionDOList",pathPermissionDOList);
            cache.put("isExpired",false);
        }
        List<PathPermissionDO> pathPermissionDOList = (List<PathPermissionDO>)cache.getIfPresent("pathPermissionDOList");
//        if(permissionList == null || permissionList.size() == 0){
//            //###应该拒绝访问
//            //请求路径没有配置权限，表明该请求接口可以任意访问
//            return SecurityConfig.createList();
//        }
//        String[] attributes = new String[permissionList.size()];
//        for(int i = 0;i<permissionList.size();i++){
//            attributes[i] = permissionList.get(i).getPermissionCode();
//        }

        for(PathPermissionDO pathPermissionDO:pathPermissionDOList){
            if(antPathMatcher.match(pathPermissionDO.getUrl(),requestUrl)){
                String[] attributes = new String[pathPermissionDO.getPermissionList().size()];
                for (int i = 0; i < attributes.length; i++) {
                    attributes[i]=pathPermissionDO.getPermissionList().get(i).getPermissionCode();
                }
                return SecurityConfig.createList(attributes);
            }
        }
        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
