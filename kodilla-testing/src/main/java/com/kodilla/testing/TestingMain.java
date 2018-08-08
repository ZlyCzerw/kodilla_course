package com.kodilla.testing;
import com.kodilla.testing.Calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;

public class TestingMain {

    public static void main (String[] args){

        SimpleUser newUser = new SimpleUser("Testuser");

        String result = newUser.getUsername();
        if (result.equals("TestUser")){
            System.out.println("test ok");
        }else{
            System.out.println("niepoprawny username");
        }
        System.out.println("Moduł 6. Wprowadzenie to testowania oprogramowania");

        Calculator newCalculator = new Calculator(325,365);

        int addingResult = newCalculator.add(newCalculator.getA(),newCalculator.getB());

        if (addingResult == 690){
            System.out.println("test dodawania ok");
        }else {
            System.out.println("zajebi****. nie umiesz dodawać kalkulatorze");
        }

        int substractingResult = newCalculator.substract(newCalculator.getA(),newCalculator.getB());

        if (substractingResult == -40){
            System.out.println("test odejmowania ok");
        }else {
            System.out.println("zajebi****. nie umiesz odejmować kalkulatorze");
        }




    }




}
