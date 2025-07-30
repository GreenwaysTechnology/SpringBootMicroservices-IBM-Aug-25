package com.ibm.springboot.di;

import com.ibm.springboot.HelloWorldSpringBoot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DependencyMain {
    public static void main(String[] args) {
        ConfigurableApplicationContext context= SpringApplication.run(DependencyMain.class);
        GreeterService greeterService = context.getBean(GreeterService.class);
        System.out.println(greeterService.sayGreet());

    }
}
