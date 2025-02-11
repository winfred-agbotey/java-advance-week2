package com.mawulidev.behavioral.strategy.example2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipCompression implements CompressionStrategy {
    @Override
    public void compress(Path sourceFile, Path destinationFile) throws IOException {
        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(destinationFile.toFile()))) {
            byte[] fileContent = Files.readAllBytes(sourceFile);
            ZipEntry entry = new ZipEntry(sourceFile.getFileName().toString());
            zos.putNextEntry(entry);
            zos.write(fileContent);
            zos.closeEntry();
            System.out.println("File compressed using ZIP: " + destinationFile);
        }
    }
}
