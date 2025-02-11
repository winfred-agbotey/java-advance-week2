package com.mawulidev.behavioral.template.example1;

public abstract class OrderProcessor {
    public final void processOrder() {
        selectItems();
        calculatePrice();
        applyDiscount();
        processPayment();
        shipOrder();
    }

    protected abstract void selectItems();
    protected abstract void calculatePrice();
    protected abstract void processPayment();
    protected abstract void shipOrder();

    protected void applyDiscount() {
        System.out.println("Applying standard discount.");
    }
}
