package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;

public interface OrderRepository {

    default void createOrder(User user, LocalDateTime orderDate, Product product) {
        System.out.println("Order created and added to respository.");
    }


}