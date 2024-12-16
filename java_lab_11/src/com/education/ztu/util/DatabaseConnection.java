package com.education.ztu.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DatabaseConnection {
    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                ResourceBundle bundle = ResourceBundle.getBundle("db");
                String url = bundle.getString("db.url");
                String username = bundle.getString("db.username");
                String password = bundle.getString("db.password");

                connection = DriverManager.getConnection(url, username, password);
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("Failed to establish database connection");
            }
        }
        return connection;
    }
}
