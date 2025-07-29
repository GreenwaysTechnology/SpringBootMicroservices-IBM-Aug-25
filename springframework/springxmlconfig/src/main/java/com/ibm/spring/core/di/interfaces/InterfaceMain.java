package com.ibm.spring.core.di.interfaces;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InterfaceMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        CustomerDAO customerDAO =context.getBean(CustomerDAO.class);
        System.out.println(customerDAO.getRepository().findAll());
    }
}
