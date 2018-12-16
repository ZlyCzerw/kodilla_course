package com.kodilla.patterns2a.decorator.taxiportal;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class TaxiOrderTestSuite {

    @Test
    public void testBasicTaxiOrderGetCost(){
    //Given
        BasicTaxiOrder order = new BasicTaxiOrder();
    //When
        BigDecimal calculatedCost = order.getCost();
    //Then
        assertEquals(new BigDecimal(5.00), calculatedCost);
    }

    @Test
    public void testBasicTaxiOrderGetDescription(){

        //Given
        BasicTaxiOrder order = new BasicTaxiOrder();
        //When
        String descripton = order.getDescription();
        //Then
        assertEquals("Drive a course", descripton);
    }
    @Test
    public void testTaxiNetworkGetCost(){
        //Given
        TaxiOrder taxiOrder = new BasicTaxiOrder();
        taxiOrder = new TaxiNetworkOrderDecorator(taxiOrder);
        //When
        BigDecimal theCost = taxiOrder.getCost();
        //Then
        assertEquals(new BigDecimal(40),theCost);
    }
    @Test
    public void testMyTaxiWithChildSeatGetCost() {
        //Given
        TaxiOrder taxiOrder = new BasicTaxiOrder();
        taxiOrder = new MyTaxiNetworkOrderDecorator(taxiOrder);
        taxiOrder = new ChildSeatDecorator(taxiOrder);
        //When
        BigDecimal cost = taxiOrder.getCost();
        //then
        assertEquals(new BigDecimal(37),cost);
    }
    @Test
    public void testUberWithTwoChildSeats(){
        //Given
        TaxiOrder taxiOrder = new BasicTaxiOrder();
        taxiOrder = new UberNetworkOrderDecorator(taxiOrder);
        taxiOrder = new ChildSeatDecorator(taxiOrder);
        taxiOrder = new ChildSeatDecorator(taxiOrder);

        //when
        BigDecimal cost = taxiOrder.getCost();
        //Then
        assertEquals(new BigDecimal(29),cost);
    }
    @Test
    public void testVipTaxiWithChildSeatExpressGetCost(){
        TaxiOrder taxiOrder = new BasicTaxiOrder();
        taxiOrder = new ChildSeatDecorator(taxiOrder);
        taxiOrder = new ExpressDecorator(taxiOrder);
        taxiOrder = new VipDecorator(taxiOrder);
        taxiOrder = new MyTaxiNetworkOrderDecorator(taxiOrder);
        System.out.println(taxiOrder.getDescription());
        //When
        BigDecimal cost = taxiOrder.getCost();
        //then
        assertEquals(new BigDecimal(52), cost);
    }
}