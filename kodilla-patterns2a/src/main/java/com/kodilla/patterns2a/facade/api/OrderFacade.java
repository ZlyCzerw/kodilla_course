package com.kodilla.patterns2a.facade.api;

import com.kodilla.patterns2a.facade.ShopService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@Service
public class OrderFacade {
    @Autowired
    private ShopService shopService;
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderFacade.class);

    public void processOrder(final OrderDto order, final Long userId) throws OrderProcessingException {
        boolean wasError = false;
        long orderId = shopService.openOrder(userId);
        LOGGER.info("Registeering new order, ID: " + orderId);
        if (orderId < 0) {
            LOGGER.error(OrderProcessingException.ERR_NOT_AUTHORISED);
            wasError = true;
            throw new OrderProcessingException(OrderProcessingException.ERR_NOT_AUTHORISED);
        }
        try {
            for (ItemDto orderItem : order.getItems()) {
                LOGGER.info("Adding item " + orderItem.getProductId() + ", " + orderItem.getQuantity() + " psc");
                shopService.addItem(orderId, orderItem.getProductId(), orderItem.getQuantity());
            }
            BigDecimal value = shopService.calculateValue(orderId);
            LOGGER.info("order value is " + value + " USD");
            if (!shopService.doPayment(orderId)) {
                LOGGER.error(OrderProcessingException.ERR_PAYMENT_REJECTED);
                wasError = true;
                throw new OrderProcessingException(OrderProcessingException.ERR_PAYMENT_REJECTED);
            }
            LOGGER.info("Paymen for order done");
            if (!shopService.verifyOrder(orderId)) {
                LOGGER.error(OrderProcessingException.ERR_VERIFICATION_ERROR);
                wasError = true;
                throw new OrderProcessingException(OrderProcessingException.ERR_VERIFICATION_ERROR);
            }
            LOGGER.info("Verification possitive, order ready to submit");
            if (!shopService.submitOrder(orderId)) {
                LOGGER.error(OrderProcessingException.ERR_SUBMITING_EROOR);
                wasError = true;
                throw new OrderProcessingException(OrderProcessingException.ERR_SUBMITING_EROOR);
            }
            LOGGER.info("Order " + orderId + " submitted");
        } finally {
            if (wasError){
                LOGGER.info("Cancelling order " + orderId);
                shopService.cancelOrder(orderId);
            }
        }
    }
}
