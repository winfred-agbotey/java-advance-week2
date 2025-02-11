package com.mawulidev.creational.factory.example2;

public class PostGreSQLConnection implements DatabaseConnection {
    @Override
    public void connect() {
        System.out.println("Connected to PostGreSQL");
    }
}
