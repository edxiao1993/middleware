package org.kevin.redisUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Kevin.Z
 * @version 2021/7/23
 */
@Component
public class RedisSetUtil {
    @Resource(name="redisTemplate")
    private SetOperations<String, Object> setOperations;

    public void add(String key, String value){
        setOperations.add(key, value);
    }

    public Object getAll(String key){
        return setOperations.pop(key);
    }
}
