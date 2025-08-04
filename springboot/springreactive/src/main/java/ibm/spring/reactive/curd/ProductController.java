package ibm.spring.reactive.curd;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public Mono<Product> create(@RequestBody Product product) {
        return productService.save(product);
    }

    @GetMapping
    public Flux<Product> findAll() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Product> findById(@PathVariable String id) {
        return productService.findById(id);
    }

    @PutMapping("/{id}")
    public Mono<Product> update(@PathVariable String id, @RequestBody Product product) {
        return productService.update(id, product);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable String id) {
        return productService.deleteById(id);
    }

}
