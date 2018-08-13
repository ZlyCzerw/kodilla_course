package com.kodilla.testing.collection;

import java.util.ArrayList;

public class OddNumbersExterminator {


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
