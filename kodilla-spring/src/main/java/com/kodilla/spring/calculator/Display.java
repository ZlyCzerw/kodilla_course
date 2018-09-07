package com.kodilla.spring.calculator;


import org.springframework.stereotype.Component;

@Component
public final class Display {

    public double displayValue(double value){
        System.out.println(value);
        return value;
    }
}
