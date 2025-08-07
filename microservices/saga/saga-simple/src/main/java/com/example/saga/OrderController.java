package com.example.saga;

import com.example.saga.services.OrderService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/orders")
    public String placeOrder(@RequestBody OrderRequestDto request) {
        orderService.createOrder(request.getItem());
        return "Order request initiated. Check the console logs for the saga status.";
    }
}

@Data
class OrderRequestDto {
    private String item;
}
