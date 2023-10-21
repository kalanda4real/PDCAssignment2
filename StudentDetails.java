/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment2gui;

/**
 *
 * @author martinkalanda
 */
import java.awt.BorderLayout;
import java.awt.Color;
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

public class StudentDetails implements ActionListener {
    private final JFrame studentFrame;
    private final JPanel navPanel;
    private final JPanel displayPanel;
    private final JPanel updatePanel;
    private final JPanel commitPanel;
    private final JLabel headerLabel;
    private final JLabel emailLabel;
    private final JLabel PNLabel;
    private final JLabel searchLabel;
    private final JButton backButton;
    private final JButton searchButton;
    private final JButton commitButton;
    private final JTextField studentNameField;
    private final JTextField emailField;
    private final JTextField phoneNumberField;
    private final JTextArea displayTextArea;

    public StudentDetails() {
        studentFrame = new JFrame();
        navPanel = new JPanel();
        displayPanel = new JPanel();
        updatePanel = new JPanel(new GridLayout(2, 1));
        commitPanel = new JPanel();
        headerLabel = new JLabel("STUDENT DETAILS MENU");
        emailLabel = new JLabel("Email: ");
        PNLabel = new JLabel("Phone Num: ");
        searchLabel = new JLabel("   SEARCH STUDENT ID:");
        backButton = new JButton("BACK");
        searchButton = new JButton("SEARCH");
        commitButton = new JButton("Commit");
        studentNameField = new JTextField(20);
        emailField = new JTextField(20);
        phoneNumberField = new JTextField(20);
        displayTextArea = new JTextArea(20, 40);

        // Configure GUI elements and layout
        headerLabel.setFont(new Font("Arial", Font.BOLD, 26));
        navPanel.setBounds(0, 0, 0, 0);
        navPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        displayPanel.setBackground(Color.WHITE);
        displayTextArea.setEditable(false);
        updatePanel.setLayout(new GridLayout(6, 1));
        

         // Add action listeners to buttons
        searchButton.addActionListener(this);
        backButton.addActionListener(this);
        commitButton.addActionListener(this);

        // Add components to panels
        updatePanel.add(backButton);
        navPanel.add(headerLabel);

        updatePanel.add(searchLabel);
        updatePanel.add(studentNameField);
        updatePanel.add(searchButton);
        commitPanel.add(emailLabel);
        commitPanel.add(emailField);
        commitPanel.add(PNLabel);
        commitPanel.add(phoneNumberField);
        commitPanel.add(commitButton);

        studentFrame.add(navPanel, BorderLayout.NORTH);
        studentFrame.add(updatePanel, BorderLayout.WEST);
        studentFrame.add(displayPanel, BorderLayout.CENTER);
        studentFrame.add(commitPanel, BorderLayout.SOUTH);

        studentFrame.setTitle("Student Details");
        studentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        studentFrame.setSize(800, 600);
        studentFrame.setResizable(false);
        studentFrame.setLocation(300, 100);
        studentFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            // Handle back button action
            studentFrame.dispose();
            new StudentGUI();
            
        } else if (e.getSource() == searchButton) {
            // Handle search button action (retrieve student details from database)
        } else if (e.getSource() == commitButton) {
            // Handle commit button action (update student details from database)
        }
    }

}

