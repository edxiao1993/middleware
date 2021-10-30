package org.kevin.initialization;

import org.kevin.redisUtils.RedisListUtil;
import org.kevin.redisUtils.RedisSetUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author Kevin.Z
 * @version 2021/7/23
 */
@Component
public class InitializeResource implements CommandLineRunner {
    @Autowired
    private RedisListUtil redisList;
    @Autowired
    private RedisSetUtil redisSet;

    @Override
    public void run(String... args) throws Exception {
        redisList.addLink("userId", "name" + Math.random());

        System.out.println(redisList.popRight("userId"));

        redisSet.add("myName", "Kevin");
        redisSet.add("myName", "Zeng");
        System.out.println(redisSet.getAll("myName"));
    }
}
