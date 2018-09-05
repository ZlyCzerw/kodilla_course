package com.kodilla.good.patterns.airline;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FlightMapHolder {



    public HashMap<Airport, List<Airport>> flightHolder(){

        HashMap<Airport,List<Airport>> flightMap = new HashMap<>();

        Airport wroclawA = new Airport("Wroclaw");
        Airport poznanA = new Airport("Poznan");
        Airport warszawaA = new Airport("Warszawa");
        Airport radomA = new Airport("Radom");
        Airport rzeszowA = new Airport("Rzeszow");


        List <Airport> fromRzeszow = new ArrayList<>();
        List <Airport> fromRadom = new ArrayList<>();
        List <Airport> fromWarszawa = new ArrayList<>();
        List <Airport> fromPoznan = new ArrayList<>();
        List <Airport> fromWroclaw= new ArrayList<>();

        fromRzeszow.addAll(Arrays.asList(warszawaA,wroclawA,poznanA));
        fromPoznan.addAll(Arrays.asList(warszawaA,rzeszowA));
        fromWarszawa.addAll(Arrays.asList(wroclawA,poznanA,rzeszowA));
        fromWroclaw.addAll(Arrays.asList(radomA,warszawaA,rzeszowA));
        fromRadom.add(wroclawA);

        flightMap.put(wroclawA,fromWroclaw);
        flightMap.put(poznanA,fromPoznan);
        flightMap.put(warszawaA,fromWarszawa);
        flightMap.put(rzeszowA,fromRzeszow);
        flightMap.put(radomA,fromRadom);


        return flightMap;
    }
}
