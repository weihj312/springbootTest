package com.qf.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RabbitListener(queues = "topicQueue2")
public class TopicConsumer_02 {

    @RabbitHandler
    public void receive(String content){
        System.out.println("TopicConsumer_02的repeatTradeQueue 接收时间:"+ LocalDateTime.now().toString()+" 接收内容:"+content);
    }
}

