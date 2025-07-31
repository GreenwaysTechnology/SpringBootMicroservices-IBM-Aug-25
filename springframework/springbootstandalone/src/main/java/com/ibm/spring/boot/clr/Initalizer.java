package com.ibm.spring.boot.clr;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Initalizer implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        //initalize any data
        System.out.println("Global code....1");
    }
}
