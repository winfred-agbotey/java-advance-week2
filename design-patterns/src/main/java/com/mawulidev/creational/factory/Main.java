package com.mawulidev.creational.factory;

import com.mawulidev.creational.factory.example1.Shape;
import com.mawulidev.creational.factory.example1.ShapeFactory;
import com.mawulidev.creational.factory.example2.DatabaseConnection;
import com.mawulidev.creational.factory.example2.DatabaseConnectionFactory;

public class Main {
    public static void main(String[] args) {
        //Shape
        Shape shape = ShapeFactory.getShape("circle");
        shape.draw();

        //Database Connection
        DatabaseConnection connection = DatabaseConnectionFactory.createConnection("mysqla");
        connection.connect();
    }
}
