package com.mawulidev.behavioral.strategy.example2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.GZIPOutputStream;

public class GzipCompression implements CompressionStrategy {
    @Override
    public void compress(Path sourceFile, Path destinationFile) throws IOException {
        try (GZIPOutputStream gos = new GZIPOutputStream(new FileOutputStream(destinationFile.toFile()))) {
            byte[] fileContent = Files.readAllBytes(sourceFile);
            gos.write(fileContent);
            System.out.println("File compressed using GZIP: " + destinationFile);
        }
    }
}
