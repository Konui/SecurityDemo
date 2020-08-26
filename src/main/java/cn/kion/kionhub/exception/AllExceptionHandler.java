package cn.kion.kionhub.exception;

import cn.kion.kionhub.response.JsonResult;
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
    @ExceptionHandler(ResultException.class)
    @ResponseBody
    public JsonResult handler(ResultException e){
        return ResultTool.fail(e.getCode());
    }
}
