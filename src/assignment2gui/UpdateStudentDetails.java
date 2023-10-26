/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment2gui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author martinkalanda
 */
public class UpdateStudentDetails {

    String dbURL = "jdbc:derby://localhost:1527/Studentinformationmanagementsystem;user=PDC;password=pdc";

    public String updateStudentDetails(String studentID, String newPostcode, String newPhonenumber) {
        Connection connection = null;
        Statement statement = null;
        StringBuilder result = new StringBuilder();

        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            connection = DriverManager.getConnection(dbURL);

            if (connection != null) {
                statement = connection.createStatement();
                int studentid;
                try {
                    // Try to parse the input as an integer
                    studentid = Integer.parseInt(studentID);
                } catch (NumberFormatException e) {
                    // Handle the case where input is not a valid integer
                    JOptionPane.showMessageDialog(null, "Invalid Courses ID. Please enter a valid integer.", "Error", JOptionPane.ERROR_MESSAGE);
                    return result.toString();
                }
                int pnumber, pcode;

                try {

                    pnumber = Integer.parseInt(newPhonenumber);
                    pcode = Integer.parseInt(newPostcode);
                } catch (NumberFormatException e) {

                    JOptionPane.showMessageDialog(null, "Invalid Phone Number or Postcode. Please enter valid integers.", "Error", JOptionPane.ERROR_MESSAGE);
                    return result.toString();
                }
                String updateQuery = "UPDATE studentInfo "
                        + "SET phonenumber = " + pnumber + ", postcode = " + pcode + " "
                        + "WHERE ID = " + studentid;

                int rowsUpdated = statement.executeUpdate(updateQuery);

                if (rowsUpdated > 0) {
                    result.append("Details updated successfully for Student ID: " + studentID);
                } else {
                    result.append("No rows updated. Student ID not found");
                }
            } else {
                result.append("Lost connection to data");
            }
        } catch (ClassNotFoundException | SQLException e) {
            result.append("An error occurred: " + e.getMessage());
        } finally {
            // Close the statement and connection in a finally block
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                result.append("An error occurred while closing the resources: " + e.getMessage());
            }
        }
        return result.toString();
    }

}
