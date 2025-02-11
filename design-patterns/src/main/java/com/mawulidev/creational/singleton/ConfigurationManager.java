package com.mawulidev.creational.singleton;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationManager {
    private Properties properties = new Properties();

    private ConfigurationManager() {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (inputStream != null) {
                properties.load(inputStream);
                System.out.println("Configuration loaded from config.properties.");
            } else {
                System.out.println("config.properties not found. Falling back to environment variables.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class Holder {
        private static final ConfigurationManager INSTANCE = new ConfigurationManager();
    }

    //Global access point to get the Singleton instance
    public static ConfigurationManager getInstance() {
        return Holder.INSTANCE;
    }

    // Retrieves a configuration value either from properties or from the environment
    public String get(String key) {
        String value = properties.getProperty(key);
        if (value == null) {
            value = System.getenv(key);
        }
        return value;
    }

}
