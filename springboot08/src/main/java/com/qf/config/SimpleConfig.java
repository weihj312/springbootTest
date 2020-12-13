package com.qf.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SimpleConfig {

    @Bean
    public Queue simpleQueue(){
        return new Queue("simpleQueue");
    }

    //用于延时消费的队列
//    @Bean
//    public Queue repeatTradeQueue() {
//        Queue queue = new Queue("simpleQueue",false,false,false);
//        return queue;
//    }
}
