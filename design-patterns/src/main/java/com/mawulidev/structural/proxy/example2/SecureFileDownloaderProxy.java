package com.mawulidev.structural.proxy.example2;

public class SecureFileDownloaderProxy implements FileDownloader {
    private final RealFileDownloader realDownloader;
    private final String authorizedUser;

    public SecureFileDownloaderProxy(String user) {
        this.realDownloader = new RealFileDownloader();
        this.authorizedUser = user;
    }

    private boolean isAuthorized() {
        return "admin".equalsIgnoreCase(authorizedUser); // Only "admin" can download files
    }

    @Override
    public void downloadFile(String filename) {
        if (!isAuthorized()) {
            System.out.println("Unauthorized access! Only admin users can download files.");
            return;
        }
        realDownloader.downloadFile(filename);
    }
}
