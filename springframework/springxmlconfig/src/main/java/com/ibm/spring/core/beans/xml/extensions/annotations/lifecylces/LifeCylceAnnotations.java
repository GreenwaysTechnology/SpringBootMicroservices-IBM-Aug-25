package com.ibm.spring.core.beans.xml.extensions.annotations.lifecylces;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LifeCylceAnnotations {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        context.getBean(HelloService.class);
        context.registerShutdownHook();
    }
}
