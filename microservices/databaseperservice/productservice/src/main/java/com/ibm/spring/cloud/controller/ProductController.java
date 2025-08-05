package com.ibm.spring.cloud.controller;

import com.ibm.spring.cloud.ProductRepository;
import com.ibm.spring.cloud.enity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @GetMapping
    public List<Product> findAll() {
        return repository.findAll();
    }

    @PostMapping
    public Product save(@RequestBody Product product) {
        return repository.save(product);
    }
}
