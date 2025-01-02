package com.ayzeysdev.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
    private static final String PROPERTIES_FILE = "application.properties";
    private static String url;
    private static String user;
    private static String password;

    static {
        try (InputStream input = ConnectionFactory.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE)) {
            if (input == null) {
                throw new IOException("Configuration file not found: " + PROPERTIES_FILE);
            }

            Properties properties = new Properties();
            properties.load(input);

            url = properties.getProperty("database.url");
            user = properties.getProperty("database.user");
            password = properties.getProperty("database.password");
        } catch (IOException e) {
            throw new RuntimeException("Failed to load database configuration.", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}
