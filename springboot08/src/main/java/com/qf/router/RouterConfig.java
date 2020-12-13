package com.qf.router;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouterConfig {
    @Bean
    public Queue routerQueue1(){
        return new Queue("routerQueue1");
    }

    @Bean
    public Queue routerQueue2(){
        return new Queue("routerQueue2");
    }

    @Bean
    public DirectExchange routerExchange() {
        return new DirectExchange("routerExchange");
    }

    @Bean
    public Binding bindingRouter1() {
        return BindingBuilder.bind(routerQueue1()).to(routerExchange()).with("ergou");
    }

    @Bean
    public Binding bindingRouter2() {
        return BindingBuilder.bind(routerQueue2()).to(routerExchange()).with("sangou");
    }
}
