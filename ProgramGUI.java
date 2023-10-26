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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class ProgramGUI implements ActionListener {

    private final JFrame ProgramFrame;
    private final JPanel ProgramHeaderPanel;
    private final JPanel centerPanel;
    private final JPanel westPanel;
    private final JLabel ProgramHeaderLabel;
    private final JLabel searchLabel;
    private final JButton backButton;
    private final JButton allProgramsButton;
    private final JButton searchButton;
    private final JTextField searchTextField;
    private final JTextArea displayTextArea;
    private final JScrollPane scrollPane;

    public ProgramGUI() {
        ProgramFrame = new JFrame();
        ProgramHeaderPanel = new JPanel();
        centerPanel = new JPanel();
        westPanel = new JPanel();
        ProgramHeaderLabel = new JLabel("PROGRAM MENU");
        searchLabel = new JLabel("Enter Program ID: ");
        backButton = new JButton("BACK");
        allProgramsButton = new JButton("Show All Programs");
        searchButton = new JButton("SEARCH");
        searchTextField = new JTextField(20);
        displayTextArea = new JTextArea(20, 40);
        scrollPane = new JScrollPane(displayTextArea);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        // Configure GUI elements and layout
        ProgramHeaderLabel.setFont(new Font("Arial", Font.BOLD, 26));
        ProgramHeaderPanel.setBounds(0, 0, 0, 0);
        ProgramHeaderPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        centerPanel.setBackground(Color.WHITE);
        displayTextArea.setEditable(false);

        // Set font for labels IN BUTTONS
        Font font = new Font("Arial", Font.BOLD, 16);
        searchLabel.setFont(font);
        searchTextField.setFont(font);
        searchButton.setFont(font);
        backButton.setFont(font);
        backButton.setForeground(Color.red);
        allProgramsButton.setFont(font);

        // Add components to panels
        centerPanel.add(searchLabel);
        centerPanel.add(searchTextField);
        centerPanel.add(searchButton);
        centerPanel.add(scrollPane);
        centerPanel.setBackground(Color.LIGHT_GRAY);
        

        //---------------------------------------------------------------------------------
        //Action listeners for buttons 
        searchButton.addActionListener(this);
        backButton.addActionListener(this);
        allProgramsButton.addActionListener(this);

        displayTextArea.setBackground(Color.WHITE);
        ProgramHeaderPanel.add(ProgramHeaderLabel);

        westPanel.add(backButton);
        westPanel.add(allProgramsButton);
        westPanel.setLayout(new GridLayout(3, 1));
        westPanel.setBackground(Color.LIGHT_GRAY);

        ProgramFrame.add(ProgramHeaderPanel, BorderLayout.NORTH);
        ProgramFrame.add(centerPanel, BorderLayout.CENTER);
        ProgramFrame.add(westPanel, BorderLayout.WEST);

        ProgramFrame.setBackground(Color.gray);
        ProgramFrame.setTitle("S.I.M.S");
        ProgramFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ProgramFrame.setSize(800, 600);
        ProgramFrame.setResizable(false);
        ProgramFrame.setLocation(300, 100);
        ProgramFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.backButton) {
            ProgramFrame.dispose(); // Close the DepartmentsGUI
            new MenuGUI();
        } else if (e.getSource() == this.searchButton) {
            //enter search logic from database
            String ProgramSearchText = searchTextField.getText();
            InfoSearch data = new InfoSearch();
            String displayProgram = data.searchProgram(ProgramSearchText);
            displayTextArea.setText(displayProgram);

        } else if (e.getSource() == this.allProgramsButton) {
            //enter logic to display from database
            dataRetrieval data = new dataRetrieval();
            String info = data.retrievePrograms();
            displayTextArea.append(info);
        }
    }

}
