package org.kevin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author Kevin.Z
 * @version 2021/5/16
 */
@RestController
public class DefaultController {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @GetMapping({"/", "index"})
    public String index(){
        redisTemplate.opsForValue().set("name", "Kevin Zeng", 5, TimeUnit.SECONDS);
        return "hello world";
    }

    @GetMapping("get")
    public String name(){
        return (String) redisTemplate.opsForValue().get("name");
    }
}
