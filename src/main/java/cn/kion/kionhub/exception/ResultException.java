package cn.kion.kionhub.exception;

import cn.kion.kionhub.response.JsonResult;
import cn.kion.kionhub.response.ResultCode;

/**
 * 返回异常
 *
 * @Author Kion
 * @Date 2020-08-23 19:03
 */
public class ResultException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    private ResultCode code;

    public ResultException(){}
    public ResultException(ResultCode code){
        this.code=code;
    }

    public ResultCode getCode() {
        return code;
    }

    public void setCode(ResultCode code) {
        this.code = code;
    }
}
