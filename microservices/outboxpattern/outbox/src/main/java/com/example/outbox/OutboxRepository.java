package com.example.outbox;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;
public interface OutboxRepository extends JpaRepository<OutboxEvent, UUID> {}

