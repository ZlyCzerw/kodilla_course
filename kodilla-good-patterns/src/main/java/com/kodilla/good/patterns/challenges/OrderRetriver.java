package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;

public class OrderRetriver {


    public OrderRequest retrive(){
        User user = new User("marek","Warszawa" ,"marekzwarszawy@mail.pl");
        LocalDateTime orderDate =  LocalDateTime.of(2018,8,31,14,36);
        Product product = new Product("gąbka do zębów trzonowych", 19.99);
        return new OrderRequest (user,orderDate, product);
    }
}
