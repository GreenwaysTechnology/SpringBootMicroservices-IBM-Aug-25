package ibm.spring.reactive.curd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public Mono<Product> save(Product product) {
        return repository.save(product);
    }

    public Mono<Product> findById(String id) {
        return repository.findById(id);
    }

    public Flux<Product> findAll() {
        return repository.findAll();
    }

    public Mono<Product> update(String id, Product product) {
        return repository.update(id, product);
    }

    public Mono<Void> deleteById(String id) {
        return repository.deleteById(id);
    }
}
