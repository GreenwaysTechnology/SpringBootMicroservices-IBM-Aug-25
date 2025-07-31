package com.ibm.spring.boot.properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ConfigServiceMain {
    public static void main(String[] args) {
        ConfigurableApplicationContext context=SpringApplication.run(ConfigServiceMain.class);
        AppService appService = context.getBean(AppService.class);
        System.out.println(appService.getInfo());
        System.out.println(appService.getDatasourceInfo());
    }
}
