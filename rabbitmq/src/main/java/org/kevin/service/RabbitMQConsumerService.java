package org.kevin.service;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.impl.AMQImpl;
import org.kevin.common.MyUtils;
import org.kevin.config.ExchangeAndQueue;
import org.kevin.model.Employee;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author Kevin.Z
 * @version 2021/6/16
 */
@Service
public class RabbitMQConsumerService {

//    @RabbitListener(queues = "fanout.queue")
//    public String fanoutReceiver(Employee e) {
//        if (Objects.nonNull(e)) {
//            System.out.println("e.getName() = " + e.getName());
//            return "done";
//        }
//
//        return "Damn It!";
//    }

//    @RabbitListener(queues = "fanout.queue")
//    public void fanoutReceiver2(Employee e, Channel channel, Message message) throws Exception{
//        try {
//            long sleepTime = 1000L * MyUtils.generateIntegerWithBound(5);
//            TimeUnit.SECONDS.sleep(1);
//            System.out.println("e.toString() = " + e.toString());
//            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
//        } catch (InterruptedException ie) {
//            if (message.getMessageProperties().getRedelivered()) {
//                System.out.println("already redelivered");
//                channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false);
//            }
//        }
//    }

    @RabbitListener(queues = ExchangeAndQueue.DEAD_LETTER_QUEUE)
    public void dlxReceiver(Object e, Channel channel, Message message){
        if(e instanceof Employee){
            System.out.println("((Employee)e).toString() = " + e.toString());
        } else {
            System.out.println("no dead letter exchange");
        }
    }
}
