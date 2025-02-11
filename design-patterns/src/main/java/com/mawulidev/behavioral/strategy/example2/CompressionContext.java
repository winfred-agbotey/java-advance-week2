package com.mawulidev.behavioral.strategy.example2;

import java.io.IOException;
import java.nio.file.Path;

public class CompressionContext {
    private CompressionStrategy strategy;

    public void setCompressionStrategy(CompressionStrategy strategy) {
        this.strategy = strategy;
    }

    public void compressFile(Path sourceFile, Path destinationFile) throws IOException {
        if (strategy != null) {
            strategy.compress(sourceFile, destinationFile);
        } else {
            throw new IllegalStateException("Compression strategy not set.");
        }
    }
}
