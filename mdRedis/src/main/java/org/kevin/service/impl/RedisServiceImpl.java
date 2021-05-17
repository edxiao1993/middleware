package org.kevin.service.impl;

import org.kevin.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author Kevin.Z
 * @version 2021/5/17
 *
 * opsForValue: https://docs.spring.io/spring-data/redis/docs/2.5.0/api/
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

    public void bitMap(String key, int index){
        redisTemplate.opsForValue().setBit(key, index, true);
    }

    public void increment(String key){
        redisTemplate.opsForValue().increment(key, 1);
    }
}
