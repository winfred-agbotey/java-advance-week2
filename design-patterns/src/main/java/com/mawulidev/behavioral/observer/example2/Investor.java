package com.mawulidev.behavioral.observer.example2;

public class Investor implements StockObserver{
    private final String name;

    public Investor(String name) {
        this.name = name;
    }

    @Override
    public void update(String stockSymbol, double price) {
        System.out.println(name + " received update: " + stockSymbol + " is now $" + price);
    }
}
