package com.mawulidev.structural.decorator.example2;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.zip.Deflater;

public class CompressionDecorator extends MessageDecorator {

    public CompressionDecorator(Message message) {
        super(message);
    }

    @Override
    public String getContent() {
        return compress(message.getContent());
    }

    private String compress(String content) {
        try {
            byte[] input = content.getBytes(StandardCharsets.UTF_8);
            Deflater deflater = new Deflater();
            deflater.setInput(input);
            deflater.finish();

            byte[] buffer = new byte[1024];
            int compressedDataLength = deflater.deflate(buffer);
            deflater.end();

            byte[] compressed = new byte[compressedDataLength];
            System.arraycopy(buffer, 0, compressed, 0, compressedDataLength);
            return Base64.getEncoder().encodeToString(compressed);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content;
    }
}
