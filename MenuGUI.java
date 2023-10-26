/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package assignment2gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author martinkalanda
 */
public class MenuGUI implements ActionListener {

    //Frame
    private final JFrame menuFrame;
    //Panels
    private final JPanel navPanel;
    private final JPanel headerPanel;
    //labels
    private final JLabel mainHeader;
    //Buttons
    private final JButton Studentbutton1;
    private final JButton Departmentbutton2;
    private final JButton Teachersbutton3;
    private final JButton Activitiesbutton4;
    private final JButton Programbutton4;

    public MenuGUI() {
        //Frameinstances
        menuFrame = new JFrame();
        //panel instances
        navPanel = new JPanel();
        headerPanel = new JPanel();

        //--------------------------------------------------------------------------------
        //Header Panel cosmetic settings
        headerPanel.setBounds(0, 0, 0, 100);
        mainHeader = new JLabel("S.I.M.S MAIN MENU");
        headerPanel.add(mainHeader);

        //Header Label settings 
        Font mainHeaderFont = new Font("Arial", Font.BOLD, 26);
        mainHeader.setFont(mainHeaderFont);

        //---------------------------------------------------------------------------------
        //Naviagtion Button names
        Studentbutton1 = new JButton("Open Student Menu");
        Departmentbutton2 = new JButton("Open Department Menu");
        Teachersbutton3 = new JButton("Open Teachers Menu");
        Activitiesbutton4 = new JButton("Activities Menu");
        Programbutton4 = new JButton("Program Menu");

        //Navigation Panel cosmetic settings
        navPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        navPanel.setLayout(new GridLayout(5, 0));
        navPanel.setBackground(Color.LIGHT_GRAY);
        navPanel.add(Studentbutton1);
        navPanel.add(Departmentbutton2);
        navPanel.add(Teachersbutton3);
        navPanel.add(Activitiesbutton4);
        navPanel.add(Programbutton4);

        //---------------------------------------------------------------------------------
        //Button cosmetic settings 
        Studentbutton1.setForeground(Color.black);
        Departmentbutton2.setForeground(Color.black);
        Teachersbutton3.setForeground(Color.black);
        Activitiesbutton4.setForeground(Color.black);
        Programbutton4.setForeground(Color.black);

        Font ButtonLooks = new Font("Arial", Font.PLAIN, 20);
        Studentbutton1.setFont(ButtonLooks);
        Departmentbutton2.setFont(ButtonLooks);
        Teachersbutton3.setFont(ButtonLooks);
        Activitiesbutton4.setFont(ButtonLooks);
        Programbutton4.setFont(ButtonLooks);

        //---------------------------------------------------------------------------------
        //Action listeners for buttons 
        Studentbutton1.addActionListener(this);
        Departmentbutton2.addActionListener(this);
        Teachersbutton3.addActionListener(this);
        Activitiesbutton4.addActionListener(this);
        Programbutton4.addActionListener(this);

        //---------------------------------------------------------------------------------
        //Frame settings
        menuFrame.setBackground(Color.gray); //choose better color 
        menuFrame.add(headerPanel, BorderLayout.NORTH);
        menuFrame.add(navPanel, BorderLayout.CENTER);
        menuFrame.setTitle("S.I.M.S");
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.setSize(600, 700);
        menuFrame.setResizable(false);
        menuFrame.setLocation(300, 100);
        menuFrame.setVisible(true);

        //---------------------------------------------------------------------------------
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.Studentbutton1) {
            menuFrame.dispose(); // Close the DepartmentsGUI
            new StudentGUI();
        } else if (e.getSource() == this.Departmentbutton2) {
            menuFrame.dispose();
            new DepartmentsGUI();
        } else if (e.getSource() == this.Teachersbutton3) {
            menuFrame.dispose();
            new TeachersGUI();
        } else if (e.getSource() == this.Activitiesbutton4) {
            menuFrame.dispose();
            new ExtraCurricularActivitiesGUI();
        } else if (e.getSource() == this.Programbutton4) {
            menuFrame.dispose();
            new ProgramGUI();
        }
    }

}
