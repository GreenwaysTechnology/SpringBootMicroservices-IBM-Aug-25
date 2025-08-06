package com.ibm.eventsourcing.kafka;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class StockRemovedEvent implements StockEvent {
    private Stock stockDetails;
}