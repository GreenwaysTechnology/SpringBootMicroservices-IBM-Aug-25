package com.ibm.spring.boot.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class GreeterService {
    //application properties access

//    @Value("${greeter.name}")
//    private String name;
//
//    @Value("${greeter.message}")
//    private String message;

    @Autowired
    private Environment environment;

//    public String sayHello(){
//        return  message + name ;
//    }
    //read properties via Environment
    public String sayGreet(){
        return environment.getProperty("greeter.message","Welcome") + " " +  environment.getProperty("greeter.name","IBM") ;
    }

}


