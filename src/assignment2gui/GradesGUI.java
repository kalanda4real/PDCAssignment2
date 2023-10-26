/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment2gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JScrollPane;

public class GradesGUI implements ActionListener {

    // Frame
    private final JFrame GradeGUI;

    // Panels
    private final JPanel gradesHeaderNav;
    private final JPanel gradesNav;
    private final JPanel SearchPanel;
    private final JPanel displayPanel;
    private final JPanel editPanel;

    // Labels
    private final JLabel gradesHeaderLabel;
    private final JLabel searchLabel;

    // Buttons
    private final JButton searchButton;
    private final JButton backButton;
    private final JButton commitButton; // New button for committing changes

    // Search field
    private final JTextField StudnetID;

    // Display
    private final JTextArea GradeScreen;
    private final JTextField courseCodeField; // Text field for course code
    private final JTextField gradeField;      // Text field for grade
    private final JScrollPane scrollPane;

    public GradesGUI() {
        // Frame instances
        GradeGUI = new JFrame();
        // Panel instances
        gradesHeaderNav = new JPanel();
        gradesNav = new JPanel();
        SearchPanel = new JPanel(new GridLayout(2, 1));
        // Display
        GradeScreen = new JTextArea();
        scrollPane = new JScrollPane(GradeScreen);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        // Search field
        StudnetID = new JTextField();
        // Display panel
        displayPanel = new JPanel();
        // Edit panel
        editPanel = new JPanel();
        //search
        searchLabel = new JLabel("Enter Student ID:");

        // Course Header panel setting
        gradesHeaderNav.setBounds(0, 0, 0, 0);
        gradesHeaderLabel = new JLabel("GRADES MENU");
        gradesHeaderNav.add(gradesHeaderLabel);
        

        Font courseHeaderFont = new Font("Arial", Font.BOLD, 26);
        gradesHeaderLabel.setFont(courseHeaderFont);

        // Navigation Button Names
        searchButton = new JButton("SEARCH");
        backButton = new JButton("BACK");
        commitButton = new JButton("COMMIT"); // New button for committing changes

        // Student Navigation
        gradesNav.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        gradesNav.setLayout(new GridLayout(2, 0));
        gradesNav.setBackground(Color.LIGHT_GRAY);
        gradesNav.add(backButton);

        // Display Panel
        displayPanel.setPreferredSize(new Dimension(150, 200)); // Adjust the width and height as needed
        displayPanel.setLayout(new GridLayout(6, 0));
        displayPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        displayPanel.setBackground(Color.LIGHT_GRAY);

        GradeScreen.setBounds(10, 10, 10, 10);

        GradeScreen.setEditable(false);

        // Search panel
        SearchPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        SearchPanel.setLayout(new GridLayout(1, 1));
        SearchPanel.setBackground(Color.LIGHT_GRAY);
        SearchPanel.add(scrollPane);
        searchLabel.setForeground(Color.BLACK);

        // Display panel
        displayPanel.add(searchLabel);
        displayPanel.add(StudnetID);
        displayPanel.add(searchButton);

        // Edit panel
        //editPanel.setLayout(new GridLayout(1, 5)); // Two rows, two columns
        editPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        editPanel.setBackground(Color.LIGHT_GRAY);

        // Add labels and text fields for editing grades
        JLabel courseCodeLabel = new JLabel("Choose Course Code:");
        JLabel gradeLabel = new JLabel("New Grade:");
        courseCodeField = new JTextField(10);
        gradeField = new JTextField(10);
        courseCodeLabel.setForeground(Color.BLACK);
        gradeLabel.setForeground(Color.BLACK);
                

                
        editPanel.add(courseCodeLabel);
        editPanel.add(courseCodeField);
        editPanel.add(gradeLabel);
        editPanel.add(gradeField);
        editPanel.add(commitButton);

        // Button cosmetic settings
        searchButton.setForeground(Color.BLACK);
        backButton.setForeground(Color.RED);
        commitButton.setForeground(Color.BLACK);

        Font buttonFont = new Font("Arial", Font.BOLD, 20);
        searchButton.setFont(buttonFont);
        backButton.setFont(buttonFont);
        commitButton.setFont(buttonFont);

        // Action listeners for buttons
        searchButton.addActionListener(this);
        backButton.addActionListener(this);
        commitButton.addActionListener(this);

        // Frame Settings
        GradeGUI.add(gradesHeaderNav, BorderLayout.NORTH);
        GradeGUI.add(SearchPanel, BorderLayout.CENTER);
        GradeGUI.add(gradesNav, BorderLayout.WEST);
        GradeGUI.add(displayPanel, BorderLayout.EAST);
        GradeGUI.add(editPanel, BorderLayout.SOUTH); // Add the edit panel to the bottom

        GradeGUI.setBackground(Color.gray);
        GradeGUI.setTitle("S.I.M.S");
        GradeGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GradeGUI.setSize(800, 600);
        GradeGUI.setResizable(false);
        GradeGUI.setLocation(300, 100);
        GradeGUI.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            GradeGUI.dispose(); // Close the GradesGUI
            new StudentGUI();
        } else if (e.getSource() == searchButton) {
            //  search logic here
            String studentSearch = StudnetID.getText();
            InfoSearch data = new InfoSearch();
            String displayStudents = data.searchStudentGrades(studentSearch);
            GradeScreen.setText(displayStudents);
        } else if (e.getSource() == commitButton) {
            //  commit grade changes here
//            String courseSearchText = StudnetID.getText();
            String studentSearch = StudnetID.getText();
            String coursesSelect = courseCodeField.getText();
            String GradeSelect = gradeField.getText();
            UpdateStudentGrades update = new UpdateStudentGrades();
            String updateGrade = update.updateStudentGrade(studentSearch,coursesSelect,GradeSelect);
            GradeScreen.setText(updateGrade);
        }
    }

}
