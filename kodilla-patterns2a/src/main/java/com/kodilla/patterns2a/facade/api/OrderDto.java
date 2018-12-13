package com.kodilla.patterns2a.facade.api;

import com.kodilla.patterns2a.facade.Item;

import java.util.ArrayList;
import java.util.List;

public class OrderDto {
    private final List<ItemDto> items = new ArrayList<>();

    public void addItem(final ItemDto item) {
        items.add(item);
    }
    public List<ItemDto> getItems(){
        return items;
    }
}
