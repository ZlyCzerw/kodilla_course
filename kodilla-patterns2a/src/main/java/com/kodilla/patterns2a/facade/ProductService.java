package com.kodilla.patterns2a.facade;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Random;

@Service
public class ProductService {

    public BigDecimal getPrice(Long productId){
        Random random = new Random();
        return new BigDecimal(random.nextInt(10000)/100);
    }
}