package com.mawulidev.testingframeworks.mockito;

import com.mawulidev.testingframeworks.PaymentGateway;
import com.mawulidev.testingframeworks.PaymentService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


public class PaymentServiceTest {
    @InjectMocks
    private PaymentService paymentService;

    @Mock
    private PaymentGateway paymentGateway;

    private AutoCloseable closeable;

    @BeforeEach
    public void setUp() {
        //Store AutoCloseable
        closeable = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    public void tearDown() throws Exception {
        closeable.close();
    }

    @Test
    public void testProcessPayment() {
        Mockito.when(paymentGateway.charge(100.0)).thenReturn(true);

        boolean result = paymentService.processPayment(100.0);

        Assertions.assertTrue(result);
        Mockito.verify(paymentGateway).charge(100.0);
    }

    @Test
    public void testProcessPaymentWithException() {
        Mockito.when(paymentGateway.charge(100.0)).thenReturn(false);

        boolean result = paymentService.processPayment(100.0);

        Assertions.assertFalse(result);
        Mockito.verify(paymentGateway).charge(100.0);
    }


    @Test
    public void testMockInteraction(){
        //call process payment
        paymentService.processPayment(50.0);

        //verify it was called with 50.0
        Mockito.verify(paymentGateway).charge(50.0);

        //verify it was not called with 100.0
        Mockito.verify(paymentGateway, Mockito.never()).charge(100.0);
    }

}
