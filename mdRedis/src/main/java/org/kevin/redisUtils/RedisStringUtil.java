package org.kevin.redisUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Kevin.Z
 * @version 2021/7/23
 */
@Component
public class RedisStringUtil {

    @Autowired
    private RedisTemplate<String, Object> stringObjectRedisTemplate;
    @Resource(name="redisTemplate")
    private ValueOperations<String, Object> valueOperations;

    public void add(String key, Object value){
        valueOperations.set(key, value);
    }

    public void setBitMap(String key, long offset){
        valueOperations.setBit(key, offset, true);
    }
}
