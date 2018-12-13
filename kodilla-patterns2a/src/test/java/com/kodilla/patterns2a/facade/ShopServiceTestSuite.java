package com.kodilla.patterns2a.facade;

import com.kodilla.patterns2a.facade.api.ItemDto;
import com.kodilla.patterns2a.facade.api.OrderDto;
import com.kodilla.patterns2a.facade.api.OrderFacade;
import com.kodilla.patterns2a.facade.api.OrderProcessingException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShopServiceTestSuite {


    @Autowired
    private ShopService shopService;
    @Autowired
    private OrderFacade orderFacade;

    @Test
    public void testShopServiceSubmitOrder() {
        long orderId = shopService.openOrder(1L);
        System.out.println("Registering new order, ID: " + orderId);
        if (orderId > 0) {
            shopService.addItem(orderId, 10L, 2);
            System.out.println("Adding item: 10, 2 pcs");
            shopService.addItem(orderId, 216L, 1);
            System.out.println("Adding item: 216, 1 pc");
            shopService.addItem(orderId, 25L, 1);
            System.out.println("Adding item: 25, 1 pc");
            shopService.addItem(orderId, 100L, 2.5);
            System.out.println("Adding item: 100, 2.5 pcs");
            shopService.addItem(orderId, 11L, 3);
            System.out.println("Adding item: 11, 3 pcs");
            if (shopService.removeItem(orderId, 100L)) {
                System.out.println("Item 100 was deleted from order");
            } else {
                throw new IllegalStateException("Order data is corrupted");
            }
            BigDecimal value = shopService.calculateValue(orderId);
            System.out.println("Order value is: " + value + " USD");
            if (shopService.doPayment(orderId)) {
                System.out.println("Payment for order was done");
            } else {
                System.out.println("Payment was rejected");
            }
            if (shopService.verifyOrder(orderId)) {
                System.out.println("Order is ready to submit");
            } else {
                System.out.println("Order cannot be submitted");
            }
            if (shopService.submitOrder(orderId)) {
                System.out.println("Order submitted - have a nice day!");
            } else {
                System.out.println("Order not submitted - cancelling");
                shopService.cancelOrder(orderId);
                System.out.println("Order is cancelled");
            }
        } else {
            System.out.println("Access denied. User is not authenticated.");
        }
    }
    @Test
    public void testOrderFacade(){
        OrderDto orderDto = new OrderDto();
        orderDto.addItem(new ItemDto(10L,2));
        orderDto.addItem(new ItemDto(216L,1));
        orderDto.addItem(new ItemDto(25L,1));
        orderDto.addItem(new ItemDto(11L,3));
        try {
            orderFacade.processOrder(orderDto,10L);
        } catch (OrderProcessingException e) {
            e.printStackTrace();
        }

    }
}