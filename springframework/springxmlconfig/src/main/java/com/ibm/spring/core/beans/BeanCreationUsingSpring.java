package com.ibm.spring.core.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanCreationUsingSpring {
    public static void main(String[] args) {
        //create instance of spring container
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        GreeterService greeterService = context.getBean(GreeterService.class);
        System.out.println(greeterService.sayHello());

    }
}
