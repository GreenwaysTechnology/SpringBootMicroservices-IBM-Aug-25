package com.ibm.eventsourcing.db;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "stock")
public class Stock {
    @Id
    @GeneratedValue
    public Long id;
    @Column(name = "name")
    public String name;
    @Column(name = "qty")
    public int quantity;
    @Column(name = "userName")
    public String user;
}
