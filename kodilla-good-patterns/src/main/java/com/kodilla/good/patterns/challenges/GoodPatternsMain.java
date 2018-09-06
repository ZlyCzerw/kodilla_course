package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

import static java.util.stream.Collectors.toList;

public class GoodPatternsMain {
    public static void main (String args[]){

      // zadanie 9.1
        MovieStore store = new MovieStore();
        List <String> movies = store.getMovies().entrySet().stream()
               .flatMap(e-> e.getValue().stream())
               .collect(toList());

        String exclamationSeparatedMovies = String.join("! ",movies);
        System.out.println(exclamationSeparatedMovies);


    OrderRetriver orderRetriver = new OrderRetriver();
    OrderRequest request = orderRetriver.retrive();
    ProductOrderService productOrderService = new ProductOrderService(new InformationService() {}, new OrderService(), new OrderRepository() {});
        productOrderService.process(request);
    }
}
