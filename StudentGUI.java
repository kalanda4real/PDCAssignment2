/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment2gui;

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

/**
 *
 * @author martinkalanda
 */
public class StudentGUI implements ActionListener
{
    
    //Frame
    private final JFrame studentFrame;
    //Panels
    private final JPanel StudentNav;
    private final JPanel StudentHeaderPanel;
    //Labels
    private final JLabel studentHeaderLabel;
    //Buttons
    private final JButton CoursesButton;
    private final JButton GradesButton;
    private final JButton StudentDetailsButton;
    private final JButton backButton;
    
    public StudentGUI()
    {
        //Frame instances
        studentFrame = new JFrame();
        //Panel instance
        StudentNav = new JPanel();
        StudentHeaderPanel = new JPanel();
        
        //--------------------------------------------------------------------------------
        //Student Header panel setting
        StudentHeaderPanel.setBounds(0, 0, 0, 0);
        studentHeaderLabel = new JLabel("Student MENU");
        StudentHeaderPanel.add(studentHeaderLabel);
        StudentHeaderPanel.setBackground(Color.gray);
        
        Font mainHeaderFont = new Font("Arial", Font.BOLD, 26);
        studentHeaderLabel.setFont(mainHeaderFont);
        
        //--------------------------------------------------------------------------------
        //Navigation Button Names
        CoursesButton = new JButton("COURSES");
        GradesButton = new JButton("GRADES");
        StudentDetailsButton = new JButton("STUDENT DETAILS");
        backButton = new JButton("BACK");
        
        //--------------------------------------------------------------------------------
        //Student Navigation
        StudentNav.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        StudentNav.setLayout(new GridLayout(4,0));
        StudentNav.setBackground(Color.gray);
        StudentNav.add(CoursesButton);
        StudentNav.add(GradesButton);
        StudentNav.add(StudentDetailsButton);
        StudentNav.add(backButton);
       //--------------------------------------------------------------------------------
       //Button comsmetic settings
        CoursesButton.setForeground(Color.gray);
        GradesButton.setForeground(Color.gray);
        StudentDetailsButton.setForeground(Color.gray);
        backButton.setForeground(Color.gray);
        
        Font ButtonLooks = new Font("Arial", Font.BOLD, 20);
        CoursesButton.setFont(ButtonLooks);
        GradesButton.setFont(ButtonLooks);
        StudentDetailsButton.setFont(ButtonLooks);
        backButton.setFont(ButtonLooks);
        
        //--------------------------------------------------------------------------------
        //Frame Settings
        studentFrame.setBackground(Color.blue);
        studentFrame.add(StudentHeaderPanel, BorderLayout.NORTH);
        studentFrame.add(StudentNav, BorderLayout.CENTER);
        studentFrame.setTitle("S.I.M.S");
        studentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        studentFrame.setSize(600, 700);
        studentFrame.setResizable(false);
        studentFrame.setLocation(300, 100);
        studentFrame.setVisible(true);
        //--------------------------------------------------------------------------------
    }
    
    
    public static void main(String[] args)
    {
        new StudentGUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
