package com.ibm.springboot.di;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public String sayHello(){
        return  "Hello";
    }
}