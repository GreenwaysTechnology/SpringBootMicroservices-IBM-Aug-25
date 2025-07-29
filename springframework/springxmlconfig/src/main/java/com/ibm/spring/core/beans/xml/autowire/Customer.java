package com.ibm.spring.core.beans.xml.autowire;

public class Customer {
    private int id;
    private String name;
    private Order order;

    public Customer() {
    }

    public Customer(Order order) {
        this.order = order;
    }

    public Customer(int id, String name, Order order) {
        this.id = id;
        this.name = name;
        this.order = order;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", order=" + order +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

}
