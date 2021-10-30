package org.kevin.redisUtils;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Kevin.Z
 * @version 2021/7/23
 */
@Component
public class RedisHashUtil {
    @Resource(name="redisTemplate")
    private HashOperations<String, String, Object> hashOperations;

    public void add(String name, String key, String value){
        hashOperations.put(name, key, value);
    }
}
