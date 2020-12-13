package com.qf.topic;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicPublisher {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(){
        System.out.println("TopicPublisher");
        rabbitTemplate.convertAndSend("topicExchange","ergou.rr","二狗的zhuti生活");
        rabbitTemplate.convertAndSend("topicExchange","sangou.hghg.erds","三狗的zhuti生活");
    }
}
