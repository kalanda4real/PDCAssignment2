/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment2gui;

/**
 *
 * @author martinkalanda
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class dataRetrieval {

    String dbURL = "jdbc:derby://localhost:1527/Studentinformationmanagementsystem;user=PDC;password=pdc";

    public String retrieveStudentInfo() {
        String StudenetDetails = retrieveDataFromTable("StudentInfo", "id", "AGE", "FIRSTNAME", "LASTNAME", "PHONENUMBER", "POSTCODE");
        return StudenetDetails;
    }

    public String retrieveDepartmentInfo() {
        String departmentInfo = retrieveDataFromTable("DepartmentInfo", "department_id", "department_name", "department_head");
        return departmentInfo;
    }

    public String retrieveTeachersInfo() {
        String teacherinfo = retrieveDataFromTable("TeachersInfo", "teacher_id", "firstname", "lastname", "department_name", "subject_taught");
        return teacherinfo;
    }

    public String retrievePrograms() {
        String programinfo = retrieveDataFromTable("Programs", "program_id", "department_id", "program_name");
        return programinfo;
    }

    public String retrieveExtracurricularActivities() {
        String activities = retrieveDataFromTable("ExtracurricularActivities", "student_id", "activity");
        return activities;
    }

    public void retrieveStudentGrades() {
        retrieveDataFromTable("StudentGrades", "student_id", "course_name", "grade");
    }

    public String retrieveStudentCourses() {
        String courseInfo = retrieveDataFromTable("StudentCourses", "student_id", "current_courses", "previous_courses");

        return courseInfo;
    }

    public String retrieveDataFromTable(String tableName, String... columnNames) {
        Connection connection = null;
        Statement statement = null;
        StringBuilder result = new StringBuilder();

        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            connection = DriverManager.getConnection(dbURL);

            if (connection != null) {
                result.append(tableName + "\n");
                statement = connection.createStatement();
                String query = "SELECT * FROM " + tableName;
                ResultSet resultSet = statement.executeQuery(query);

                for (String columnName : columnNames) {
                    result.append(columnName).append("|       ");
                }
                result.append("\n");

                while (resultSet.next()) {
                    for (String columnName : columnNames) {
                        String value = resultSet.getString(columnName);
                        result.append(value).append(", ");
                    }
                    result.append("\n");
                }

                result.append("\n");
            } else {
                result.append("Failed to connect to the database\n");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();

        }
        return result.toString();
    }

}
