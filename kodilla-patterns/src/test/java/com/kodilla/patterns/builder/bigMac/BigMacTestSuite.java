package com.kodilla.patterns.builder.bigMac;

import com.kodilla.patterns.builder.BigMac.BigMac;
import org.junit.Assert;
import org.junit.Test;

public class BigMacTestSuite {

    @Test
    public void bigMacTest(){
        //Given
       BigMac bigMac= new BigMac.BigMacBuilder()
               .bun(BigMac.BigMacBuilder.CLEAN)
               .burgers(3)
               .ingredients(BigMac.BigMacBuilder.STANDARD)
               .build();
        System.out.println(bigMac);
        //When
        int howManySouses = bigMac.getIngredients().size();
        //Then
        Assert.assertEquals(1,howManySouses);
    }
}