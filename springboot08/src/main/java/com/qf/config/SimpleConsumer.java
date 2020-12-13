package com.qf.config;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RabbitListener(queues = "simpleQueue")
public class SimpleConsumer {

    @RabbitHandler
    public void receive(String content){

        System.out.println("SimpleConsumer");
        System.out.println("repeatTradeQueue 接收时间:"+ LocalDateTime.now().toString()+" 接收内容:"+content);
    }
}

