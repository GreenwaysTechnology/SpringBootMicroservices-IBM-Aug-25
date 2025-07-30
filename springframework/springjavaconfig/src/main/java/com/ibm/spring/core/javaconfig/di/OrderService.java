package com.ibm.spring.core.javaconfig.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private CustomerService customerService;

    public String getCustomer() {
        return customerService.getCustomer();
    }
}
