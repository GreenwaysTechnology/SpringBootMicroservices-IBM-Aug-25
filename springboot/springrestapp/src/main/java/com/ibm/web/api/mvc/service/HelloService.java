package com.ibm.web.api.mvc.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public String sayHello(){
        return "Hello How are you";
    }
}
