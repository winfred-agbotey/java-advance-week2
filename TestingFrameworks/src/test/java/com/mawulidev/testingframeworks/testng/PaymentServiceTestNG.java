package com.mawulidev.testingframeworks.testng;

import com.mawulidev.testingframeworks.PaymentGateway;
import com.mawulidev.testingframeworks.PaymentService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PaymentServiceTestNG {

    @InjectMocks
    private PaymentService paymentService;

    @Mock
    private PaymentGateway paymentGateway;


    static Stream<Object[]> paymentDataProvider() {
        return Stream.of(
                new Object[]{100.0, true},
                new Object[]{50.0, false}
        );
    }

    @ParameterizedTest
    @MethodSource("paymentDataProvider")
    public void testProcessPayment(double amount, boolean expected) {
        Mockito.when(paymentGateway.charge(amount)).thenReturn(expected);

        boolean result = paymentService.processPayment(amount);
        assertEquals(expected, result);
        verify(paymentGateway).charge(amount);
    }
}

