package org.kevin.redisUtils;

import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Kevin.Z
 * @version 2021/7/23
 */
@Component
public class RedisZSetUtil {
    @Resource(name="redisTemplate")
    private ZSetOperations<String, Object> setOperations;

    public void add(String key, String value, double score){
        setOperations.add(key, value, score);
    }
}
