package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;

public class OrderService {
    public boolean order (final User user, final LocalDateTime orderDate, final Product product){
        System.out.println( "user: " + user.getName() + " has bought: " + product.getProductName() + "." + " Date of order: " + orderDate.getYear() + " " + orderDate.getMonth() + " " +orderDate.getDayOfMonth() );
        return true;

    }
}
