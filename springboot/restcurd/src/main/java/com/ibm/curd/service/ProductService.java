package com.ibm.curd.service;

import com.ibm.curd.entity.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {
    //Inmemory database via Map
    private final Map<Long, Product> productMap = new HashMap<>();
    private long idCounter = 1;

    //findAll Products
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    public Product findById(Long id) {
        return productMap.get(id);
    }

    public List<Product> getProductsByName(String name) {
        return productMap.values()
                .stream()
                .filter(p -> p.getName().equalsIgnoreCase(name)).toList();
    }

    public Product create(Product product) {
        product.setId(idCounter++);
        productMap.put(product.getId(), product);
        return product;
    }

    public Product update(Long id, Product product) {
        Product existingProduct = productMap.get(id);
        if (existingProduct != null) {
            existingProduct.setName(product.getName());
            existingProduct.setPrice(product.getPrice());
        }
        return existingProduct;
    }

    public boolean deleteProduct(Long id) {
        return productMap.remove(id) != null;
    }

}
