package com.kodilla.patterns.builder.bigMac;

import com.kodilla.patterns.builder.BigMac.BigMac;
import org.junit.Assert;
import org.junit.Test;

public class BigMacTestSuite {

    @Test
    public void shouldMakeABigMac(){
        //Given
       BigMac bigMac= new BigMac.BigMacBuilder()
               .bun(BigMac.BigMacBuilder.CLEAN)
               .burgers(3)
               .ingredients(BigMac.BigMacBuilder.STANDARD)
               .build();
        System.out.println(bigMac);
        //When
        int howManySouses = bigMac.getIngredients().size();
        String bunType = bigMac.getBun();
        String ingredientType = bigMac.getIngredients().get(0);
        //Then
        Assert.assertEquals(1,howManySouses);
        Assert.assertEquals("Without sesame",bunType);
        Assert.assertEquals("Standard",ingredientType);
    }
    @Test
    public void shouldMakeAVeganBigMac(){
        //Given
        BigMac bigMac= new BigMac.BigMacBuilder()
                .bun(BigMac.BigMacBuilder.WITHSESAME)
                .burgers(0)
                .ingredients(BigMac.BigMacBuilder.BBQ)
                .build();
        System.out.println(bigMac);
        //When
        int howManyBurgers = bigMac.getBurgers();
        String bunType = bigMac.getBun();
        String ingredientType = bigMac.getIngredients().get(0);
        //Then
        Assert.assertEquals(0,howManyBurgers);
        Assert.assertEquals("With sesame",bunType);
        Assert.assertEquals("barbecue",ingredientType);
    }

    @Test(expected = IllegalStateException.class)
    public void exceptionThrownAtWrongIngredient(){
       //given
        BigMac bigMac = new BigMac.BigMacBuilder()
                .bun(BigMac.BigMacBuilder.CLEAN)
                .ingredients("Ketchup")
                .burgers(2)
                .build();
        //when

        //then
    }
    @Test(expected = IllegalStateException.class)
    public void exceptionThrownAtBuilderMisused(){
        //given
        BigMac bigMac = new BigMac.BigMacBuilder()
                .bun(BigMac.BigMacBuilder.CLEAN)
                .ingredients(BigMac.BigMacBuilder.CLEAN)
                .burgers(0)
                .build();
        //when
        //then
    }

}
