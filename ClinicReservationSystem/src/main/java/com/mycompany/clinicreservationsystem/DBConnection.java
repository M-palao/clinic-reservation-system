package com.mycompany.clinicreservationsystem;

import java.sql.*;


public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/clinic_reservation_db";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    
    public static Connection getConnection() {
        Connection connection = null;
        
        try {
            connection = DriverManager.getConnection(
            URL,
            USER,
            PASSWORD
            );
            System.out.println("Database connected successfully!");
        } catch (SQLException e) {
            System.out.println("Database connection failed.");
            e.printStackTrace();
        }
        return connection;
        
        
    }
    
}
