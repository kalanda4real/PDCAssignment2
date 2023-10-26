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

public class DepartmentsGUI implements ActionListener {

    private final JFrame departmentFrame;
    private final JPanel departmentHeaderPanel;
    private final JPanel centerPanel;
    private final JPanel westPanel;
    private final JLabel departmentHeaderLabel;
    private final JLabel searchLabel;
    private final JButton backButton;
    private final JButton allDepartmentsButton;
    private final JButton searchButton;
    private final JTextField searchTextField;
    private final JTextArea displayTextArea;

    public DepartmentsGUI() {
        departmentFrame = new JFrame();
        departmentHeaderPanel = new JPanel();
        centerPanel = new JPanel();
        westPanel = new JPanel();
        departmentHeaderLabel = new JLabel("DEPARTMENT MENU");
        searchLabel = new JLabel("Enter Department Code: ");
        backButton = new JButton("BACK");
        allDepartmentsButton = new JButton("Show All Departments");
        searchButton = new JButton("SEARCH");
        searchTextField = new JTextField(20);
        displayTextArea = new JTextArea(20, 40);

        // Configure GUI elements and layout
        departmentHeaderLabel.setFont(new Font("Arial", Font.BOLD, 26));
        departmentHeaderPanel.setBounds(0, 0, 0, 0);
        departmentHeaderPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        centerPanel.setBackground(Color.WHITE);
        displayTextArea.setEditable(false);

        //set font for labels
        Font font = new Font("Arial", Font.BOLD, 16);
        searchLabel.setFont(font);
        searchTextField.setFont(font);
        searchButton.setFont(font);
        backButton.setFont(font);
        allDepartmentsButton.setFont(font);

        //Action listeners for buttons 
        searchButton.addActionListener(this);
        backButton.addActionListener(this);
        allDepartmentsButton.addActionListener(this);

        // Add components to panels
        centerPanel.add(searchLabel);
        centerPanel.add(searchTextField);
        centerPanel.add(searchButton);
        centerPanel.add(displayTextArea);

        displayTextArea.setBackground(Color.WHITE);
        departmentHeaderPanel.add(departmentHeaderLabel);

        westPanel.add(backButton);
        backButton.setForeground(Color.red);
        Font BUTTONFONT = new Font("Arial", Font.BOLD, 18);
        backButton.setFont(BUTTONFONT);
        westPanel.add(allDepartmentsButton);
        westPanel.setLayout(new GridLayout(3, 1));
        allDepartmentsButton.setFont(BUTTONFONT);
        
        centerPanel.setBackground(Color.LIGHT_GRAY);
        westPanel.setBackground(Color.LIGHT_GRAY);
        
        departmentFrame.add(departmentHeaderPanel, BorderLayout.NORTH);
        departmentFrame.add(centerPanel, BorderLayout.CENTER);
        departmentFrame.add(westPanel, BorderLayout.WEST);

        departmentFrame.setBackground(Color.gray);
        departmentFrame.setTitle("S.I.M.S");
        departmentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        departmentFrame.setSize(800, 600);
        departmentFrame.setResizable(false);
        departmentFrame.setLocation(300, 100);
        departmentFrame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.backButton) {
            departmentFrame.dispose(); // Close the DepartmentsGUI
            new MenuGUI();
        } else if (e.getSource() == this.allDepartmentsButton) {
            //input display logic  
            dataRetrieval data = new dataRetrieval();
            String info = data.retrieveDepartmentInfo();
            displayTextArea.append(info);
        } else if (e.getSource() == this.searchButton) {
            //input search logic
            String DepartmentSearch = searchTextField.getText();
            InfoSearch data = new InfoSearch();
            String displayStudents = data.searchDepartment(DepartmentSearch);
            displayTextArea.setText(displayStudents);
        }

    }
}
