package com.ibm.spring.core.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.ibm.spring")
public class AppConfig {

//    @Bean
//    public HelloService helloService(){
//        return  new HelloService();
//    }

}
