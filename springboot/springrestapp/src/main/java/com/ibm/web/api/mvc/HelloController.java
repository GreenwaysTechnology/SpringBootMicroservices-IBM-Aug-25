package com.ibm.web.api.mvc;

import com.ibm.web.api.mvc.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {
    @Autowired
    private HelloService helloService;
    @GetMapping
    @RequestMapping("/hello")
    public String sayHello() {
        //call biz logic
        return helloService.sayHello();
    }
}
