package com.ibm.spring.core.javaconfig;

import com.ibm.spring.core.javaconfig.di.OrderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
public class OrderConfig {

    @Bean
    public OrderService orderService(){
        return  new OrderService();
    }
}
