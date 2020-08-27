package cn.kion.kionhub.exception;

import cn.kion.kionhub.response.JsonResult;
import cn.kion.kionhub.response.ResultCode;
import cn.kion.kionhub.response.ResultTool;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理
 *
 * @Author Kion
 * @Date 2020-08-23 19:00
 */
@Slf4j
@ControllerAdvice
public class AllExceptionHandler {
    static final String noMapping="No handler found for";

    @ExceptionHandler(ResultException.class)
    @ResponseBody
    public JsonResult handler(ResultException e){
        return ResultTool.fail(e.getCode());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public JsonResult GobalHandler(Exception e){
        JsonResult result;
        e.printStackTrace();
        if(e.getMessage().contains(noMapping)){
            result = ResultTool.fail(ResultCode.NO_MAPPING_URL);
        }else {
            result = ResultTool.fail(ResultCode.COMMON_UNKONW_ERROR);
        }
        return result;
    }
}
