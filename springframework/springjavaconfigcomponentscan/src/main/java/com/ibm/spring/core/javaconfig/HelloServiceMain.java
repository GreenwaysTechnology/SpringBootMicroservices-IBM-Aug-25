package com.ibm.spring.core.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HelloServiceMain {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        HelloService service = context.getBean(HelloService.class);
        System.out.println(service.sayHello());
    }
}
