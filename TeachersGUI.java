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

public class TeachersGUI implements ActionListener {

    private final JFrame teacherFrame;
    private final JPanel teacherHeaderPanel;
    private final JPanel centerPanel;
    private final JPanel westPanel;
    private final JLabel teacherHeaderLabel;
    private final JLabel searchLabel;
    private final JButton backButton;
    private final JButton allTeachersButton;
    private final JButton searchButton;
    private final JTextField searchTextField;
    private final JTextArea displayTextArea;

    public TeachersGUI() {
        teacherFrame = new JFrame();
        teacherHeaderPanel = new JPanel();
        centerPanel = new JPanel();
        westPanel = new JPanel();
        teacherHeaderLabel = new JLabel("TEACHER MENU");
        searchLabel = new JLabel("Enter Teacher ID: ");
        backButton = new JButton("BACK");
        allTeachersButton = new JButton("Show All Teachers");
        searchButton = new JButton("SEARCH");
        searchTextField = new JTextField(20);
        displayTextArea = new JTextArea(20, 40);

        // Configure GUI elements and layout
        teacherHeaderLabel.setFont(new Font("Arial", Font.BOLD, 26));
        teacherHeaderPanel.setBounds(0, 0, 0, 0);
        teacherHeaderPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        centerPanel.setBackground(Color.WHITE);
        displayTextArea.setEditable(false);

        // Set font for labels
        Font font = new Font("Arial", Font.BOLD, 16);
        searchLabel.setFont(font);
        searchTextField.setFont(font);
        searchButton.setFont(font);
        backButton.setFont(font);
        allTeachersButton.setFont(font);

        // Add components to panels
        centerPanel.add(searchLabel);
        centerPanel.add(searchTextField);
        centerPanel.add(searchButton);
        centerPanel.add(displayTextArea);

        //---------------------------------------------------------------------------------
        //Action listeners for buttons 
        searchButton.addActionListener(this);
        backButton.addActionListener(this);
        allTeachersButton.addActionListener(this);

        displayTextArea.setBackground(Color.WHITE);
        teacherHeaderPanel.add(teacherHeaderLabel);
        //PANEL COLOR
        centerPanel.setBackground(Color.LIGHT_GRAY);
        westPanel.setBackground(Color.LIGHT_GRAY);
        
        Font BUTTONFONT = new Font("Arial", Font.BOLD, 18);
        backButton.setFont(BUTTONFONT);
        allTeachersButton.setFont(BUTTONFONT);
        
        backButton.setForeground(Color.red);
        

        westPanel.add(backButton);
        westPanel.add(allTeachersButton);
        westPanel.setLayout(new GridLayout(3, 1));

        teacherFrame.add(teacherHeaderPanel, BorderLayout.NORTH);
        teacherFrame.add(centerPanel, BorderLayout.CENTER);
        teacherFrame.add(westPanel, BorderLayout.WEST);

        teacherFrame.setBackground(Color.gray);
        teacherFrame.setTitle("S.I.M.S - Teachers");
        teacherFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        teacherFrame.setSize(800, 600);
        teacherFrame.setResizable(false);
        teacherFrame.setLocation(300, 100);
        teacherFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.backButton) {
            teacherFrame.dispose(); // Close the DepartmentsGUI
            new MenuGUI();
        } else if (e.getSource() == this.searchButton) {
            //enter search logic from database
            String TeacherSearchtext = searchTextField.getText();
            InfoSearch data = new InfoSearch();
            String displayStudents = data.searchTeacher(TeacherSearchtext);
            displayTextArea.setText(displayStudents);

        } else if (e.getSource() == this.allTeachersButton) {
            //enter logic to display from database
            dataRetrieval data = new dataRetrieval();
            String info = data.retrieveTeachersInfo();
            displayTextArea.append(info);
        }
    }

}
