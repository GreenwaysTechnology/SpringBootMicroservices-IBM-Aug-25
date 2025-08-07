package com.example.saga.entities;


import jakarta.persistence.*;
import lombok.Data;
import java.util.UUID;

@Entity
@Table(name = "orders")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String item;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}