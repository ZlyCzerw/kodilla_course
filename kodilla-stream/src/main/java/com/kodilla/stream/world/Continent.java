package com.kodilla.stream.world;


import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Continent {


    private final String continentName;
    private  Set<Country > countriesOnContinent;

    public Continent(String continentName, HashSet countriesOnContinent){
        this.continentName = continentName;
        this.countriesOnContinent = countriesOnContinent;
    }
    public void addCountry(Country country) {
        this.countriesOnContinent.add(country);
    }

    public Set<Country> getCountriesOnContinent() {
        return countriesOnContinent;
    }

    public void pickCountriesOnContinents(){
       Set<Country> newSet =  countriesOnContinent.stream()
               .filter(c->c.getOnContinent().equals(continentName))
                .collect(Collectors.toSet());
        System.out.println("elements" + newSet.size());
        newSet.stream()
                .forEach(System.out::println);

    }



}
