package ibm.spring.reactive.flex;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RequestMapping("flux")
@RestController
public class FluxController {
    //Here we stream data
    @GetMapping
    public Flux<Integer> getValues() {
        return Flux.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    }
    @GetMapping
    @RequestMapping("range")
    public Flux<Integer> getRange() {
        return Flux.range(1, 1000);
    }
}
