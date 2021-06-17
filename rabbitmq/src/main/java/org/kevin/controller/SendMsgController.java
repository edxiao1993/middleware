package org.kevin.controller;

import org.kevin.common.MyUtils;
import org.kevin.config.ExchangeAndQueue;
import org.kevin.model.Employee;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Kevin.Z
 * @version 2021/6/17
 */
@RestController
public class SendMsgController {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/send")
    public String send() {
        Employee e = Employee.builder()
                .name("KevinZeng: " + MyUtils.generateName())
                .company("GlobalSources")
                .books(List.of("the Golden Age", "When you are old"))
                .build();
        rabbitTemplate.convertAndSend(ExchangeAndQueue.FANOUT_EXCHANGE_NAME,"", e);
        return "hello world";
    }
}
