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



/**
 *
 * @author martinkalanda
 */
public class GradesGUI implements ActionListener{
    
    //Frame
    private final JFrame GradeGUI;
    
    //Panels
    private final JPanel gradesHeaderNav;
    private final JPanel gradesNav;
    private final JPanel SearchPanel;
    private final JPanel displayPanel;
    
    //Labels
    private final JLabel gradesHeaderLabel;
    
    //buttons
    private final JButton searchButton;
    private final JButton backButton;
    
    
    //search feild
    private final JTextField GradeSearch;
    
    //Display
    private final JTextArea GradeScreen;
    
    public GradesGUI()
    {
        //Frame instances
     GradeGUI = new JFrame();
     //Panel instances
     gradesHeaderNav = new JPanel();
     gradesNav = new JPanel();
     SearchPanel = new JPanel(new GridLayout(2, 1));
     //Display 
     GradeScreen = new JTextArea();
     //search feild
     GradeSearch = new JTextField();
     //displayb panel
     displayPanel = new JPanel();
     
      //Course Header panel setting
     gradesHeaderNav.setBounds(0, 0, 0, 0);
     gradesHeaderLabel = new JLabel("GRADES MENU >> search for student ID");
     gradesHeaderNav.add(gradesHeaderLabel);
     gradesHeaderNav.setBackground(Color.gray);
     
     Font courseHeaderFont = new Font("Arial", Font.BOLD, 26);
     gradesHeaderLabel.setFont(courseHeaderFont);
     
     //Navigation Button Names
     searchButton = new JButton("SEARCH");
     backButton = new JButton("BACK");
     
     
     //--------------------------------------------------------------------------------
     //Student Navigation
     gradesNav.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
     gradesNav.setLayout(new GridLayout(2,0));
     gradesNav.setBackground(Color.gray);
     gradesNav.add(backButton);
     
     //--------------------------------------------------------------------------------
     //Display Panel
    displayPanel.setPreferredSize(new Dimension(150, 200)); // Adjust the width and height as needed
     displayPanel.setLayout(new GridLayout(2,0));
     displayPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
     displayPanel.setBackground(Color.gray);
    
//   SearchPanel.add(confirmButton);
     GradeScreen.setBounds(10, 10, 10, 10);
     GradeScreen.setEditable(false);
     
     //search panel
     SearchPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
     SearchPanel.setLayout(new GridLayout(2,0));
     SearchPanel.setBackground(Color.gray);
     SearchPanel.add(GradeSearch);
     
     SearchPanel.add(GradeScreen);
     
     //display panel
     displayPanel.add(searchButton);
     
    //--------------------------------------------------------------------------------
     //Button comsmetic settings
     searchButton.setForeground(Color.gray);
     backButton.setForeground(Color.gray);
        
     Font ButtonLooks = new Font("Arial", Font.BOLD, 20);
     searchButton.setFont(ButtonLooks);
     backButton.setFont(ButtonLooks);
     //---------------------------------------------------------------------------------
        //Action listeners for buttons 
        searchButton.addActionListener(this);
        backButton.addActionListener(this);
       
     //--------------------------------------------------------------------------------
        //Frame Settings
        GradeGUI.setBackground(Color.blue);
        GradeGUI.add(gradesHeaderNav, BorderLayout.NORTH);
        GradeGUI.add(SearchPanel, BorderLayout.CENTER);
        GradeGUI.add(gradesNav, BorderLayout.WEST);
        GradeGUI.add(displayPanel, BorderLayout.EAST);
        
        GradeGUI.setTitle("S.I.M.S");
        GradeGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GradeGUI.setSize(800, 600);
        GradeGUI.setResizable(false);
        GradeGUI.setLocation(300, 100);
        GradeGUI.setVisible(true);
     
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    if (e.getSource() == this.backButton) {
            GradeGUI.dispose(); // Close the DepartmentsGUI
            new StudentGUI(); 
        } else if (e.getSource() == this.searchButton) {
           //input search logic from database
        } 
    }
    
     public static void main(String[] args)
    {
        new GradesGUI();
    }
}
