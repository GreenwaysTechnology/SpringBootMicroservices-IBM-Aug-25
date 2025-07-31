package com.ibm.spring.boot.properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.swing.plaf.synth.SynthOptionPaneUI;


@SpringBootApplication
public class SPELMain {
    public static void main(String[] args) {
        ConfigurableApplicationContext context= SpringApplication.run(SPELMain.class);
        SPELService service =context.getBean(SPELService.class);
        System.out.println(service.getInfo());

    }
}
