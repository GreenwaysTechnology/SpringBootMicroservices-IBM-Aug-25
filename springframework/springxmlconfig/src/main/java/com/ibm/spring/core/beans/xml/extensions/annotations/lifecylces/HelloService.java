package com.ibm.spring.core.beans.xml.extensions.annotations.lifecylces;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class HelloService {

    @PostConstruct
    public void init(){
        System.out.println("Init");
    }

    @PreDestroy
    public void destory(){
        System.out.println("Destory");
    }
}
