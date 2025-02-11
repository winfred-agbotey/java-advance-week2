package com.mawulidev.structural.proxy.example1;

import java.util.HashMap;
import java.util.Map;

public class RemoteServiceProxy implements RemoteService {
    private final RealRemoteService realRemoteService;
    private final Map<String, String> cache;

    public RemoteServiceProxy() {
        this.realRemoteService = new RealRemoteService();
        this.cache = new HashMap<>();
    }

    @Override
    public String fetchData(String key) {
        if (cache.containsKey(key)) {
            return "Cached: " + cache.get(key);
        }
        String data = realRemoteService.fetchData(key);
        cache.put(key, data);
        return data;
    }
}
