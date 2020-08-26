package cn.kion.kionhub.controller.api;

import cn.kion.kionhub.entity.User;
import cn.kion.kionhub.exception.ResultException;
import cn.kion.kionhub.response.JsonResult;
import cn.kion.kionhub.response.ResultCode;
import cn.kion.kionhub.response.ResultTool;
import cn.kion.kionhub.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * 用户相关操作
 *
 * @Author Kion
 * @Date 2020-08-23 14:40
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserApi {
    @Autowired
    UserService userService;
    /**
     * 注册用户
     *
     * @Param   user
     * @Return  cn.kion.kionhub.response.JsonResult
     *
     * @Date    2020-08-24 17:00
     */
    @PostMapping("/register")
    public JsonResult register(User user){
        //参数不为空
        if(ObjectUtils.isEmpty(user)){
            throw new ResultException(ResultCode.PARAM_NOT_VALID);
        }
        boolean flag=userService.register(user);
        if(!flag){
            return ResultTool.fail();
        }
        return ResultTool.success();
    }


}
