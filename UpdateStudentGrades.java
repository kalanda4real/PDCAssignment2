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
public class UpdateStudentGrades{
    boolean validityChecker = false;
    
    String dbURL = "jdbc:derby://localhost:1527/Studentinformationmanagementsystem;user=PDC;password=pdc";

    
  public String updateStudentGrade(String studentID, String courseCode, String newGrade) {
    Connection connection = null;
    Statement statement = null;
    StringBuilder result = new StringBuilder();

    if(isValidGrade(newGrade)==true)
    {
    try {
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        connection = DriverManager.getConnection(dbURL);

        if (connection != null) {
            statement = connection.createStatement();
            int student;
                try {
                // Try to parse the input as an integer
                student = Integer.parseInt(studentID);
            } catch (NumberFormatException e) {
                // Handle the case where input is not a valid integer
                JOptionPane.showMessageDialog(null, "Invalid Courses ID. Please enter a valid integer.", "Error", JOptionPane.ERROR_MESSAGE);
                return result.toString();
            }
            String updateQuery = "UPDATE studentGrades "
                    + "SET grade = '" + newGrade + "' "
                    + "WHERE Student_ID = " + student + " AND course_name = '" + courseCode + "'";

            int rowsUpdated = statement.executeUpdate(updateQuery);

            if (rowsUpdated > 0) {
                result.append("Grade updated successfully for Student ID: " + studentID + " and Course Code: " + courseCode);
            } else {
                result.append("No rows updated. Student ID or Course Code not found.");
            }
        } else {
            result.append("Failed to connect to the database.");
        }
    } catch (ClassNotFoundException | SQLException e) {
        e.printStackTrace();
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
            e.printStackTrace();
            result.append("An error occurred while closing the resources: " + e.getMessage());
        }
    }}
    else{
        result.append("An error occurred Please Enter a valid Grade A,B,C,D,F");
    }
    return result.toString();
}
  public boolean isValidGrade(String grade) {
    grade = grade.trim().toUpperCase();
    return (grade.equals("A") || grade.equals("B") || grade.equals("C") || grade.equals("D") || grade.equals("F"));
}

}

