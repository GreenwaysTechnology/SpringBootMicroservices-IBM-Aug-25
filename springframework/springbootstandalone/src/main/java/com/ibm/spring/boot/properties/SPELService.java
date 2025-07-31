package com.ibm.spring.boot.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class SPELService {

    @Autowired
    private Environment environment;

    public String getInfo(){
        return  environment.getProperty("app.name","MyApp");
    }
}
