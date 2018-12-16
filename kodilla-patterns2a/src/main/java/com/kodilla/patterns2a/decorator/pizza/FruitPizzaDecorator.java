package com.kodilla.patterns2a.decorator.pizza;

import java.math.BigDecimal;

public class FruitPizzaDecorator extends AbstractPizzaOrderDecorator {
    public FruitPizzaDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }
    @Override
    public BigDecimal getCost() {
        return super.getCost().subtract(new BigDecimal(1));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + you destroy your pizza with fruits so you pay less";
    }
}
