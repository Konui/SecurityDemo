package cn.kion.kionhub.response;

/**
 * 统一返回码
 *
 * @Author Kion
 * @Date 2020-08-23 14:51
 */
public enum ResultCode {

    //通用返回
    COMMON_SUCCESS(200,"成功"),
    COMMON_FAIL(100,"失败"),
    COMMON_UNKONW_ERROR(101,"未知错误,请联系管理员处理"),
    //参数错误
    PARAM_NOT_VALID(1001,"参数无效"),
    PARAM_NOT_BLANK(1002,"参数不能为空"),
    PARAM_TYPE_ERROR(1003,"参数类型错误"),
    PARAM_NOT_COMPLETE(1004,"参数缺失"),

    //用户错误
    USER_NOT_LOGIN(2001,"用户未登录"),
    USER_ACCOUNT_EXPIRED(2002, "账号已过期"),
    USER_CREDENTIALS_ERROR(2003, "密码错误"),
    USER_ACCOUNT_DISABLE(2004, "账号不可用"),
    USER_ACCOUNT_LOCKED(2005, "账号被锁定"),
    USER_ACCOUNT_NOT_EXIST(2006, "账号不存在"),
    USER_ACCOUNT_USE_BY_OTHERS(2007, "账号下线"),

    //业务错误
    NO_PERMISSION(3001, "没有权限"),
    NO_MAPPING_URL(3002,"请求地址错误");
    private Integer code;
    private String msg;
    ResultCode(Integer code , String msg){
        this.code=code;
        this.msg=msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
