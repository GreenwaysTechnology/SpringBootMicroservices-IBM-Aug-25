package com.ibm.eventsourcing.db;


import lombok.Data;

@Data
public class Stock {
    private String name;
    private int quantity;
    private String user;
}
