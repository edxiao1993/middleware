package org.kevin.service.impl;

import org.kevin.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author Kevin.Z
 * @version 2021/5/17
 */
@Service
public class RedisServiceImpl implements RedisService {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public boolean addHyperloglog(String key, Object obj){
        return redisTemplate.opsForHyperLogLog().add(key, obj) > 0;
    }

    public long hyperCount(String key){
        return redisTemplate.opsForHyperLogLog().size(key);
    }
}
