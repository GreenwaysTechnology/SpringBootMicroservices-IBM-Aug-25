package com.ibm.spring.boot.yml;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class YAMLService
{
    @Value("${app.name}")
     private String name;
    public String getName(){
        return  name;
    }
}
