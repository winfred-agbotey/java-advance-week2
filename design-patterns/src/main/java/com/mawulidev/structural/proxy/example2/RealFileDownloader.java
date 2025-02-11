package com.mawulidev.structural.proxy.example2;

public class RealFileDownloader implements FileDownloader {
    @Override
    public void downloadFile(String filename) {
        System.out.println("Downloading file: " + filename);
        for (int i = 0; i <= 100; i += 25) {
            try {
                Thread.sleep(500); // Simulating download time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Download Progress: " + i + "%");
        }
        System.out.println("Download Complete: " + filename);
    }
}
