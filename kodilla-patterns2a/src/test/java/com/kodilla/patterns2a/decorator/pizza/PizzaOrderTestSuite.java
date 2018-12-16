package com.kodilla.patterns2a.decorator.pizza;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class PizzaOrderTestSuite {

    @Test
    public void VegeDoubleCheeseMeatPizzaTest(){
        //given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new MeatPizzaOrderDecorator(pizzaOrder);
        pizzaOrder = new VegePizzaOrderDecorator(pizzaOrder);
        pizzaOrder = new DoubleCheesePizzaOrderDecorator(pizzaOrder);
        System.out.println(pizzaOrder.getDescription());
        //when
        BigDecimal cost = pizzaOrder.getCost();
        //then
        assertEquals(new BigDecimal(28),cost);
    }

    @Test
    public void OneFruitTwoVegeDoubleCheeseMeatBigPizza(){
        //given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new MeatPizzaOrderDecorator(pizzaOrder);
        pizzaOrder = new VegePizzaOrderDecorator(pizzaOrder);
        pizzaOrder = new VegePizzaOrderDecorator(pizzaOrder);
        pizzaOrder = new DoubleCheesePizzaOrderDecorator(pizzaOrder);
        pizzaOrder = new FruitPizzaDecorator(pizzaOrder);
        pizzaOrder = new BigPizzaOrderDecorator(pizzaOrder);
        System.out.println(pizzaOrder.getDescription());
        //when
        BigDecimal cost = pizzaOrder.getCost();
        //then
        assertEquals(new BigDecimal(41),cost);
    }


}