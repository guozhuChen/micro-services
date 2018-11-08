package com.upin.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @Created by Leslie on 2018/7/18.
 */
@Component
public class ValidateCodeManagerImpl implements ValidateCodeManager {
    private static final String VALIDATION_CODE = "validationCode:";

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public String createValidation(String identity, String code, long timeoutMin) {
        redisTemplate.opsForValue().set(VALIDATION_CODE + identity, code, timeoutMin, TimeUnit.MINUTES);
        return code ;
    }

    @Override
    public String getCode(String identity) {
        return redisTemplate.opsForValue().get(VALIDATION_CODE + identity);
    }
}
