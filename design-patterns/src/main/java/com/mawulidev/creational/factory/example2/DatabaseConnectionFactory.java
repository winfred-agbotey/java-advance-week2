package com.mawulidev.creational.factory.example2;

public class DatabaseConnectionFactory {
    public static DatabaseConnection createConnection(String dbType) {
        return switch (dbType.toLowerCase()) {
            case "mysql" -> new MySQLConnection();
            case "postgresql" -> new PostGreSQLConnection();
            default -> new NullDatabaseConnection();
        };
    }
}
