package com.mawulidev.structural.facade.example1;


public class DiscountService {
    public double calculateDiscount(ShoppingCart cart) {
        // For demonstration: apply 10% discount if more than 3 items.
        if(cart.getItems().size() > 3) {
            System.out.println("10% discount applied.");
            return 0.10;
        }
        return 0.0;
    }
}
