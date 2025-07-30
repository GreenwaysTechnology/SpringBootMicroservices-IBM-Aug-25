package com.ibm.spring.core.javaconfig.di;

import com.ibm.spring.core.javaconfig.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DIJavaConfig {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        OrderService orderService = context.getBean(OrderService.class);
        System.out.println(orderService.getCustomer());

    }
}
