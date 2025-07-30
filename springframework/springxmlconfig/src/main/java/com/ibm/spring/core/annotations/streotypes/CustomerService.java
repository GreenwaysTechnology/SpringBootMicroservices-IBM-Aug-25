package com.ibm.spring.core.annotations.streotypes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component
@Service
public class CustomerService {
    @Autowired
    private OrderService orderService;

    public CustomerService() {
    }

    public CustomerService(OrderService orderService) {
        this.orderService = orderService;
    }

    public OrderService getOrderService() {
        return orderService;
    }

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }
}
