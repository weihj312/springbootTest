package com.qf.router;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RouterPublisher {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(){
        System.out.println("RouterPublisher");
        rabbitTemplate.convertAndSend("routerExchange","ergou","二狗的路由生活");
        rabbitTemplate.convertAndSend("routerExchange","sangou","三狗的路由生活");
    }
}
