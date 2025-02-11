package com.mawulidev.structural.adapter;

import com.mawulidev.structural.adapter.example1.LegacyPaymentAdapter;
import com.mawulidev.structural.adapter.example1.PaymentGateway;
import com.mawulidev.structural.adapter.example2.CSVDataSourceAdapter;
import com.mawulidev.structural.adapter.example2.DataSource;

public class Main {
    public static void main(String[] args) {
        PaymentGateway paymentGateway = new LegacyPaymentAdapter();
        paymentGateway.makePayment(100.0);

        DataSource dataSource = new CSVDataSourceAdapter("/home/mawulidev/Mawulidev/java projects/advance java/week2/design-patterns/src/main/java/com/mawulidev/structural/adapter/example2/data.csv");
        dataSource.readData().forEach(row -> {
            for (String cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        });
    }
}
