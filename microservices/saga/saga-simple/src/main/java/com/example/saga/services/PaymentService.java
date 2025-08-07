package com.example.saga.services;

import com.example.saga.entities.Payment;
import com.example.saga.events.OrderCreatedEvent;
import com.example.saga.events.PaymentFailedEvent;
import com.example.saga.events.PaymentProcessedEvent;
import com.example.saga.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @KafkaListener(topics = "order-events", groupId = "group1")
    public void handleOrderCreated(OrderCreatedEvent event) {
        System.out.println("PaymentService received OrderCreatedEvent for order " + event.orderId());
        try {
            // Simulate payment processing logic (e.g., a 20% chance of failure)
            if (new Random().nextDouble() < 0.2) {
                throw new RuntimeException("Payment failed due to an error.");
            }

            Payment payment = new Payment();
            payment.setOrderId(event.orderId());
            payment.setProcessed(true);
            paymentRepository.save(payment);

            System.out.println("Payment processed successfully for order " + event.orderId());
            kafkaTemplate.send("payment-events", new PaymentProcessedEvent(event.orderId()));

        } catch (Exception e) {
            Payment payment = new Payment();
            payment.setOrderId(event.orderId());
            payment.setProcessed(false);
            paymentRepository.save(payment);
            System.out.println("Payment failed for order " + event.orderId() + ": " + e.getMessage());
            kafkaTemplate.send("payment-events", new PaymentFailedEvent(event.orderId()));
        }
    }
}