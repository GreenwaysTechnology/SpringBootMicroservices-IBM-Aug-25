package com.ibm.eventsourcing.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface EventRepository extends JpaRepository<EventStore, Long> {
    Iterable<EventStore> findByEntityId(String entityId);
    Iterable<EventStore> findByEntityIdAndEventTimeLessThanEqual(String entityId, LocalDateTime date);
}