package com.example.saga.events;

import java.util.UUID;

public record OrderCreatedEvent(UUID orderId, String item) {}