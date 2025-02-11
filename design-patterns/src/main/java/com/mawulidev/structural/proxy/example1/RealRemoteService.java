package com.mawulidev.structural.proxy.example1;

public class RealRemoteService implements RemoteService {
    @Override
    public String fetchData(String key) {
        // Simulating network latency
        try {
            Thread.sleep(2000); // Simulate network delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Data for " + key + " [Fetched from Remote Server]";
    }
}
