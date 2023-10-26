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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

/**
 *
 * @author martinkalanda
 */
public class CourseGUI implements ActionListener {

    //Frame
    private final JFrame CoursesFrame;

    //Panels
    private final JPanel CourseHeader;
    private final JPanel CoruseNav;
    private final JPanel SearchPanel;
    private final JPanel centralPanel;

    //Lables
    private final JLabel courseHeaderLabel;
    private final JLabel searchLabel;
    private final JLabel DisplayLabel;

    //Buttons
    private final JButton searchButton;
    private final JButton backButton;
    private final JButton courseInfoButton;
    //Search feild
    private final JTextField CourseSearch;
    //Display
    private final JTextArea Displayscreen;
    private final JScrollPane scrollPane;

    public CourseGUI() {
        //Frame instances
        CoursesFrame = new JFrame();
        //Panel instances
        CourseHeader = new JPanel();
        CoruseNav = new JPanel();
        SearchPanel = new JPanel();
        centralPanel = new JPanel(new GridLayout(2, 1));
        //Display 
        Displayscreen = new JTextArea();
        scrollPane = new JScrollPane(Displayscreen);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        //--------------------------------------------------------------------------------
        //Course Header panel setting
        CourseHeader.setBounds(0, 0, 0, 0);
        courseHeaderLabel = new JLabel("Course MENU");
        searchLabel = new JLabel("   SEARCH COURSE ID: ");
        DisplayLabel = new JLabel("   COURSE INFO DISPLAY:");
        CourseHeader.add(courseHeaderLabel);

        Font LABELFONT = new Font("Arial", Font.BOLD, 20);
        Font courseHeaderFont = new Font("Arial", Font.BOLD, 26);
        courseHeaderLabel.setFont(courseHeaderFont);
        searchLabel.setFont(LABELFONT);

        //--------------------------------------------------------------------------------
        //Navigation Button Names
        searchButton = new JButton("SEARCH");
        backButton = new JButton("BACK");
        courseInfoButton = new JButton("COURSE INFO ");

        //--------------------------------------------------------------------------------
        //Student Navigation
        CoruseNav.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        CoruseNav.setLayout(new GridLayout(5, 0));
        CoruseNav.setBackground(Color.LIGHT_GRAY);

        CoruseNav.add(courseInfoButton);
        CoruseNav.add(backButton);

        //--------------------------------------------------------------------------------
        //Display Panel
        centralPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        centralPanel.add(SearchPanel);
        centralPanel.add(scrollPane);
        Displayscreen.setBackground(Color.WHITE);
        Displayscreen.setEditable(false);

        //--------------------------------------------------------------------------------
        //Search Panel
        SearchPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        SearchPanel.setLayout(new GridLayout(4, 0));
        SearchPanel.setBackground(Color.LIGHT_GRAY);
        SearchPanel.add(searchLabel);
        CourseSearch = new JTextField(1);
        SearchPanel.add(CourseSearch);
        SearchPanel.add(searchButton);
        SearchPanel.add(DisplayLabel);
        DisplayLabel.setFont(LABELFONT);

        //--------------------------------------------------------------------------------
        //Button comsmetic settings
        searchButton.setForeground(Color.BLACK);
        backButton.setForeground(Color.red);
        courseInfoButton.setForeground(Color.BLACK);

        Font ButtonLooks = new Font("Arial", Font.BOLD, 20);
        searchButton.setFont(ButtonLooks);
        backButton.setFont(ButtonLooks);
        courseInfoButton.setFont(ButtonLooks);

        //Action listeners for buttons 
        searchButton.addActionListener(this);
        backButton.addActionListener(this);
        courseInfoButton.addActionListener(this);
        //--------------------------------------------------------------------------------
        //Frame Settings
        CoursesFrame.setBackground(Color.gray);
        CoursesFrame.add(CourseHeader, BorderLayout.NORTH);
        CoursesFrame.add(CoruseNav, BorderLayout.WEST);
        CoursesFrame.add(centralPanel, BorderLayout.CENTER);
        CoursesFrame.setTitle("S.I.M.S");
        CoursesFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CoursesFrame.setSize(800, 600);
        CoursesFrame.setResizable(false);
        CoursesFrame.setLocation(300, 100);
        CoursesFrame.setVisible(true);
        //--------------------------------------------------------------------------------

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.searchButton) {
            //enter search logic here
            String courseSearchText = CourseSearch.getText();
            InfoSearch data = new InfoSearch();
            String displayStudents = data.searchStudentCourses(courseSearchText);
            Displayscreen.setText(displayStudents);
        } else if (e.getSource() == this.backButton) {
            CoursesFrame.dispose();
            new StudentGUI();
        } else if (e.getSource() == this.courseInfoButton) {
            //display all content 
            dataRetrieval data = new dataRetrieval();
            String info = data.retrieveStudentCourses();
            Displayscreen.append(info);
        }
    }

}
