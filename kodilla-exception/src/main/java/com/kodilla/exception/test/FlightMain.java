package com.kodilla.exception.test;

public class FlightMain {
    public static void main (String args[]){
        Flight flight1 = new Flight("Wawa", "Manila");
        FlightSearcher flightSearcher = new FlightSearcher();
        try {
            flightSearcher.findFilght(flight1);
        } catch (RouteNotFoundException e) {
            e.routeNotFoundException();
        }
    }
}
