package com.kodilla.stream.world2;

import java.math.BigDecimal;
import java.util.List;

public class World {

    private final List<Continent> listOfContinents;

    public World(List<Continent> listOfContinents) {
        this.listOfContinents = listOfContinents;
    }

    public BigDecimal getPeopleQuantity(){
        BigDecimal worldPopulation = listOfContinents.stream()
                .flatMap(continent -> continent.getListOfCountries().stream())
                .map(Country::getPeopleQuantity)
                .reduce(BigDecimal.ZERO, BigDecimal::add);


        return worldPopulation;
    }
}
