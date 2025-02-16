package com.mawulidev.testingframeworks;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PaymentService {
    private final PaymentGateway paymentGateway;

    public boolean processPayment(double amount) {
        return paymentGateway.charge(amount);
    }
}
