package com.ibm.spring.boot.clr;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CommandLineInterfaceMain implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Global Code -2");
    }

    public static void main(String[] args) {
        SpringApplication.run(CommandLineInterfaceMain.class);
    }
}
