package com.ibm.spring.boot.yml;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class YamlMain {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(YamlMain.class);
        System.out.println(context.getBean(YAMLService.class).getName());
    }
}
