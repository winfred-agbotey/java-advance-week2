package com.mawulidev.structural.decorator;

import com.mawulidev.structural.decorator.example1.Circle;
import com.mawulidev.structural.decorator.example1.ColoredBorderDecorator;
import com.mawulidev.structural.decorator.example1.Shape;
import com.mawulidev.structural.decorator.example1.TransparentShapeDecorator;
import com.mawulidev.structural.decorator.example2.CompressionDecorator;
import com.mawulidev.structural.decorator.example2.EncryptionDecorator;
import com.mawulidev.structural.decorator.example2.Message;
import com.mawulidev.structural.decorator.example2.TextMessage;

public class Main {
    public static void main(String[] args) {
        //Example 1
        Shape circle = new Circle();

        // Decorate with a red border.
        Shape redBorderCircle = new ColoredBorderDecorator(circle, "Red");

        // Further decorate with transparency.
        Shape transparentRedBorderCircle = new TransparentShapeDecorator(redBorderCircle, 50);

        System.out.println("Circle with red border:");
        redBorderCircle.draw();

        System.out.println("\nCircle with red border and transparency:");
        transparentRedBorderCircle.draw();


        //Example 2
        Message message = new TextMessage("Hello, world!");

        // Decorate with encryption.
        Message encryptedMessage = new EncryptionDecorator(message);

        // Decorate with compression on top of encryption.
        Message encryptedCompressedMessage = new CompressionDecorator(encryptedMessage);

        System.out.println("Original message: " + message.getContent());
        System.out.println("Encrypted message: " + encryptedMessage.getContent());
        System.out.println("Encrypted & Compressed message: " + encryptedCompressedMessage.getContent());
    }
}
