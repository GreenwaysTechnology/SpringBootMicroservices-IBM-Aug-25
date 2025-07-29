package com.ibm.spring.core.beans.xml.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FactoryMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        UserService userService  =context.getBean(UserService.class);
        System.out.println(userService.getUserInfo());
    }
}
