package org.kevin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author Kevin.Z
 * @version 2021/5/18
 */
@Component
public class RedisPipeline {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * support batch Request.
     *
     * @param prefix
     * @param key
     * @param target
     */
    public void counter(String prefix, String key, String target){
        List<Object> res = redisTemplate.executePipelined(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                String mapKey = prefix + "_mp_" + key;
                String cntKey = prefix + "_cnt_" + target;

                redisConnection.openPipeline();
                redisConnection.set("name".getBytes(StandardCharsets.UTF_8), "kevin".getBytes(StandardCharsets.UTF_8));
                redisConnection.incr(mapKey.getBytes(StandardCharsets.UTF_8));
                redisConnection.incr(cntKey.getBytes(StandardCharsets.UTF_8));
                return null;
            }
        });
        System.out.println(res);
    }
}
