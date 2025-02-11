package com.mawulidev.behavioral.template.example1;

public class DomesticOrder extends OrderProcessor{
    @Override
    protected void selectItems() {
        System.out.println("Selecting items for domestic order.");
    }

    @Override
    protected void calculatePrice() {
        System.out.println("Calculating price including local taxes.");
    }

    @Override
    protected void processPayment() {
        System.out.println("Processing payment in local currency.");
    }

    @Override
    protected void shipOrder() {
        System.out.println("Shipping order via local courier.");
    }
}
