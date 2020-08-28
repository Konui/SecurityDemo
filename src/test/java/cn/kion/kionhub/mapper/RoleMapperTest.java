package cn.kion.kionhub.mapper;

import cn.kion.kionhub.entity.Permission;
import cn.kion.kionhub.entity.RolePermissionVO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
@SpringBootTest
class RoleMapperTest {
    @Autowired
    RoleMapper roleMapper;

    Long start;
    @BeforeEach
    public void before(){
        start=System.currentTimeMillis();
    }
    @AfterEach
    public void after(){
        System.out.println(System.currentTimeMillis()-start);
    }
    @Test
    public void getAllRolesPermissionTest(){
        List<RolePermissionVO> list = roleMapper.getAllRolesPermission();
        list.forEach(o->{
            System.out.println("Role:"+o.getRole().getRoleName()+",descript:"+o.getRole().getRoleDescription());
            List<Permission> l = o.getPermissionList();
            l.forEach(permission ->{
                System.out.println("\tPermission:"+permission.getPermissionName());
            });
        });
    }

}