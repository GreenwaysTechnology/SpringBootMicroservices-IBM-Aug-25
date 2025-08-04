package com.ibm.curd.controller;

import com.ibm.curd.entity.Product;
import com.ibm.curd.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> findAll() {
        List<Product> products = productService.findAll();
        System.out.println(products);
        return products;
    }

    @GetMapping
    @RequestMapping("filter")
    public List<Product> filterByName(@RequestParam("name") String name) {
        List<Product> products = productService.getProductsByName(name);
        System.out.println(products);
        return products;
    }

    @GetMapping
    @RequestMapping("{id}")
    public Product findById(@PathVariable("id") Long id) {
        Product product = productService.findById(id);
        System.out.println(product);
        return product;
    }

    //    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public Product save(@RequestBody Product product) {
//        Product newProduct = productService.create(product);
//        System.out.println(newProduct);
//        return newProduct;
//    }
    @PostMapping
    public ResponseEntity<Product> save(@RequestBody Product product) {
        Product newProduct = productService.create(product);
        return ResponseEntity
                .status(201)
                .header("name", "IBM")
                .contentType(MediaType.APPLICATION_JSON)
                .body(newProduct);
    }

    @PutMapping("{id}")
    public Product update(@PathVariable Long id, @RequestBody Product product) {
        Product updatedProduct = productService.update(id, product);
        System.out.println(updatedProduct);
        return updatedProduct;
    }

    //    @DeleteMapping("{id}")
//
//    public String delete(@PathVariable Long id) {
//        return productService.deleteProduct(id) ? "Deleted" : "Not Found";
//    }
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        var res = productService.deleteProduct(id) ? "Deleted" : "Not Found";
    }
}
