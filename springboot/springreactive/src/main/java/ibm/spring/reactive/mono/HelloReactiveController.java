package ibm.spring.reactive.mono;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.concurrent.RecursiveTask;

@RestController
@RequestMapping("/api")
public class HelloReactiveController {

    @GetMapping
    @RequestMapping("/hello")
    public Mono<String> hello(){
        System.out.println(Thread.currentThread().getName());
        return Mono.just("Hello");
    }

    @GetMapping
    @RequestMapping("/hai")
    public String hai(){
        System.out.println(Thread.currentThread().getName());
        return  "Hai";
    }


    @GetMapping
    @RequestMapping("messages")
    public Mono<List<String>> greetings() {
        return Mono.just(List.of("Hello","Hai"));
    }
}
