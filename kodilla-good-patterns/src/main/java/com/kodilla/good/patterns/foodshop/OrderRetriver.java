package com.kodilla.good.patterns.foodshop;

public class OrderRetriver {
    public OrderRequest retrive(){
        User user = new User("marek",null ,"Warszawa");
        Product product = new Product("Wał korbowy glebogryzarki gąsienicowej", 19.99);
        Supplier supplier = new HealthyShop("Healthy",12 ,product, user);
        return new OrderRequest (user,supplier, product);
    }
}
