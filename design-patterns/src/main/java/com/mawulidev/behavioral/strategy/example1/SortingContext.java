package com.mawulidev.behavioral.strategy.example1;

public class SortingContext {
    private SortingStrategy strategy;

    public void setSortingStrategy(SortingStrategy strategy) {
        this.strategy = strategy;
    }

    public void executeSort(int[] array) {
        if (strategy != null) {
            strategy.sort(array);
        } else {
            System.out.println("No sorting strategy set.");
        }
    }
}
