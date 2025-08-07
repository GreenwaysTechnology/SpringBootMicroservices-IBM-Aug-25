package com.example.outbox;

import jakarta.persistence.*;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "outbox")
public class OutboxEvent {
    @Id
    private UUID id;
    private String aggregatetype;
    private String aggregateid;
    private String type;
    @Column(columnDefinition = "jsonb")
    private String payload;
    private OffsetDateTime timestamp;
    // ... constructor, getters and setters


    public OutboxEvent(UUID id, String aggregatetype, String aggregateid, String type, String payload, OffsetDateTime timestamp) {
        this.id = id;
        this.aggregatetype = aggregatetype;
        this.aggregateid = aggregateid;
        this.type = type;
        this.payload = payload;
        this.timestamp = timestamp;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getAggregatetype() {
        return aggregatetype;
    }

    public void setAggregatetype(String aggregatetype) {
        this.aggregatetype = aggregatetype;
    }

    public String getAggregateid() {
        return aggregateid;
    }

    public void setAggregateid(String aggregateid) {
        this.aggregateid = aggregateid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public OffsetDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(OffsetDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
