package cn.kion.kionhub.controller.api;

import cn.kion.kionhub.entity.User;
import cn.kion.kionhub.response.JsonResult;
import cn.kion.kionhub.response.ResultTool;
import cn.kion.kionhub.service.AdminService;
import cn.kion.kionhub.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author Kion
 * @Date 2020-08-24 17:02
 */
@Slf4j
@RestController
@RequestMapping("/admin")
public class AdminApi {
    @Autowired
    AdminService adminService;

    @GetMapping("/users")
    public JsonResult<List<User>> result(){
        List<User> list = adminService.getAllUser();
        return ResultTool.success(list);
    }
}
