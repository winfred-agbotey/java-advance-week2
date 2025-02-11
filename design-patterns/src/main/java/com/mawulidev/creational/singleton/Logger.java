package com.mawulidev.creational.singleton;

public class Logger {
    //Private constructor prevents instantiation from other classes
    private Logger() {
    }

    //Inner static class responsible for holding the single instance of Logger
    private static class LoggerHolder {
        private static final Logger INSTANCE = new Logger();
    }

    public static Logger getInstance() {
        return LoggerHolder.INSTANCE;
    }

    //Logging method example
    public void log(String message) {
        System.out.println("[LOG] " + message);
    }

    public static class Main {
        public static void main(String[] args) {
            System.out.println("Hello, Welcome to Design Patterns!");

            //Singleton Pattern
            Logger logger = getInstance();
            logger.log("This is a log message");
        }
    }
}
