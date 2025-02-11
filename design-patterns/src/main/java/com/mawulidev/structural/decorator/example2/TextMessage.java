package com.mawulidev.structural.decorator.example2;

public class TextMessage implements Message {
    private final String content;

    public TextMessage(String content) {
        this.content = content;
    }

    @Override
    public String getContent() {
        return content;
    }
}
