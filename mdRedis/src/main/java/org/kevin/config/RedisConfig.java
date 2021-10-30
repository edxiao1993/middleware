package org.kevin.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

/**
 * @author Kevin.Z
 * @version 2021/5/16
 */
@Configuration
public class RedisConfig {

    @Bean
    @Primary
    RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory){
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);

        Jackson2JsonRedisSerializer<Object> fastJsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
        template.setValueSerializer(fastJsonRedisSerializer);
        template.setHashValueSerializer(fastJsonRedisSerializer);
        template.setKeySerializer(fastJsonRedisSerializer);
        template.setHashKeySerializer(fastJsonRedisSerializer);

        return template;
    }

    @Bean
    public RedissonClient redissonClient(){
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379").setPassword("myRedis");
        RedissonClient client = Redisson.create(config);
        return client;
    }
}
