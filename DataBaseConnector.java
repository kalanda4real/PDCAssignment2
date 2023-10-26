/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment2gui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnector {

    private static final String DatabaseURL = "jdbc:derby:Studentinformationmanagementsystem;create=true";

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DatabaseURL);
            if (connection != null) {
                System.out.println("Connected to the embedded Derby database successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to connect to the database: " + e.getMessage(), e);
        }
        return connection;
    }

}
