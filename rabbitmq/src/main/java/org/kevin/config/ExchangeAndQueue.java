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
    public static final String FANOUT_EXCHANGE_NAME = "fanout.exchange.name";
    private static final String TOPIC_EXCHANGE_NAME = "topic.exchange.name";
    private static final String DIRECT_EXCHANGE_NAME = "direct.exchange.name";

    public static final String FANOUT_QUEUE_NAME = "fanout.queue";
    private static final String TOPIC_QUEUE_NAME = "topic.queue";
    private static final String TOPIC_QUEUE_ROUTING_KEY = "topic.*";
    private static final String DIRECT_QUEUE_NAME = "direct.queue";

    Map<String, Object> DEAD_LETTER_ARGUMENTS = new HashMap<>() {{
        put("x-dead-letter-exchange", DEAD_LETTER_EXCHANGE);
        put("x-dead-letter-routing-key", DEAD_LETTER_ROUTING_KEY);
        put("x-message-ttl", 2500);
    }};
    Map<String, Object> MAX_LENGTH_ARGUMENT = new HashMap<>(){{
        put("x-max-length", 3); // the maximum of this queue is 3 messages
    }};


    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange(FANOUT_EXCHANGE_NAME, false, true);
    }
    @Bean
    public Queue fanoutQueue(){
        Map<String, Object> specificArguments = new HashMap<>(DEAD_LETTER_ARGUMENTS);
        specificArguments.putAll(MAX_LENGTH_ARGUMENT);
        return new Queue(FANOUT_QUEUE_NAME, false, true, true, specificArguments);
    }

    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange(TOPIC_EXCHANGE_NAME, false, true);
    }
    @Bean
    public Queue topicQueue(){
        return new Queue(TOPIC_QUEUE_NAME, false, true, true, DEAD_LETTER_ARGUMENTS);
    }

    @Bean
    public Binding bindFanout(FanoutExchange fanoutExchange, Queue fanoutQueue){
        return BindingBuilder.bind(fanoutQueue).to(fanoutExchange);
    }

    @Bean
    public Binding bindTopic(TopicExchange topicExchange, Queue topicQueue){
        return BindingBuilder.bind(topicQueue).to(topicExchange).with(TOPIC_QUEUE_ROUTING_KEY);
    }

    /** *********************************************** */
    private static final String DEAD_LETTER_EXCHANGE = "dead.letter.exchange";
    public static final String DEAD_LETTER_QUEUE = "dead.letter.queue";
    private static final String DEAD_LETTER_ROUTING_KEY = "dead.letter.routing.key";

    /**
     * there are three reason for a Message is put into DeadLetter:
     *  rejected
     *  expired
     *  maxlen
     * @return
     */
    @Bean
    public DirectExchange deadLetterExchange(){
        return new DirectExchange(DEAD_LETTER_EXCHANGE, false, true);
    }
    @Bean
    public Queue deadLetterQueue(){
        return new Queue(DEAD_LETTER_QUEUE, false, true, true);
    }

    @Bean
    public Binding bindingDeadLetter(DirectExchange deadLetterExchange, Queue deadLetterQueue){
        return BindingBuilder.bind(deadLetterQueue).to(deadLetterExchange).with(DEAD_LETTER_ROUTING_KEY);
    }

}
