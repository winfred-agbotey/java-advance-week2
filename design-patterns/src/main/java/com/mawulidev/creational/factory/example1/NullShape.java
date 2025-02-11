package com.mawulidev.creational.factory.example1;

public class NullShape implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing Null Shape");
    }
}
