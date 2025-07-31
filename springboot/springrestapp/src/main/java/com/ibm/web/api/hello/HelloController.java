package com.ibm.web.api.hello;

//Bean : @Component,@Service,@Respository,@Controller(Dynamic web app),@RestController

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Resource
@RestController
@RequestMapping("/api/hello")
public class HelloController {

    //api -method
    @GetMapping
    public String sayHello(){
        return  "Hello";
    }
}
