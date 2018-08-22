package com.kodilla.stream.world2;

import com.kodilla.stream.world2.Continent;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.junit.Assert.*;

public class WorldTest {

    @Test
    public void getPeopleQuantity() {
        //Given
        Country Poland = new Country(new BigDecimal(38000000));
        Country Spain = new Country(new BigDecimal(38000000));
        Continent Europe = new Continent(Arrays.asList(Poland,Spain));
        World Earth = new World(Arrays.asList(Europe));
        //When
        BigDecimal total = Earth.getPeopleQuantity();
        //Then
        Assert.assertEquals(new BigDecimal(76000000),total);
    }
}