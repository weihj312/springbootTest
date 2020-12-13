package com.qf.work;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WorkPublisher {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(){
        System.out.println("WorkPublisher");
        rabbitTemplate.convertAndSend("","workQueue","二狗的工作生活");
    }
}
