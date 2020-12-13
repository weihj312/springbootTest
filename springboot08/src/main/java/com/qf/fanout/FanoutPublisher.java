package com.qf.fanout;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FanoutPublisher {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(){
        System.out.println("FanoutPublisher");
        rabbitTemplate.convertAndSend("fanoutExchange","","二狗的发布与订阅生活");
    }
}
