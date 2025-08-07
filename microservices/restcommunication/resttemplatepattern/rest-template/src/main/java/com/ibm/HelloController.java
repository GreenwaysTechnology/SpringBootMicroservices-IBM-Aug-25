package com.ibm;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/greet")
    public ResponseEntity<String> sayHello(){
        String url ="http://localhost:9000/hello";
        ResponseEntity<String> response=  restTemplate.getForEntity(url,String.class);
        return response;
    }
}
