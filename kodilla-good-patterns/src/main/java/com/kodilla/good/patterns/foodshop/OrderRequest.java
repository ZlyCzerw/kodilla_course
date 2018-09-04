package com.kodilla.good.patterns.foodshop;

public class OrderRequest {
    private User user;
    private Supplier supplier;
    private Product product;


    public User getUser() {
        return user;
    }

    public Product getProduct() {
        return product;
    }

    public Supplier getSupplier() {
        return supplier;

    }

    public OrderRequest(User user, Supplier supplier, Product product) {

        this.user = user;
        this.supplier = supplier;
        this.product = product;
    }
}