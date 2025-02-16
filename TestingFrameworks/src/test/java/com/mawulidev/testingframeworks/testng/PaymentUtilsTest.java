package com.mawulidev.testingframeworks.testng;

import com.mawulidev.testingframeworks.PaymentUtils;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PaymentUtilsTest {
    @Test
    public void testMockStaticMethod() {
        try (MockedStatic<PaymentUtils> mockedStatic = Mockito.mockStatic(PaymentUtils.class)) {
            mockedStatic.when(() -> PaymentUtils.validateAmount(100.0)).thenReturn(true);

            boolean result = PaymentUtils.validateAmount(100.0);

            Assert.assertTrue(result);
            mockedStatic.verify(() -> PaymentUtils.validateAmount(100.0));
        }
    }
}
