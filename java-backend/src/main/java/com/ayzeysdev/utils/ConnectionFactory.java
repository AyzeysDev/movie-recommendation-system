package com.ayzeysdev.utils;

import java.io.File;
import java.sql.*;

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
        try (Connection connection = DriverManager.getConnection(DB_URL);
             Statement statement = connection.createStatement()) {

            // Check if the table exists
            ResultSet rs = statement.executeQuery("SELECT name FROM sqlite_master WHERE type='table' AND name='movies'");
            if (!rs.next()) {
                System.out.println("Table 'movies' does NOT exist. Creating it now.");
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
            } else {
                System.out.println("Table 'movies' already exists. Skipping creation.");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error initializing the database schema.", e);
        }
    }

}
