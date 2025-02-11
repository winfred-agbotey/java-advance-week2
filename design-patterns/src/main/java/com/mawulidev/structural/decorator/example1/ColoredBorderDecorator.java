package com.mawulidev.structural.decorator.example1;

public class ColoredBorderDecorator extends ShapeDecorator{
    private final String borderColor;

    public ColoredBorderDecorator(Shape decoratedShape, String borderColor) {
        super(decoratedShape);
        this.borderColor = borderColor;
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        setBorderColor(borderColor);
    }

    private void setBorderColor(String color) {
        System.out.println("Setting border color to: " + color);
    }
}
