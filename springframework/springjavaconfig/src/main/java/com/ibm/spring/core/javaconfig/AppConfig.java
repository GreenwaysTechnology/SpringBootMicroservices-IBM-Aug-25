package com.ibm.spring.core.javaconfig;

import com.ibm.spring.core.javaconfig.di.CustomerService;
import com.ibm.spring.core.javaconfig.di.OrderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

//beans.xml
//@Configuration
//public class AppConfig {
//    //beans creation
//    //<bean id="helloService" class="com.ibm.spring.core.javaconfig.HelloService"/>
//    @Bean
//    public HelloService createHello(){
//        return  new HelloService();
//    }
//    @Bean
//    public CustomerConfig customerService(){
//        return new CustomerConfig();
//    }
//    @Bean
//    public OrderService orderService(){
//        return  new OrderService();
//    }
//}

@Configuration
@Import({HelloConfig.class,OrderConfig.class, CustomerConfig.class})
public class AppConfig {}
