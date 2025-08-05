package com.ibm.spring.cloud.repository;


import com.ibm.spring.cloud.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
