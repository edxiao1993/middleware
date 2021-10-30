package org.kevin.config;

import com.rabbitmq.client.Channel;
import org.kevin.common.MyUtils;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;

import java.util.concurrent.TimeUnit;

/**
 * @author Kevin.Z
 * @version 2021/6/17
 */
public class MessageAdapter extends MessageListenerAdapter {
    public void onMessage(Message message, Channel channel) throws Exception {
        byte[] bs = message.getBody();

        long sleepTime = 1000L * MyUtils.generateIntegerWithBound(5);
        TimeUnit.SECONDS.sleep(1);
        if(MyUtils.generateIntegerWithBound(10) < 5) {
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            System.out.println("e.toString() = " + new String(bs));
        } else {
            System.out.println("damt it~");
            channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
        }
        /*if (message.getMessageProperties().getRedelivered()) {
            System.out.println("already redelivered");
            channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false);
        }*/

    }
}
