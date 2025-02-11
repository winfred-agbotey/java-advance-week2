package com.mawulidev.structural.facade.example1;


import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private final List<CartItem> items = new ArrayList<>();

    public void addItem(CartItem item) {
        items.add(item);
        System.out.println(item.getName() + " added to cart.");
    }

    public List<CartItem> getItems() {
        return items;
    }
}