package com.shuma.redismanager;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class SessionManager {
    @Autowired
    private RedisTemplate redisTemplate;




    /**
     * 获取redis值
     * @param key
     * @return
     */
    public Object getRedisValue(String key) {
        return redisTemplate.opsForValue().get(key);
    }



}
