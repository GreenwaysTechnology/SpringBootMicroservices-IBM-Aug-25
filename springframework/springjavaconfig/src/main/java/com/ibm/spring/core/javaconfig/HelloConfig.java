package com.ibm.spring.core.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloConfig {
    @Bean
    public  HelloService helloService(){
        return  new HelloService();
    }
}
