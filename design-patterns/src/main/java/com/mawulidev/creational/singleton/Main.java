package com.mawulidev.creational.singleton;

public class Main {
    public static void main(String[] args) {
        //Logger
        Logger logger = Logger.getInstance();
        logger.log("This is a singleton log message");

        ConfigurationManager configManager = ConfigurationManager.getInstance();

        // Example: Try to get a property named "app.name"
        String appName = configManager.get("app.name");
        System.out.println("App Name: " + appName);
    }
}
