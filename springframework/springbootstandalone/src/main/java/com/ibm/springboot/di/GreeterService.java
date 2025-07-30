package com.ibm.springboot.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreeterService {
    @Autowired
    private HelloService helloService;
    public String sayGreet(){
        return helloService.sayHello();
    }
}
