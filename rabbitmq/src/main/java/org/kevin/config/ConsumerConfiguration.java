package org.kevin.config;

import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Kevin.Z
 * @version 2021/6/16
 */
@Configuration
public class ConsumerConfiguration {

    @Bean
    public SimpleMessageListenerContainer simpleMessageListenerContainer(
            @Qualifier("cachingConnectionFactory") CachingConnectionFactory connectionFactory){
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
        container.setConcurrentConsumers(1);
        container.setMaxConcurrentConsumers(10);
        container.setPrefetchCount(10);
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL);

        return container;
    }
}
