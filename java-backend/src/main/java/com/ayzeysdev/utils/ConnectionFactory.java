package com.ayzeysdev.utils;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static final String DB_URL = "jdbc:sqlite:movie_db.sqlite";

    static {
        try {
            // Ensure the SQLite driver is loaded
            Class.forName("org.sqlite.JDBC");

            // Check if the database file exists, create if not
            File dbFile = new File("movie_db.sqlite");
            if (!dbFile.exists()) {
                System.out.println("Database file not found. Creating a new database file.");
                Connection connection = DriverManager.getConnection(DB_URL);
                connection.close();
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Failed to load SQLite driver.", e);
        } catch (SQLException e) {
            throw new RuntimeException("Error initializing the database.", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }
}
