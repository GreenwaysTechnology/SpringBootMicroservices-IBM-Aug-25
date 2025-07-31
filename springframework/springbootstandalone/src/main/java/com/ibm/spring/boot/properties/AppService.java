package com.ibm.spring.boot.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppService {

    @Autowired
    private ApplicationConfigProperties properties;
    public String getInfo(){
        return  properties.getName() + " " + properties.getAuthor();
    }
    public String getDatasourceInfo(){
        return properties.getDatasource().getUrl() + properties.getDatasource().getUsername();
    }
}
