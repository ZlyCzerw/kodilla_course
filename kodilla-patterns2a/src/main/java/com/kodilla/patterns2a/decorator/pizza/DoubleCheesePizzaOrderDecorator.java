package com.kodilla.patterns2a.decorator.pizza;

import java.math.BigDecimal;

public class DoubleCheesePizzaOrderDecorator extends AbstractPizzaOrderDecorator {
    public DoubleCheesePizzaOrderDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }
    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(5));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + double cheese";
    }
}
