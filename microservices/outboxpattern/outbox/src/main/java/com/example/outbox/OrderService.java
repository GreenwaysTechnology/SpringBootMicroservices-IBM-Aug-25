package com.example.outbox;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OutboxRepository outboxRepository;
    private final ObjectMapper objectMapper; // For converting objects to JSON string

    public OrderService(OrderRepository orderRepository, OutboxRepository outboxRepository, ObjectMapper objectMapper) {
        this.orderRepository = orderRepository;
        this.outboxRepository = outboxRepository;
        this.objectMapper = objectMapper;
    }

    @Transactional
    public Order createOrder(OrderRequest orderRequest) {
        // 1. Create and save the business entity
        Order order = new Order();
        // ... set properties on the order from orderRequest
        order.setId(UUID.randomUUID());
        orderRepository.save(order);

        // 2. Create and save the outbox event in the SAME transaction
        try {
            String payload = objectMapper.writeValueAsString(order);
            OutboxEvent event = new OutboxEvent(
                    UUID.randomUUID(),
                    "order", // aggregatetype
                    order.getId().toString(), // aggregateid
                    "OrderCreated", // type
                    payload // payload
            );
            outboxRepository.save(event);
        } catch (Exception e) {
            // Handle JSON serialization exception
            throw new RuntimeException("Error creating outbox event", e);
        }

        return order;
    }
}