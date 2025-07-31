package com.ibm.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    @Autowired
    private Environment environment;
    public String getInfo(){
        return  environment.getProperty("app.name");
    }
}
