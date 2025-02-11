package com.mawulidev.structural.facade.example1;

public class CartItem {
    private final String name;
    private final double price;

    public CartItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
}