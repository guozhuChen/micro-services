package com.upin.redis;

/**
 * @Created by Leslie on 2018/7/18.
 */
public interface ValidateCodeManager {

    String createValidation(String identity, String code, long timeoutMin) ;

    String getCode(String identity) ;

}
