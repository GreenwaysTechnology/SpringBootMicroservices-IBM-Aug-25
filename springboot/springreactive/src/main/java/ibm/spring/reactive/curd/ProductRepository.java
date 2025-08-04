package ibm.spring.reactive.curd;

import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class ProductRepository {
    private final Map<String, Product> productMap = new ConcurrentHashMap<>();

    //save
    public Mono<Product> save(Product product) {
        productMap.put(product.getId(), product);
        return Mono.just(product);
    }

    public Mono<Product> findById(String id) {
        Product product = productMap.get((id));
        return product != null ? Mono.just(product) : Mono.empty();
    }

    public Flux<Product> findAll() {
        return Flux.fromIterable(productMap.values());
    }

    public Mono<Product> update(String id, Product updatedProduct) {
        if (productMap.containsKey(id)) {
            updatedProduct.setId(id);
            productMap.put(id, updatedProduct);
            return Mono.just(updatedProduct);
        }
        return Mono.empty();
    }

    public Mono<Void> deleteById(String id) {
        productMap.remove(id);
        return Mono.empty();
    }
}
