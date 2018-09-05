package com.kodilla.good.patterns.foodshop;

public class ExtraFoodShop implements Supplier {


    private String shopName;
    private int quantity;
    private Product product;
    private User user;


    public String getShopName() {
        return shopName;
    }

    public int getQuantity() {
        return quantity;
    }

    public Product getProduct() {
        return product;
    }

    public User getUser() {
        return user;
    }

    public ExtraFoodShop(String shopName, int quantity, Product product, User user) {

        this.shopName = shopName;
        this.quantity = quantity;
        this.product = product;
        this.user = user;
    }

    @Override
    public boolean process() {

        System.out.println("dokonano zamówienia: " + product.getProductName() + " w ilości: " + getQuantity() + " zamawiający: " + user.getName() + " przesyłka zostanie doręczona na adres: " + user.getAddress() + "pozdrawiamy,sklep: " + getShopName());
        return true;
    }
}

