package com.ayzeysdev.utils;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionFactory {
    private static final String DB_URL = "jdbc:sqlite:movie_db.sqlite";

    private static boolean initialized = false;

    public static Connection getConnection() throws SQLException {
        if (!initialized) {
            initializeSchema();
            initialized = true;
        }
        return DriverManager.getConnection(DB_URL);
    }

    private static void initializeSchema() {
        try {
            File dbFile = new File("movie_db.sqlite");
            if (!dbFile.exists()) {
                System.out.println("Database file not found. Creating a new database file.");
                try (Connection connection = DriverManager.getConnection(DB_URL);
                     Statement statement = connection.createStatement()) {

                    // Schema creation
                    String createTableSQL = """
                        CREATE TABLE IF NOT EXISTS movies (
                            id INTEGER PRIMARY KEY AUTOINCREMENT,
                            title TEXT NOT NULL,
                            genre TEXT NOT NULL,
                            actor TEXT NOT NULL
                        );
                        """;
                    statement.execute(createTableSQL);
                    System.out.println("Table 'movies' created successfully.");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error initializing the database.", e);
        }
    }

}
