package com.kodilla.testing.collection;

import java.util.ArrayList;

public class OddNumbersExterminator {

    //ArrayList<Integer>list = new ArrayList<>();
    public OddNumbersExterminator(ArrayList<Integer> list){
       // this.list = list;

    }



    public ArrayList exterminate(ArrayList<Integer> numbers){
        ArrayList<Integer> evenNumbers = new ArrayList<>();
        for (int n: numbers){
            if (n%2 == 0){
                evenNumbers.add(n);
            }
        }
        System.out.println(evenNumbers);
        return evenNumbers;
    }
}
