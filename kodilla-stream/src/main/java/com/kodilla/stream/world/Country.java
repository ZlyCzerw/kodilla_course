package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.Objects;

public final class Country {

    public BigDecimal getPeopleQuantity(){
        return population;
    }

    private String countryName;
    private String onContinent;
    private BigDecimal population;

    public String getCountryName() {
        return countryName;
    }

    public String getOnContinent() {
        return onContinent;
    }

    public Country(String countryName, String onContinent, BigDecimal population) {
        this.countryName = countryName;
        this.onContinent = onContinent;
        this.population = population;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return Objects.equals(countryName, country.countryName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(countryName, onContinent, population);
    }

    @Override
    public String toString() {
        return "Country{" +
                "countryName='" + countryName + '\'' +
                ", onContinent='" + onContinent + '\'' +
                ", population=" + population +
                '}';
    }
}
