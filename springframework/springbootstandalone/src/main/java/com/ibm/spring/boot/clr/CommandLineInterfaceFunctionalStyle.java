package com.ibm.spring.boot.clr;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CommandLineInterfaceFunctionalStyle {
    public static void main(String[] args) throws Exception {
        //anonymous inner class syntax
       var r = new CommandLineRunner() {
           @Override
           public void run(String... args) throws Exception {
               System.out.println("Anonymous initalizer");
           }
       };
       r.run("hello");
       new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                System.out.println("Anonymous initalizer");
            }
        }.run("hello");

       //java 8 functional style
        ((CommandLineRunner) args1 -> {
            System.out.println("something is initalized");
        }).run();

        commandLineRunner().run("hello");
    }

    public static CommandLineRunner commandLineRunner(){
        return args -> System.out.println("runner is initialized");
    }

}
