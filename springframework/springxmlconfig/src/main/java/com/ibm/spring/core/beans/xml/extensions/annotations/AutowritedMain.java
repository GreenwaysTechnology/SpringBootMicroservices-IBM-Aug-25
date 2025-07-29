package com.ibm.spring.core.beans.xml.extensions.annotations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutowritedMain {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
        Customer customer =context.getBean(Customer.class);
        System.out.println(customer);

    }
}
