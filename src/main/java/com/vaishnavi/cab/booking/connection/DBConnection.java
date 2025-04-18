package com.vaishnavi.cab.booking.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/cab";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static Connection getConnection() throws SQLException {
        Connection conn = null;
        int retries = 3;
        do {
            try {
                conn = DriverManager.getConnection(URL, USER, PASSWORD);
                break;
            } catch (SQLException e) {
                System.out.println("Retrying DB connection...");
                retries--;
            }
        } while (retries > 0);
        return conn;
    }
}
