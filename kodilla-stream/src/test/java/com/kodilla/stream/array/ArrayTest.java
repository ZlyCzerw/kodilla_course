package com.kodilla.stream.array;

import javafx.beans.binding.When;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayTest {

    @Test
    public void testGetAvarage(){
        //given
        int [] numbers = {1,1,7};


        //When
        double result =  ArrayOperations.getAverage(numbers);
         //Then
        Assert.assertEquals(3, result,0001);

    }


}