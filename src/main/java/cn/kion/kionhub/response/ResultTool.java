package cn.kion.kionhub.response;

/**
 * 返回实体生成工具类
 *
 * @Author Kion
 * @Date 2020-08-23 14:51
 */
public class ResultTool {
    public static JsonResult success() {
        return new JsonResult(true);
    }

    public static <T> JsonResult<T> success(T data) {
        return new JsonResult(true, data);
    }

    public static JsonResult fail() {
        return new JsonResult(false);
    }

    public static JsonResult fail(ResultCode resultEnum) {
        return new JsonResult(false, resultEnum);
    }

    public static JsonResult fail(String msg){
        return new JsonResult(false ,msg);
    }

}
