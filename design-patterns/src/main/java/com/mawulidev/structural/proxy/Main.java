package com.mawulidev.structural.proxy;

import com.mawulidev.structural.proxy.example1.RemoteService;
import com.mawulidev.structural.proxy.example1.RemoteServiceProxy;
import com.mawulidev.structural.proxy.example2.FileDownloader;
import com.mawulidev.structural.proxy.example2.SecureFileDownloaderProxy;

public class Main {
    public static void main(String[] args) {
        //Example1
        RemoteService service = new RemoteServiceProxy();

        System.out.println(service.fetchData("User123")); // Slow, fetches from remote
        System.out.println(service.fetchData("User123")); // Fast, fetches from cache


        //Example2
        FileDownloader downloader1 = new SecureFileDownloaderProxy("admin");
        downloader1.downloadFile("report.pdf");

        System.out.println();

        FileDownloader downloader2 = new SecureFileDownloaderProxy("guest");
        downloader2.downloadFile("confidential.pdf");
    }
}
