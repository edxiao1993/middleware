package org.kevin.config;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Kevin.Z
 * @version 2021/6/16
 */
@Configuration
public class ConsumerConfiguration {

    @Autowired
    private Queue fanoutQueue;

    @Bean
    public SimpleMessageListenerContainer simpleMessageListenerContainer(
            CachingConnectionFactory connectionFactory){
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
        container.setQueues(fanoutQueue);
        container.setConcurrentConsumers(1);
        container.setMaxConcurrentConsumers(10);
        container.setPrefetchCount(5);
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL);
        container.setDefaultRequeueRejected(false);

        MessageListenerAdapter myMsgAdapter = new MessageAdapter();
        container.setMessageListener(myMsgAdapter);
        /*container.setMessageListener(new ChannelAwareMessageListener() {
            @Override
            public void onMessage(Message message, Channel channel) throws Exception {
                byte[] body = message.getBody();
                System.out.println("1  receive msg : " + new String(body));
                //不读取消息并且将当前消息抛弃掉，消息队列中删除当前消息
                //channel.basicReject(message.getMessageProperties().getDeliveryTag(), false);
                //不读取消息，消息队列中保留当前消息未被查看状态
                //channel.basicReject(message.getMessageProperties().getDeliveryTag(), true);

                //确认消息成功消费，删除消息队列中的消息
                // channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
                //确认消息成功消费，删除消息队列中的消息，他跟上面貌似一样
                channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            }
        });*/

        return container;
    }

}
