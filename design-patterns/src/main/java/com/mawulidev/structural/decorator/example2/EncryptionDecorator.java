package com.mawulidev.structural.decorator.example2;

public class EncryptionDecorator extends MessageDecorator {

    public EncryptionDecorator(Message message) {
        super(message);
    }

    @Override
    public String getContent() {
        // Simulate encryption (e.g., a simple Caesar cipher with shift 3).
        return encrypt(message.getContent());
    }

    private String encrypt(String content) {
        StringBuilder encrypted = new StringBuilder();
        for (char c : content.toCharArray()) {
            encrypted.append((char) (c + 3));
        }
        return encrypted.toString();
    }
}