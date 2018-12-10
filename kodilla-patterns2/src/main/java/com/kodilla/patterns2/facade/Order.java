package com.kodilla.patterns2.facade;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private ProductService productService;
    private final List<Item>items = new ArrayList<>();
    private final Long orderId;
    private final Long userId;
    private boolean isPaied = false;
    private boolean isVerified = false;
    private boolean isSubmited = false;

    public Order(ProductService productService, Long orderId, Long userId) {
        this.productService = productService;
        this.orderId = orderId;
        this.userId = userId;
    }
    public BigDecimal calculateValue() {
        BigDecimal sum = BigDecimal.ZERO;
        for (Item item: items) {
            sum = sum.add(productService.getPrice(item.getProductId())
            .multiply(new BigDecimal(item.getQty()))); }
        return sum;
    }

    public ProductService getProductService() {
        return productService;
    }

    public List<Item> getItems() {
        return items;
    }

    public Long getOrderId() {
        return orderId;
    }

    public Long getUserId() {
        return userId;
    }

    public boolean isPaied() {
        return isPaied;
    }

    public void setPaied(boolean paied) {
        isPaied = paied;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean verified) {
        isVerified = verified;
    }

    public boolean isSubmited() {
        return isSubmited;
    }

    public void setSubmited(boolean submited) {
        isSubmited = submited;
    }
}