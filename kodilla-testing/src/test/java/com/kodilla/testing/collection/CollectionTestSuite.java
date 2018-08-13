package com.kodilla.testing.collection;

import org.junit.*;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;

public class CollectionTestSuite {

    @Before
    public void before(){
        System.out.println("Test Case: begin" );
    }
    @After
    public void after() {
        System.out.println("Test Case: end");
    }

    @Test
    public void testOddNumbersExterminatorNormalList() {

        //Given
        ArrayList<Integer> normalList = new ArrayList<>();
        normalList.add(62);
        normalList.add(98);
        normalList.add(22);
        normalList.add(1);
        normalList.add(98);
        normalList.add(0);
        normalList.add(11111);

        ArrayList<Integer> evenList = new ArrayList<>();
        evenList.add(62);
        evenList.add(98);
        evenList.add(22);
        evenList.add(98);
        evenList.add(0);

       OddNumbersExterminator list = new OddNumbersExterminator();

        //While
        ArrayList<Integer> result = list.exterminate(normalList);

        //Then
        Assert.assertTrue(evenList.equals(result));
        Assert.assertEquals(evenList,result);


    }

    @Test
    public void testOddNumbersExterminatorEmptyList() {
        //Given
        ArrayList<Integer> emptyList = new ArrayList<>();
        OddNumbersExterminator list = new OddNumbersExterminator();
        //While

        ArrayList<Integer> result = list.exterminate(emptyList);

        //Then
       Assert.assertEquals(emptyList, result);

    }
}
