package org.kevin.config;

import io.netty.util.internal.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.time.Duration;

/**
 * the easy way to implement the CAP
 *
 * @author Kevin.Z
 * @version 2021/5/26
 */
@Component
public class RedisLock {
    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * try to lock the redis.
     *  add the Expired time, make sure the dead-lock never happen.
     * @param key
     * @param value
     * @return
     */
    public Boolean tryLock(String key, String value){
        Duration d = Duration.ofSeconds(60);
        if(redisTemplate.opsForValue().setIfAbsent(key, value, d)){
            return true;
        }
        String currentValue = redisTemplate.opsForValue().get(key);
        if(!StringUtil.isNullOrEmpty(currentValue) && Long.valueOf(currentValue) < System.currentTimeMillis()){
            // make sure the current value is same
            String oldValue = redisTemplate.opsForValue().get(key);
            redisTemplate.opsForValue().set(key, value, d);
            if(StringUtils.hasLength(oldValue) && oldValue.equals(currentValue)){
                return true;
            }
        }
        return false;
    }

    public void unlock(String key, String value){
        String currentValue = redisTemplate.opsForValue().get(key);
        if(StringUtils.hasLength(currentValue) && currentValue.equals(value)){
            redisTemplate.opsForValue().getOperations().delete(key);
        }
    }
}
