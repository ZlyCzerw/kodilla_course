package com.kodilla.patterns2a.decorator.pizza;

import java.math.BigDecimal;

public class BasicPizzaOrder implements PizzaOrder {


    @Override
    public BigDecimal getCost(){
        return new BigDecimal(12);
    }

    @Override
    public String getDescription() {
        return "Pizza z serem, sosem pomidorowym" ;
    }
}
