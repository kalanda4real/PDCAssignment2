/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment2gui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author martinkalanda
 */
public class InfoSearch {

    boolean validityChecker = false;

    String dbURL = "jdbc:derby://localhost:1527/Studentinformationmanagementsystem;user=PDC;password=pdc";

    public String searchStudentCourses(String Student_id) {
        Connection connection = null;
        Statement statement = null;
        StringBuilder result = new StringBuilder();

        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            connection = DriverManager.getConnection(dbURL);

            if (connection != null) {
                result.append("ALL Courses taken by this student");

                statement = connection.createStatement();
                // Construct the SQL query to get course information by course ID
                
                int studnet;
                try {
                // Try to parse the input as an integer
                studnet = Integer.parseInt(Student_id);
            } catch (NumberFormatException e) {
                // Handle the case where input is not a valid integer
                JOptionPane.showMessageDialog(null, "Invalid Courses ID. Please enter a valid integer.", "Error", JOptionPane.ERROR_MESSAGE);
                return result.toString();
            }
                String query = "SELECT Student_id, current_courses, previous_courses "
                        + " FROM StudentCourses "
                        + "WHERE Student_id =" + Student_id;

                ResultSet resultSet = statement.executeQuery(query);

                while (resultSet.next()) {
                    validityChecker = true;
                    String studentID = resultSet.getString("Student_id");
                    String currentCourses = resultSet.getString("current_courses");
                    String prevcourses = resultSet.getString("previous_courses");
                    result.append("Student ID: " + studentID + "\n");
                    result.append("Current Courses: " + currentCourses + "\n");
                    result.append("Previous Courses: " + prevcourses + "\n");
                    result.append("\n");
                }
                if (validityChecker == false) {
                    result.append("Student ID not found in the database\n");
                }
            } else {
                result.append("Failed to connect to the database\n");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
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
            }
        }
        return result.toString();
    }

    public String searchDepartment(String Department_id) {
        Connection connection = null;
        Statement statement = null;
        StringBuilder result = new StringBuilder();

        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            connection = DriverManager.getConnection(dbURL);

            if (connection != null) {
                result.append("ALL Departments\n");

                statement = connection.createStatement();
                // Construct the SQL query to get course information by course ID
            int DepartmentID;
                try {
                // Try to parse the input as an integer
                DepartmentID = Integer.parseInt(Department_id);
            } catch (NumberFormatException e) {
                // Handle the case where input is not a valid integer
                JOptionPane.showMessageDialog(null, "Invalid Department ID. Please enter a valid integer.", "Error", JOptionPane.ERROR_MESSAGE);
                return result.toString();
            }
                String query = "SELECT Department_id, Department_name, Department_head "
                        + "FROM DepartmentInfo "
                        + "WHERE Department_id = " + Department_id;

                ResultSet resultSet = statement.executeQuery(query);

                while (resultSet.next()) {
                    validityChecker = true;
                    String Department_ID = resultSet.getString("Department_id");
                    String DepartName = resultSet.getString("Department_name");
                    String DepartHead = resultSet.getString("Department_head");
                    result.append("Department ID: " + DepartmentID + "\n");
                    result.append("Department Name: " + DepartName + "\n");
                    result.append("Previous Courses: " + DepartHead + "\n");
                    result.append("\n");
                }
                if (validityChecker == false) {
                    result.append("Department ID not found in the database\n");
                }
            } else {
                result.append("Failed to connect to the database\n");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
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
            }
        }
        return result.toString();
    }

    public String searchTeacher(String Teacher_id) {
        Connection connection = null;
        Statement statement = null;
        StringBuilder result = new StringBuilder();

        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            connection = DriverManager.getConnection(dbURL);

            if (connection != null) {
                result.append("ALL Teachers\n");

                statement = connection.createStatement();
                // Construct the SQL query to get course information by course ID
                int TeacherID;
                try {
                // Try to parse the input as an integer
                TeacherID = Integer.parseInt(Teacher_id);
            } catch (NumberFormatException e) {
                // Handle the case where input is not a valid integer
                JOptionPane.showMessageDialog(null, "Invalid Student ID. Please enter a valid integer.", "Error", JOptionPane.ERROR_MESSAGE);
                return result.toString();
            }
                String query = "SELECT Teacher_id, Age, Firstname, Lastname, Department_name, Subject_taught "
                        + "FROM TeachersInfo "
                        + "WHERE Teacher_id = " + Teacher_id;

                ResultSet resultSet = statement.executeQuery(query);

                while (resultSet.next()) {
                    validityChecker = true;
                    String Teacher_ID = resultSet.getString("Teacher_id");
                    String age = resultSet.getString("Age");
                    String teacherFN = resultSet.getString("FirstName");
                    String teacherLN = resultSet.getString("LastName");
                    String Departname = resultSet.getString("Department_name");
                    String SubjectN = resultSet.getString("Subject_taught");
                    result.append("Teacher ID: " + Teacher_ID + "\n");
                    result.append("Age: " + age + "\n");
                    result.append("FirstName: " + teacherFN + "\n");
                    result.append("LastName: " + teacherLN + "\n");
                    result.append("Department Name: " + Departname + "\n");
                    result.append("Subject Taught: " + SubjectN + "\n");
                    result.append("\n");
                }
                if (validityChecker == false) {
                    result.append("Teacher ID not found in the database\n");
                }
            } else {
                result.append("Failed to connect to the database\n");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
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
            }
        }
        return result.toString();
    }

    public String searchActivity(String Student_id) {
        Connection connection = null;
        Statement statement = null;
        StringBuilder result = new StringBuilder();

        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            connection = DriverManager.getConnection(dbURL);

            if (connection != null) {
                result.append("ALL ExtraCurricular\n");

                statement = connection.createStatement();
                // Construct the SQL query to get course information by course ID
                int StudentID;
                try {
                // Try to parse the input as an integer
                StudentID = Integer.parseInt(Student_id);
            } catch (NumberFormatException e) {
                // Handle the case where input is not a valid integer
                JOptionPane.showMessageDialog(null, "Invalid Student ID. Please enter a valid integer.", "Error", JOptionPane.ERROR_MESSAGE);
                return result.toString();
            }
                String query = "SELECT Student_id, Activity "
                        + "FROM ExtracurricularActivities "
                        + "WHERE Student_id = " + Student_id;

                ResultSet resultSet = statement.executeQuery(query);

                while (resultSet.next()) {
                    validityChecker = true;
                    String Stud = resultSet.getString("Student_id");
                    String Active = resultSet.getString("Activity");
                    result.append("Student ID: " + Stud + "\n");
                    result.append("Activity: " + Active + "\n");
                    result.append("\n");
                }
                if (validityChecker == false) {
                    result.append("Teacher ID not found in the database\n");
                }
            } else {
                result.append("Failed to connect to the database\n");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
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
            }
        }
        return result.toString();
    }

    public String searchProgram(String Program_id) {
        Connection connection = null;
        Statement statement = null;
        StringBuilder result = new StringBuilder();

        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            connection = DriverManager.getConnection(dbURL);

            if (connection != null) {
                result.append("ALL Programs\n");

                statement = connection.createStatement();
                // Construct the SQL query to get course information by course ID
                int Programid;
                try {
                // Try to parse the input as an integer
                Programid = Integer.parseInt(Program_id);
            } catch (NumberFormatException e) {
                // Handle the case where input is not a valid integer
                JOptionPane.showMessageDialog(null, "Invalid Program ID. Please enter a valid integer.", "Error", JOptionPane.ERROR_MESSAGE);
                return result.toString();
            }
                
                String query = "SELECT Program_id, Department_id, program_name "
                        + "FROM Programs "
                        + "WHERE Program_id = " + Program_id;

                ResultSet resultSet = statement.executeQuery(query);

                while (resultSet.next()) {
                    validityChecker = true;
                    String progid = resultSet.getString("Program_id");
                    String DepID = resultSet.getString("Department_id");
                    String progname = resultSet.getString("program_name");
                    result.append("Program ID: " + progid + "\n");
                    result.append("Department ID: " + DepID + "\n");
                    result.append("Program Name: " + progname + "\n");
                    result.append("\n");
                }
                if (validityChecker == false) {
                    result.append("Program ID not found in the database\n");
                }
            } else {
                result.append("Failed to connect to the database\n");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
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
            }
        }
        return result.toString();
    }

    public String searchStudentDetails(String ID) {
        Connection connection = null;
        Statement statement = null;
        StringBuilder result = new StringBuilder();

        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            connection = DriverManager.getConnection(dbURL);

            if (connection != null) {
                result.append("ALL Students Details\n");

                statement = connection.createStatement();
                // Construct the SQL query to get course information by course ID
                int studentId;
            try {
                // Try to parse the input as an integer
                studentId = Integer.parseInt(ID);
            } catch (NumberFormatException e) {
                // Handle the case where input is not a valid integer
                JOptionPane.showMessageDialog(null, "Invalid Student ID. Please enter a valid integer.", "Error", JOptionPane.ERROR_MESSAGE);
                return result.toString();
            }
                String query = "SELECT ID, Age, FirstName, LastName, PhoneNumber, PostCode "
                        + "FROM StudentInfo "
                        + "WHERE ID = " + ID;

                ResultSet resultSet = statement.executeQuery(query);

                while (resultSet.next()) {
                    validityChecker = true;
                    String studentID = resultSet.getString("ID");
                    String age = resultSet.getString("Age");
                    String FN = resultSet.getString("FirstName");
                    String LN = resultSet.getString("LastName");
                    String PN = resultSet.getString("PhoneNumber");
                    String PC = resultSet.getString("PostCode");
                    result.append("Student ID: " + studentID + "\n");
                    result.append("Student Age: " + age + "\n");
                    result.append("First Name: " + FN + "\n");
                    result.append("Last Name: " + LN + "\n");
                    result.append("Phone Number: " + PN + "\n");
                    result.append("Post Code: " + PC + "\n");
                    result.append("\n");
                }
                if (validityChecker == false) {
                    result.append("Student ID not found in the database\n");
                }
            } else {
                result.append("Failed to connect to the database\n");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
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
            }
        }
        return result.toString();
    }

    public String searchStudentGrades(String Student_ID) {
        Connection connection = null;
        Statement statement = null;
        StringBuilder result = new StringBuilder();

        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            connection = DriverManager.getConnection(dbURL);

            if (connection != null) {
                result.append("Students Grades\n");

                statement = connection.createStatement();
                // Construct the SQL query to get course information by course ID
                
            int studentId;
            try {
                // Try to parse the input as an integer
                studentId = Integer.parseInt(Student_ID);
            } catch (NumberFormatException e) {
                // Handle the case where input is not a valid integer
                JOptionPane.showMessageDialog(null, "Invalid Student ID. Please enter a valid integer.", "Error", JOptionPane.ERROR_MESSAGE);
                return result.toString();
            }
                
                
                String query = "SELECT Student_ID, course_name, grade "
                        + "FROM studentGrades "
                        + "WHERE Student_ID = " + studentId;
                
                
                ResultSet resultSet = statement.executeQuery(query);
                

                while (resultSet.next()) {
                    validityChecker = true;
                    String studentID = resultSet.getString("Student_ID");
                    String coursename = resultSet.getString("course_name");
                    String grade = resultSet.getString("grade");
                    result.append("Student ID: " + studentID + "\n");
                    result.append("Course Code: " + coursename + "\n");
                    result.append("Grade: " + grade + "\n");

                    result.append("\n");
                }
                if (validityChecker == false) {
                    result.append("Student ID not found in the database\n");
                }
            } else {
                result.append("Failed to connect to the database\n");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
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
            }
        }
        return result.toString();
    }

}
