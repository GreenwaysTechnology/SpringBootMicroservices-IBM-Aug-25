package com.ibm.spring.core.beans.annotations;

import org.springframework.stereotype.Component;

@Component
public class HelloService {
    public  String sayHello(){
        return  "Hello";
    }
}
