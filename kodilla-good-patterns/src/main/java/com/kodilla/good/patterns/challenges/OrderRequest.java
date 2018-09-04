package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;

public class OrderRequest {
    private User user;
    private LocalDateTime orderDate;
    private Product product;

    public User getUser() {
        return user;
    }

    public Product getProduct() {
        return product;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;

    }

    public OrderRequest(User user, LocalDateTime orderDate, Product product) {

        this.user = user;
        this.orderDate = orderDate;
        this.product = product;
    }
}
