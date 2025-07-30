package com.ibm.spring.core.annotations.streotypes;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StreoTypesMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        CustomerService customerService = context.getBean(CustomerService.class);
        System.out.println(customerService.getOrderService().findOrders());
    }
}
