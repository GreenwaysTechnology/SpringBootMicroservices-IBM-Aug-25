package com.ibm.spring.core.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloServiceMain {
    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        HelloService helloService = context.getBean(HelloService.class);
        System.out.println(helloService.sayHello());

    }
}
