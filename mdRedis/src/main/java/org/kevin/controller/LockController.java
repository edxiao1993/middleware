package org.kevin.controller;

import org.kevin.config.RedisBasicLock;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author Kevin.Z
 * @version 2021/5/27
 */
@RestController
public class LockController {

    @Autowired
    private RedisBasicLock redisBasicLock;

    @GetMapping("/lockRedis")
    public String lockRedis(){
        String productId = "0322";
        int quantity = 29;
        String key = "try_redis_lock_" + productId;
        long time = System.currentTimeMillis();
        try{
            if(!redisBasicLock.tryLock(key, String.valueOf(time))){
                return "-1";
            }
            //TODO: operate this product...
            return "1";
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            redisBasicLock.unlock(key, String.valueOf(time));
        }
        return "-1";
    }

    @Autowired
    private RedissonClient redissonClient;

    @GetMapping("/redissonLockRedis")
    public String redissonLockRedis(){
        String productId = "0322";
        RLock lock = redissonClient.getLock("productId::" + productId);
        try{
            // try to lock this product
            lock.tryLock(60, 20, TimeUnit.SECONDS);
            // TODO: operate this product
            return "1";
        } catch (InterruptedException e){
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return "-1";
    }
}
