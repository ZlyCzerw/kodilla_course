package com.kodilla.stream.world2;

import java.math.BigDecimal;
import java.util.List;

public class Continent {

    private final List<Country> listOfCountries;

    public Continent(List<Country> listOfCountries) {
        this.listOfCountries = listOfCountries;
    }

    public List<Country> getListOfCountries() {
        return listOfCountries;
    }

}
