package com.ibm.spring.core.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CustomerBeanUsingSpring {
    public static void main(String[] args) {
        //create instance of spring container
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Customer customer = context.getBean(Customer.class);
        System.out.println(customer.getId() + customer.getName());
    }
}
