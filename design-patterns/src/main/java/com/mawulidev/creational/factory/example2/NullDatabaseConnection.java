package com.mawulidev.creational.factory.example2;

public class NullDatabaseConnection implements DatabaseConnection {
    @Override
    public void connect() {
        System.out.println("Connected to the default database");
    }
}
