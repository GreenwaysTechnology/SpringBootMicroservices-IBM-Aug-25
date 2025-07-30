package com.ibm.spring.core.annotations.streotypes;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;


//@Component
//@Service
@Repository
public class OrderService {

    public List<String> findOrders(){
        return  List.of("Product1","Product 2");
    }
}
