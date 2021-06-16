package org.kevin.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Kevin.Z
 * @version 2021/6/16
 */
@Configuration
public class ExchangeAndQueue {
    private static final String FANOUT_EXCHANGE_NAME = "fanout.exchange.name";
    private static final String TOPIC_EXCHANGE_NAME = "topic.exchange.name";
    private static final String DIRECT_EXCHANGE_NAME = "direct.exchange.name";

    private static final String FANOUT_QUEUE_NAME = "fanout";
    private static final String TOPIC_QUEUE_NAME = "topic";
    private static final String TOPIC_QUEUE_ROUTING_KEY = "topic.*";
    private static final String DIRECT_QUEUE_NAME = "direct";

    private static final String DEAD_LETTER_EXCHANGE = "dead.letter.exchange";
    private static final String DEAD_LETTER_ROUTING_KEY = "dead.letter.routing.key";

    Map<String, Object> BASIC_ARGUMENTS = new HashMap<>() {{
        put("x-dead-letter-exchange", DEAD_LETTER_EXCHANGE);
        put("x-dead-letter-routing-key", DEAD_LETTER_ROUTING_KEY);
        put("x-message-ttl", "60 * 1000");
    }};

    @Bean
    public Exchange deadLeadExchange(){
        return new DirectExchange(DEAD_LETTER_EXCHANGE, false, true);
    }

    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange(FANOUT_EXCHANGE_NAME, false, false, BASIC_ARGUMENTS);
    }

    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange(TOPIC_EXCHANGE_NAME, false, true, BASIC_ARGUMENTS);
    }
    @Bean
    public Queue topicQueue(){
        return new Queue(TOPIC_QUEUE_NAME, false, true, true, BASIC_ARGUMENTS);
    }

    @Bean
    public Queue fanoutQueue(){
        return new Queue(FANOUT_QUEUE_NAME, false, true, true, BASIC_ARGUMENTS);
    }

    @Bean
    public Binding binding(FanoutExchange fanoutExchange, Queue fanoutQueue){
        return BindingBuilder.bind(fanoutQueue).to(fanoutExchange);
    }

    @Bean
    public Binding bindTopic(TopicExchange topicExchange, Queue topicQueue){
        return BindingBuilder.bind(topicQueue).to(topicExchange).with(TOPIC_QUEUE_ROUTING_KEY);
    }
}
