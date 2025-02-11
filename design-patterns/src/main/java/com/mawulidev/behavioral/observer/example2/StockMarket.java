package com.mawulidev.behavioral.observer.example2;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class StockMarket {
    private final Map<String, Set<StockObserver>> stockObservers = new HashMap<>();
    private final Map<String, Double> stockPrices = new HashMap<>();

    public void registerObserver(String stockSymbol, StockObserver observer) {
        stockObservers.computeIfAbsent(stockSymbol, k -> new CopyOnWriteArraySet<>()).add(observer);
    }

    public void removeObserver(String stockSymbol, StockObserver observer) {
        stockObservers.getOrDefault(stockSymbol, Set.of()).remove(observer);
    }

    public void updateStockPrice(String stockSymbol, double price) {
        stockPrices.put(stockSymbol, price);
        notifyObservers(stockSymbol, price);
    }

    private void notifyObservers(String stockSymbol, double price) {
        for (StockObserver observer : stockObservers.getOrDefault(stockSymbol, Set.of())) {
            observer.update(stockSymbol, price);
        }
    }
}
