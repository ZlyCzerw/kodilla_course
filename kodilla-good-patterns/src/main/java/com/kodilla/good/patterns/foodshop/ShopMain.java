package com.kodilla.good.patterns.foodshop;

public class ShopMain {
    public static void main(String args[]) {


        OrderRetriver orderRetriver = new OrderRetriver();
        OrderRequest orderRequest = orderRetriver.retrive();

        Supplier supplier = orderRequest.getSupplier();
        supplier.process();

    }
}