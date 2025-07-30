package com.ibm.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class HelloWorldSpringBoot {
    public static void main(String[] args) {
        //Application Context
    ConfigurableApplicationContext context= SpringApplication.run(HelloWorldSpringBoot.class);
    }
}
