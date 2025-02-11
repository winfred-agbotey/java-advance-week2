package com.mawulidev.creational.factory.example2;

public class MySQLConnection implements DatabaseConnection{
    @Override
    public void connect() {
        System.out.println("MySQL connection established");
    }
}
