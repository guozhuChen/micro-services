package com.upin.redis;

import com.alibaba.fastjson.JSON;
import com.upin.session.SessionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @Created by Leslie on 2018/7/30.
 */
@Component
public class SesssionManagerImpl implements SesssionManager {
    private static final String TOKEN = "token:";
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public void buildSession(String token, SessionDTO session, Long timeoutHours) {
        String jsonSession = JSON.toJSONString(session);
        if (timeoutHours.equals(0)){
            redisTemplate.opsForValue().set(TOKEN+token, jsonSession);
        }else{
            redisTemplate.opsForValue().set(TOKEN+token, jsonSession, timeoutHours.longValue(), TimeUnit.HOURS);
        }
    }

    @Override
    public SessionDTO getSession(String token) throws Exception {
        String jsonSession = redisTemplate.opsForValue().get(TOKEN + token);
        if (jsonSession == null){
            throw new Exception("当前token暂无session");
        }
        SessionDTO session = JSON.parseObject(jsonSession, SessionDTO.class);
        return session;
    }
}
