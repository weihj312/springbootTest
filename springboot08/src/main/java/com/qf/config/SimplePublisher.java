package com.qf.config;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SimplePublisher {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(){
        System.out.println("SimplePublisher");
        rabbitTemplate.convertAndSend("","simpleQueue","二狗的幸福生活");
    }
}
