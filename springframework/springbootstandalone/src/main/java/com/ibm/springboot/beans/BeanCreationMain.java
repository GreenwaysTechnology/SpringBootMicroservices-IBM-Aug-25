package com.ibm.springboot.beans;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BeanCreationMain {
    public static void main(String[] args) {
        ConfigurableApplicationContext context= SpringApplication.run(BeanCreationMain.class);
        HelloService helloService = context.getBean(HelloService.class);
        System.out.println(helloService.sayHello());

    }
}
