package com.example.saga.events;

import java.util.UUID;

public record PaymentFailedEvent(UUID orderId) {}