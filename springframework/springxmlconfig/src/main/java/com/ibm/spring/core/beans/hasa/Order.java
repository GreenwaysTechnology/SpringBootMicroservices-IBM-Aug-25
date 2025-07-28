package com.ibm.spring.core.beans.hasa;

public class Order {
    private int orderId;
    private Product product;

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", product=" + product +
                '}';
    }

    public Order() {
    }

    public Order(int orderId, Product product) {
        this.orderId = orderId;
        this.product = product;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
