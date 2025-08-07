package com.example.saga.services;

import com.example.saga.entities.Inventory;
import com.example.saga.events.InventoryUpdateFailedEvent;
import com.example.saga.events.InventoryUpdatedEvent;
import com.example.saga.events.PaymentProcessedEvent;
import com.example.saga.repositories.InventoryRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @PostConstruct
    public void setupInitialInventory() {
//        Inventory item = new Inventory();
//        item.setItem("ProductA");
//        item.setQuantity(10);
//        inventoryRepository.save(item);
//        System.out.println("Initial inventory seeded for ProductA.");
        if (inventoryRepository.count() == 0) {
            Inventory item = new Inventory();
            item.setItem("ProductA");
            item.setQuantity(10);
            inventoryRepository.save(item);
            System.out.println("Initial inventory seeded for ProductA.");
        }
    }

    @KafkaListener(topics = "payment-events", groupId = "group1")
    public void handlePaymentProcessed(Object event) {
        System.out.println("Inside Inventory");
        if (event instanceof PaymentProcessedEvent) {
            PaymentProcessedEvent processedEvent = (PaymentProcessedEvent) event;
            System.out.println("InventoryService received PaymentProcessedEvent for order " + processedEvent.orderId());
            try {
                // Hardcoded to "ProductA" for simplicity
                Inventory inventory = inventoryRepository.findByItem("ProductA")
                        .orElseThrow(() -> new RuntimeException("Item not found."));

                if (inventory.getQuantity() > 0) {
                    inventory.setQuantity(inventory.getQuantity() - 1);
                    inventoryRepository.save(inventory);

                    System.out.println("Inventory for ProductA updated successfully. Remaining stock: " + inventory.getQuantity());
                    kafkaTemplate.send("inventory-events", new InventoryUpdatedEvent(processedEvent.orderId()));
                } else {
                    throw new RuntimeException("Not enough stock.");
                }
            } catch (Exception e) {
                System.out.println("Inventory update failed for order " + processedEvent.orderId() + ": " + e.getMessage());
                kafkaTemplate.send("inventory-events", new InventoryUpdateFailedEvent(processedEvent.orderId()));
            }
        }else {
            System.out.println("Else block in Inventory");
        }
    }
}