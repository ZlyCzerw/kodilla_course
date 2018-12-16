package com.kodilla.patterns2a.decorator.pizza;

import java.math.BigDecimal;

public class VegePizzaOrderDecorator extends AbstractPizzaOrderDecorator {
    public VegePizzaOrderDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }
    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(4));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + vege ingredient";
    }
}
