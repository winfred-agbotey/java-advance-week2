package com.mawulidev.structural.decorator.example1;

public class TransparentShapeDecorator extends ShapeDecorator {
    private final int transparency; // percentage

    public TransparentShapeDecorator(Shape decoratedShape, int transparency) {
        super(decoratedShape);
        this.transparency = transparency;
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        applyTransparency(transparency);
    }

    private void applyTransparency(int transparency) {
        System.out.println("Applying transparency: " + transparency + "%");
    }
}
