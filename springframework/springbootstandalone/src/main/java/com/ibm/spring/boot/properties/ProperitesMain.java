package com.ibm.spring.boot.properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ProperitesMain {
    public static void main(String[] args) {
        ConfigurableApplicationContext context=SpringApplication.run(ProperitesMain.class);
        GreeterService greeterService = context.getBean(GreeterService.class);
//        System.out.println(greeterService.sayHello());
        System.out.println(greeterService.sayGreet());


    }
}
