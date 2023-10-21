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

public class ExtraCurricularActivitiesGUI implements ActionListener {
    private final JFrame activitiesFrame;
    private final JPanel activitiesHeaderPanel;
    private final JPanel centerPanel;
    private final JPanel westPanel;
    private final JLabel activitiesHeaderLabel;
    private final JLabel searchLabel;
    private final JButton backButton;
    private final JButton displayAllButton;
    private final JTextField searchTextField;
    private final JButton searchButton;
    private final JTextArea displayTextArea;

    public ExtraCurricularActivitiesGUI() {
        activitiesFrame = new JFrame();
        activitiesHeaderPanel = new JPanel();
        centerPanel = new JPanel();
        westPanel = new JPanel();
        activitiesHeaderLabel = new JLabel("ExtraCurricular Activities");
        searchLabel = new JLabel("Search Activity: ");
        backButton = new JButton("BACK");
        displayAllButton = new JButton("DISPLAY ALL");
        searchTextField = new JTextField(20);
        searchButton = new JButton("SEARCH");
        displayTextArea = new JTextArea(20, 40);

        // Configure GUI elements and layout
        activitiesHeaderLabel.setFont(new Font("Arial", Font.BOLD, 26));
        activitiesHeaderPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        centerPanel.setBackground(Color.LIGHT_GRAY);
        westPanel.setBackground(Color.LIGHT_GRAY);
        displayTextArea.setEditable(false);

        // Set font for labels and buttons
        Font font = new Font("Arial", Font.BOLD, 16);
        searchTextField.setFont(font);
        searchButton.setFont(font);
        backButton.setFont(font);
        displayAllButton.setFont(font);

        // Add components to panels
        centerPanel.add(searchLabel);
        centerPanel.add(searchTextField);
        centerPanel.add(searchButton);
        centerPanel.add(displayTextArea);

        displayTextArea.setBackground(Color.WHITE);
        activitiesHeaderPanel.add(activitiesHeaderLabel);

        westPanel.add(backButton);
        westPanel.add(displayAllButton);
        westPanel.setLayout(new GridLayout(2, 1));

        activitiesFrame.add(activitiesHeaderPanel, BorderLayout.NORTH);
        activitiesFrame.add(centerPanel, BorderLayout.CENTER);
        activitiesFrame.add(westPanel, BorderLayout.WEST);

        activitiesFrame.setTitle("S.I.M.S");
        activitiesFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        activitiesFrame.setSize(800, 600);
        activitiesFrame.setResizable(false);
        activitiesFrame.setLocation(300, 100);
        activitiesFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle button clicks and actions here
    }

    public static void main(String[] args) {
        new ExtraCurricularActivitiesGUI();
    }
}

