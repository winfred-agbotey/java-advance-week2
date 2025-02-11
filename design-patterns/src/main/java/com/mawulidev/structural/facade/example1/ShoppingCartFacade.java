package com.mawulidev.structural.facade.example1;

public class ShoppingCartFacade {
    private final ShoppingCart cart;
    private final DiscountService discountService;
    private final CheckoutService checkoutService;

    public ShoppingCartFacade() {
        cart = new ShoppingCart();
        discountService = new DiscountService();
        checkoutService = new CheckoutService();
    }

    public void addItem(String name, double price) {
        CartItem item = new CartItem(name, price);
        cart.addItem(item);
    }

    public void checkout() {
        double total = cart.getItems().stream()
                .mapToDouble(CartItem::getPrice)
                .sum();
        double discount = discountService.calculateDiscount(cart);
        double finalAmount = total * (1 - discount);
        checkoutService.checkout(finalAmount);
    }
}
