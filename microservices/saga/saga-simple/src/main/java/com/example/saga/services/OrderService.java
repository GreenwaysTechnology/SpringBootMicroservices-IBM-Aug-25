package com.example.saga.services;


import com.example.saga.entities.Order;
import com.example.saga.entities.OrderStatus;
import com.example.saga.events.*;
import com.example.saga.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void createOrder(String item) {
        Order order = new Order();
        order.setItem(item);
        order.setStatus(OrderStatus.PENDING);
        Order savedOrder = orderRepository.save(order);

        System.out.println("Order " + savedOrder.getId() + " created with status PENDING.");
        // Publish the event to start the saga
        kafkaTemplate.send("order-events", new OrderCreatedEvent(savedOrder.getId(), savedOrder.getItem()));
    }

    @KafkaListener(topics = "payment-events", groupId = "order-group")
    public void handlePaymentEvents(Object event) {
        if (event instanceof PaymentFailedEvent) {
            PaymentFailedEvent failedEvent = (PaymentFailedEvent) event;
            Order order = orderRepository.findById(failedEvent.orderId()).orElseThrow();
            order.setStatus(OrderStatus.CANCELLED);
            orderRepository.save(order);
            System.out.println("Saga failed! Payment failed for order " + order.getId() + ". Order status set to CANCELLED.");
        } else if (event instanceof PaymentProcessedEvent) {
            Order order = orderRepository.findById(((PaymentProcessedEvent) event).orderId()).orElseThrow();
            order.setStatus(OrderStatus.COMPLETED);
            orderRepository.save(order);
            System.out.println("Saga completed! Inventory updated for order " + order.getId() + ". Order status set to COMPLETED.");

        }
    }

    @KafkaListener(topics = "inventory-events", groupId = "order-group")
    public void handleInventoryEvents(Object event) {
        if (event instanceof InventoryUpdatedEvent) {
            InventoryUpdatedEvent updatedEvent = (InventoryUpdatedEvent) event;
            Order order = orderRepository.findById(updatedEvent.orderId()).orElseThrow();
            order.setStatus(OrderStatus.COMPLETED);
            orderRepository.save(order);
            System.out.println("Saga completed! Inventory updated for order " + order.getId() + ". Order status set to COMPLETED.");
        } else if (event instanceof InventoryUpdateFailedEvent) {
            InventoryUpdateFailedEvent failedEvent = (InventoryUpdateFailedEvent) event;
            Order order = orderRepository.findById(failedEvent.orderId()).orElseThrow();
            order.setStatus(OrderStatus.CANCELLED);
            orderRepository.save(order);
            System.out.println("Saga failed! Inventory update failed for order " + order.getId() + ". Order status set to CANCELLED.");
        }
    }
}
