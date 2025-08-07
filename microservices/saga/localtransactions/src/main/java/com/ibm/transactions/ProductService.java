package com.ibm.transactions;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> findAll() {
        return repository.findAll();
    }

    @Transactional
    public Product save(Product product) {
        if (product.getPrice() < 0) {
            throw new IllegalArgumentException("Price cant be negative");
        }
        return repository.save(product);
    }
}
