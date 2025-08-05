package com.ibm.spring.cloud;

import com.ibm.spring.cloud.enity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
