package com.kodilla.good.patterns.foodshop;

public class HealthyShop implements Supplier  {

    private String shopName;
    private int quantity;
    private Product product;
    private User user;
    boolean emailAdded = false;

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

    public HealthyShop(String shopName, int quantity, Product product, User user) {

        this.shopName = shopName;
        this.quantity = quantity;
        this.product = product;
        this.user = user;
    }

    @Override
    public boolean process() {

       if (user.getEmail()!=null) {

           emailAdded = true;
           System.out.println("dokonano zamówienia: " + product.getProductName() + " w ilości: " + getQuantity() + " zamawiający: " + user.getName() + ". Przesyłka zostanie doręczona na adres: " + user.getAddress() +
           ", dodano zniżkę za rejestrację.");
           return true;
       }
        System.out.println("dokonano zamówienia: " + product.getProductName() + " w ilości: " + getQuantity() + " zamawiający: " + user.getName() + " przesyłka zostanie doręczona na adres: " + user.getAddress());
       return true;

    }
}
