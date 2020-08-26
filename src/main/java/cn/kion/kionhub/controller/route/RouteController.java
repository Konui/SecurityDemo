package cn.kion.kionhub.controller.route;

import cn.kion.kionhub.response.JsonResult;
import cn.kion.kionhub.response.ResultTool;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 路由控制器
 *
 * @Author Kion
 * @Date 2020-08-22 19:55
 */
@Slf4j
@RestController
public class RouteController {
    /**
     * 测试连接
     *
     * @Param
     * @Return  java.lang.String
     *
     * @Date    2020-08-23 11:23
     */
    @RequestMapping("/")
    public JsonResult<String> test(){
        return ResultTool.success();
    }
}
