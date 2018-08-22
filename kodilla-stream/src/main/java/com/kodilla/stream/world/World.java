package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class World {

    private final HashSet <Continent> continentSet;

    public World(HashSet<Continent> continentSet) {
        this.continentSet = continentSet;
    }

    public void addContinent(Continent continent){
        this.continentSet.add(continent);
    }

    public BigDecimal  getPeopleQuantity (){
       BigDecimal populationOfWorld = continentSet.stream()
                .flatMap(Continent -> Continent.getCountriesOnContinent().stream())
                .map(Country::getPeopleQuantity)
               .reduce(BigDecimal.ZERO, (sum,current)->sum = sum.add(current));

       return populationOfWorld;

    }

}
