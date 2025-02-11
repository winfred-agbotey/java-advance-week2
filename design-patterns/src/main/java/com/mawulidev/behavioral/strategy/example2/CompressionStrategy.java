package com.mawulidev.behavioral.strategy.example2;

import java.io.IOException;
import java.nio.file.Path;

public interface CompressionStrategy {
    void compress(Path sourceFile, Path destinationFile) throws IOException;

}
