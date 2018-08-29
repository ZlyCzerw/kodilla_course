package com.kodilla.exception.test;

public class RouteNotFoundException extends Exception {
    public void routeNotFoundException(){
        System.out.println("nie znaleziono lotniska w bazie");
    }
}
