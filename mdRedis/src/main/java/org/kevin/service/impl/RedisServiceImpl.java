package org.kevin.service.impl;

import org.kevin.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author Kevin.Z
 * @version 2021/5/17
 *
 * opsForValue: https://docs.spring.io/spring-data/redis/docs/2.5.0/api/
 */
@Service
public class RedisServiceImpl implements RedisService {
    private static final double DEFAULT_SCORE = 13.0;

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

    public void addZSet(String key, String value){
        redisTemplate.opsForZSet().add(key, value, DEFAULT_SCORE);
    }

    public Double score(String key, String value){
        return redisTemplate.opsForZSet().score(key, value);
    }

    public void expireKey(String key, long duration){
        redisTemplate.expire(key, duration, TimeUnit.SECONDS);
    }
}
