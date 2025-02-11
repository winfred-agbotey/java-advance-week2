package com.mawulidev.behavioral.strategy;

import com.mawulidev.behavioral.strategy.example1.BubbleSort;
import com.mawulidev.behavioral.strategy.example1.SelectionSort;
import com.mawulidev.behavioral.strategy.example1.SortingContext;
import com.mawulidev.behavioral.strategy.example2.CompressionContext;
import com.mawulidev.behavioral.strategy.example2.GzipCompression;
import com.mawulidev.behavioral.strategy.example2.ZipCompression;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {

        //Example 1
        SortingContext context = new SortingContext();

        int[] data = {5, 2, 9, 1, 5, 6};

        context.setSortingStrategy(new BubbleSort());
        context.executeSort(data.clone());

        context.setSortingStrategy(new SelectionSort());
        context.executeSort(data.clone());


        //Example 2
        CompressionContext context2 = new CompressionContext();

        Path sourceFile = Paths.get("/home/mawulidev/Mawulidev/java projects/advance java/week2/design-patterns/src/main/java/com/mawulidev/behavioral/strategy/sample.txt");
        Path zipDestination = Paths.get("/home/mawulidev/Mawulidev/java projects/advance java/week2/design-patterns/src/main/java/com/mawulidev/behavioral/strategy/sample.zip");
        Path gzipDestination = Paths.get("/home/mawulidev/Mawulidev/java projects/advance java/week2/design-patterns/src/main/java/com/mawulidev/behavioral/strategy/sample.gz");

        try {
            context2.setCompressionStrategy(new ZipCompression());
            context2.compressFile(sourceFile, zipDestination);

            context2.setCompressionStrategy(new GzipCompression());
            context2.compressFile(sourceFile, gzipDestination);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
