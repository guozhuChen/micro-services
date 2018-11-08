package com.upin.exception;

/**
 * @Created by Leslie on 2018/8/1.
 */
public class BaseException extends RuntimeException {
    private Integer code = null;

    public BaseException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public BaseException(String message) {
        super(message);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
