package com.kodilla.patterns2a.decorator.pizza;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class PizzaOrderTestSuite {

    @Test
    public void vegeDoubleCheeseMeatPizzaPrizeTest(){
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
    public void oneFruitTwoVegeDoubleCheeseMeatBigPizzaPrizeTest(){
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

    @Test
    public void oneFruitTwoVegeDoubleCheeseDoubleMeatBigPizzaDescriptionTest(){
        //given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new MeatPizzaOrderDecorator(pizzaOrder);
        pizzaOrder = new MeatPizzaOrderDecorator(pizzaOrder);
        pizzaOrder = new VegePizzaOrderDecorator(pizzaOrder);
        pizzaOrder = new VegePizzaOrderDecorator(pizzaOrder);
        pizzaOrder = new DoubleCheesePizzaOrderDecorator(pizzaOrder);
        pizzaOrder = new FruitPizzaDecorator(pizzaOrder);
        pizzaOrder = new BigPizzaOrderDecorator(pizzaOrder);
        System.out.println(pizzaOrder.getDescription());
        //when
        String description = pizzaOrder.getDescription();
        //then
        assertEquals(new String("Pizza z serem, sosem pomidorowym" +
                " + meat ingredient" +
                " + meat ingredient" +
                " + vege ingredient" +
                " + vege ingredient" +
                " + double cheese" +
                " + you destroy your pizza with fruits so you pay less" +
                " + BIG SIZE BABY"),description);
    }

}