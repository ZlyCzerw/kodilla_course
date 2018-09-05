package com.kodilla.good.patterns.foodshop;

public class GlutenFreeShop implements Supplier {
    private String shopName;
    private double quantity;
    private Product product;
    private User user;

    public String getShopName() {
        return shopName;
    }

    public double getQuantity() {
        return quantity;
    }

    public Product getProduct() {
        return product;
    }

    public User getUser() {
        return user;
    }

    public GlutenFreeShop(String shopName, double quantity, Product product, User user) {

        this.shopName = shopName;
        this.quantity = quantity;
        this.product = product;
        this.user = user;
    }

    @Override
    public boolean process() {

        System.out.println("dokonano zamówienia: " + product.getProductName() + " w ilości: " + getQuantity() + " zamawiający: " + user.getName() + " przesyłka zostanie doręczona na adres: " + user.getAddress());
        return true;
    }
}



