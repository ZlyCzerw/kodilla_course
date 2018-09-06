package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightSearcher {

    public void findFilght(Flight flight) throws RouteNotFoundException{

        Map<String, Boolean> airports = new HashMap<>();
        airports.put("Manila", true);
        airports.put("Wioski Małe", false);
        airports.put("Paryż", true);
        airports.put("Rzeszów", true);

        if ( airports.containsKey(flight.getDepartureAirport()) && airports.containsKey(flight.getDepartureAirport())){
            System.out.println("szukanie lotu z: " + flight.getDepartureAirport() + " do: " + flight.getArrivalAirport());
        }
        else {
            throw new RouteNotFoundException();
        }
        if (airports.get(flight.getDepartureAirport()) && airports.get(flight.getArrivalAirport()))
        {
            System.out.println("zarezerwowano lot");
        }
        if (airports.get(flight.getDepartureAirport()) || airports.get(flight.getArrivalAirport()) ) {
            System.out.println("niestety lotnisko nieczynne");
        }

    }
}
