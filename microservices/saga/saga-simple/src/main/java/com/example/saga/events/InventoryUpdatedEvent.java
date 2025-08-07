package com.example.saga.events;

import java.util.UUID;

public record InventoryUpdatedEvent(UUID orderId) {}