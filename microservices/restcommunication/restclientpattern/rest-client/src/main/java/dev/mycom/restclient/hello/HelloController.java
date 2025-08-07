package dev.mycom.restclient.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
public class HelloController {

    private final RestClient restClient;

    //Rest Client Object need to be created
    public HelloController() {
        restClient = RestClient.builder()
                .baseUrl("http://localhost:9000")
                .build();
    }

    @GetMapping("greet")
    public String sayHello() {
        return restClient.get().uri("/hello").retrieve().body(String.class);
    }

}
