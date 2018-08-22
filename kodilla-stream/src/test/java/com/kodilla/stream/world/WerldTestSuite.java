package com.kodilla.stream.world;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class WerldTestSuite {

    @Test
    public void testSetOfCountries(){
        //Given
        HashSet<Country> allCountries = new HashSet<>();
        HashSet<Country> european = new HashSet();
        HashSet<Country> asian = new HashSet();
        HashSet<Country> nAmerican = new HashSet();
        HashSet<Country> african = new HashSet<>();

        Country Polska = new Country("Polska","Europe",BigDecimal.valueOf(38000000));
        Country Niemcy = new Country("Niemcy","Europe",BigDecimal.valueOf(80000000));
        Country Vietnam = new Country("Vietnam","Asia",BigDecimal.valueOf(50000000));
        Country Hiszpania = new Country("Hiszpania","Europe",BigDecimal.valueOf(40000000));
        Country Azerbejdżan = new Country("Azerbejdżan","Asia",BigDecimal.valueOf(15000000));
        Country RPA = new Country("RPA","Africa",BigDecimal.valueOf(60000000));
        Country USA = new Country("USA","NAmerica",BigDecimal.valueOf(380000000));
        Country Kanada = new Country("Canada","NAmerica",BigDecimal.valueOf(20000000));

        european.add(Polska);
        european.add(Niemcy);
        european.add(Hiszpania);
        nAmerican.add(USA);
        nAmerican.add(Kanada);
        asian.add(Azerbejdżan);
        asian.add(Vietnam);
        african.add(RPA);


        Continent europe = new Continent("Europe",allCountries);

        europe.addCountry(Polska);
        europe.addCountry(Niemcy);
        europe.addCountry(Hiszpania);
        europe.addCountry(Azerbejdżan);
        europe.addCountry(USA);
        europe.addCountry(Vietnam);
        europe.addCountry(RPA);
        europe.addCountry(Polska);

        HashSet allContinents = new HashSet();
        World newWorld = new World(allContinents);


        //While
        europe.pickCountriesOnContinents();
        allContinents.add(europe.getCountriesOnContinent());
        newWorld.getPeopleQuantity();

        //Then
        Assert.assertEquals(3, european.size());



    }

}
