package com.ibm.spring.core.javaconfig;

import com.ibm.spring.core.javaconfig.di.CustomerService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerConfig {

    @Bean
    public CustomerService customerService(){
        return  new CustomerService();
    }
}
