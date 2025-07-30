package com.ibm.spring.core.javaconfig;

import org.springframework.stereotype.Service;

@Service
public class HelloService {
    public String sayHello(){
        return  "Hello";
    }
}
