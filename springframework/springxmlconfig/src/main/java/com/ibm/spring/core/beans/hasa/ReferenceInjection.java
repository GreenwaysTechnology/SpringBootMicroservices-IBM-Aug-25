package com.ibm.spring.core.beans.hasa;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ReferenceInjection {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Product product =context.getBean(Product.class);
        System.out.println(product);
        Order order = context.getBean(Order.class);
        System.out.println(order);
        System.out.println(order.getProduct().getProductName());
    }
}
