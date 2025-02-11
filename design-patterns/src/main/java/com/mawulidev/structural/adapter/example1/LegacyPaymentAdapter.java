package com.mawulidev.structural.adapter.example1;

public class LegacyPaymentAdapter implements PaymentGateway {
    private final LegacyPaymentProcessor legacyPaymentProcessor;

    public LegacyPaymentAdapter() {
        this.legacyPaymentProcessor = new LegacyPaymentProcessor();
    }

    @Override
    public void makePayment(double amount) {
        legacyPaymentProcessor.pay(amount);
    }
}
