package com.kodilla.patterns2a.decorator.pizza;

import java.math.BigDecimal;

public class MeatPizzaOrderDecorator extends AbstractPizzaOrderDecorator {

    public MeatPizzaOrderDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(7));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + meat ingredient";
    }
}
