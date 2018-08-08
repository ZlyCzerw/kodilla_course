package com.kodilla.testing.Calculator;

public class Calculator {


   private int a;
   private int b;

    public Calculator(int a, int b){
        this.a = a;
        this.b = b;
    }


    public int add(int a, int b){
        int result = a+b;
        System.out.println(result);
        return result;
    }
    public int substract(int a, int b){
        int result = a-b;
        System.out.println(result);
        return result;

    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }
}
