package com.mawulidev.behavioral.template.example1;

public class InternationalOrder extends OrderProcessor{
    @Override
    protected void selectItems() {
        System.out.println("Selecting items for international order.");
    }

    @Override
    protected void calculatePrice() {
        System.out.println("Calculating price including customs duties.");
    }

    @Override
    protected void processPayment() {
        System.out.println("Processing payment in foreign currency.");
    }

    @Override
    protected void shipOrder() {
        System.out.println("Shipping order via international shipping.");
    }
}
