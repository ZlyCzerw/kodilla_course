package com.kodilla.good.patterns.airline;


import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import static java.util.stream.Collectors.toList;

public class FlightSearchEngine {

    public void search(){

        FlightMapHolder holder = new FlightMapHolder();

        System.out.println("Lotniska dostępne w sieci połączeń: Poznan, Radom, Rzeszow, Warszawa, Wroclaw");
        System.out.println("Wpisz nazwę lotniska wylotu:");

        Scanner home = new Scanner(System.in);
        String homeAirport = home.nextLine();

        List <Airport> searchedFlight = holder.flightHolder().entrySet().stream()
                .filter(key -> key.getKey().getName().equals(homeAirport))
                .flatMap(f -> f.getValue().stream())
                .collect(toList());

        System.out.println("Loty dostępne bezpośrednio z lotniska  " + homeAirport + ": " + searchedFlight);
        System.out.println("Wpisz nazwę lotniska docelowego:");

        Scanner destenation = new Scanner(System.in);
        String destenationAirport = destenation.nextLine();

        List <Airport> flightsFrom = holder.flightHolder().entrySet().stream()
                .filter( f-> f.getValue().toString().contains(destenationAirport))
                .map(f->f.getKey())
                .collect(toList());

        System.out.println("Na lotnisko " + destenationAirport + " latamy z: " +flightsFrom);

        if (searchedFlight.toString().contains(destenationAirport)) {
            System.out.println("Istnieje bezpośrednie połączenie z " + homeAirport + " do " + destenationAirport);
        } else if (CollectionUtils.containsAny(searchedFlight,flightsFrom)) {
                flightsFrom.retainAll(searchedFlight);
                System.out.println("znaleziono lot(y) z przesiadką w " + flightsFrom);
        } else {
            System.out.println("Niestety nie znaleziono lotu z jedną przesiadką");
        }
    }
}
