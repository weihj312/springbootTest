package com.qf.work;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WorkConfig {
    @Bean
    public Queue workQueue(){
        return new Queue("workQueue");
    }
}
