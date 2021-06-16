package org.kevin.config;

import org.springframework.amqp.core.ReturnedMessage;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.connection.PooledChannelConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Kevin.Z
 * @version 2021/6/16
 */
@Configuration
public class RabbitMQConfiguration {

    @Bean
    public CachingConnectionFactory cachingConnectionFactory(){
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setHost("localhost");
        connectionFactory.setPort(5679);
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");

        connectionFactory.setPublisherConfirmType(CachingConnectionFactory.ConfirmType.CORRELATED);
        connectionFactory.setPublisherReturns(true);

        connectionFactory.setChannelCacheSize(25);

        return connectionFactory;
    }

    @Bean
    public PooledChannelConnectionFactory pooledChannelConnectionFactory(){
//        return new PooledChannelConnectionFactory();
        return null;
    }

    @Bean
    public RabbitAdmin rabbitAdmin(@Qualifier("cachingConnectionFactory") CachingConnectionFactory connectionFactory){
        return new RabbitAdmin(connectionFactory);
    }

    @Bean
    public RabbitTemplate rabbitTemplate(@Qualifier("cachingConnectionFactory") CachingConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMandatory(true);

        // to Exchange
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            @Override
            public void confirm(CorrelationData correlationData, boolean b, String s) {
                System.out.println("correlationData = " + correlationData);
                System.out.println("b = " + b);
                System.out.println("s = " + s);
            }
        });

        // to queue
        rabbitTemplate.setReturnsCallback(new RabbitTemplate.ReturnsCallback() {
            @Override
            public void returnedMessage(ReturnedMessage returnedMessage) {
                System.out.println("returnedMessage.getMessage() = " + returnedMessage.getMessage());
                System.out.println("returnedMessage.getReplyText() = " + returnedMessage.getReplyText());
                System.out.println("returnedMessage.getReplyCode() = " + returnedMessage.getReplyCode());
                System.out.println("returnedMessage.getExchange() = " + returnedMessage.getExchange());
                System.out.println("returnedMessage.getRoutingKey() = " + returnedMessage.getRoutingKey());

            }
        });

        // message converter
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        return rabbitTemplate;
    }


}
