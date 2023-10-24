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
import javax.swing.*;

/**
 *
 * @author martinkalanda
 */
public class LoginGUI {
    private final JFrame loginframe;
    private final JLabel userLabel;
    private final JLabel PWLabel;
    private final JTextField usernameField;
    private final JPasswordField passwordField;
    private final JButton LoginClick;
    
    public LoginGUI()
    {
        //FRAME
        loginframe = new JFrame();
        
        //LABELS
        userLabel = new JLabel(" LOGIN: ");
        PWLabel = new JLabel(" PASSWORD: ");
        
        //TEXT FEILDS
        usernameField = new JTextField();
        passwordField = new JPasswordField();
        
        //BUTTON
        LoginClick = new JButton("CONFIRM");
     
        
        // Create a panel for labels and fields
        JPanel inputPanel = new JPanel(new GridLayout(2, 2));
        inputPanel.add(userLabel);
        inputPanel.add(usernameField);
        inputPanel.add(PWLabel);
        inputPanel.add(passwordField);
        
        loginframe.add(inputPanel,BorderLayout.CENTER);
        loginframe.add(LoginClick, BorderLayout.SOUTH);
        
        //Frame settings
        loginframe.setBackground( Color.gray); //choose better color 
        loginframe.setTitle("S.I.M.S");
        loginframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginframe.setSize(400, 200);
        loginframe.setLayout(new GridLayout(0,1));
        loginframe.setResizable(false);
        loginframe.setLocation(450, 350);
        loginframe.setVisible(true);
        
    }
    
    public static void main(String[] args) {
         new LoginGUI();//PROGRAM START
         
    }
    
}
