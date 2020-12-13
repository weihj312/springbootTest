package com.qf.router;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RabbitListener(queues = "routerQueue1")
public class RouterConsumer_01 {

    @RabbitHandler
    public void receive(String content){
        System.out.println("RouterConsumer_01的repeatTradeQueue 接收时间:"+ LocalDateTime.now().toString()+" 接收内容:"+content);
    }
}

