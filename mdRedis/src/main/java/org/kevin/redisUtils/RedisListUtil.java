package org.kevin.redisUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Kevin.Z
 * @version 2021/7/23
 */
@Component
public class RedisListUtil {

    @Resource(name = "redisTemplate")
    private ListOperations<String, Object> listOperations;

    public void addLink(String userId, Object o) {
        listOperations.leftPush(userId, o);
    }

    public Object popRight(String userId){
        return listOperations.rightPop(userId);
    }
}
