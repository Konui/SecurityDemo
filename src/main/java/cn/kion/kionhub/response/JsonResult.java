package cn.kion.kionhub.response;

import java.io.Serializable;

/**
 * 统一返回实体
 *
 * @Author Kion
 * @Date 2020-08-23 14:50
 */
public class JsonResult<T> implements Serializable {
    private Boolean success;
    private Integer statusCode;
    private String msg;
    private T data;

    public JsonResult(){}

    public JsonResult(boolean success){
        this.success=success;
        this.statusCode = success ? ResultCode.COMMON_SUCCESS.getCode() : ResultCode.COMMON_FAIL.getCode();
        this.msg = success ? ResultCode.COMMON_SUCCESS.getMsg() : ResultCode.COMMON_FAIL.getMsg();
    }

    public JsonResult(boolean success, ResultCode resultEnum) {
        this.success = success;
        this.statusCode = success ? ResultCode.COMMON_SUCCESS.getCode() : (resultEnum == null ? ResultCode.COMMON_FAIL.getCode() : resultEnum.getCode());
        this.msg = success ? ResultCode.COMMON_SUCCESS.getMsg() : (resultEnum == null ? ResultCode.COMMON_FAIL.getMsg() : resultEnum.getMsg());
    }

    public JsonResult(boolean success, T data) {
        this.success = success;
        this.statusCode = success ? ResultCode.COMMON_SUCCESS.getCode() : ResultCode.COMMON_FAIL.getCode();
        this.msg = success ? ResultCode.COMMON_SUCCESS.getMsg() : ResultCode.COMMON_FAIL.getMsg();
        this.data = data;
    }

    public JsonResult(boolean success, ResultCode resultEnum, T data) {
        this.success = success;
        this.statusCode = success ? ResultCode.COMMON_SUCCESS.getCode() : (resultEnum == null ? ResultCode.COMMON_FAIL.getCode() : resultEnum.getCode());
        this.msg = success ? ResultCode.COMMON_SUCCESS.getMsg() : (resultEnum == null ? ResultCode.COMMON_FAIL.getMsg() : resultEnum.getMsg());
        this.data = data;
    }

    public JsonResult(boolean success ,String msg){
        this.success=success;
        this.statusCode=success?ResultCode.COMMON_SUCCESS.getCode():ResultCode.COMMON_FAIL.getCode();
        this.msg=msg;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
