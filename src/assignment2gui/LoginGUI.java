/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment2gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

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
    private final JButton Click;

    public LoginGUI() {
        //FRAME
        loginframe = new JFrame();

        //LABELS
        userLabel = new JLabel(" LOGIN: ");
        PWLabel = new JLabel(" PASSWORD: ");

        //TEXT FEILDS
        usernameField = new JTextField();
        passwordField = new JPasswordField();

        //BUTTON
        Click = new JButton("CONFIRM");

        // Create a panel for labels and fields
        JPanel inputPanel = new JPanel(new GridLayout(2, 2));
        inputPanel.add(userLabel);
        inputPanel.add(usernameField);
        inputPanel.add(PWLabel);
        inputPanel.add(passwordField);

        JPanel confirmPanel = new JPanel();
        confirmPanel.add(Click);
        loginframe.add(inputPanel, BorderLayout.CENTER);
        loginframe.add(confirmPanel, BorderLayout.SOUTH);

        //Frame settings
        loginframe.setBackground(Color.gray); //choose better color 
        loginframe.setTitle("S.I.M.S - Login");
        loginframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginframe.setSize(400, 200);
        loginframe.setLayout(new GridLayout(0, 1));
        loginframe.setResizable(false);
        loginframe.setLocation(450, 350);
        loginframe.setVisible(true);

        Click.addActionListener((ActionEvent e) -> {
            String usernameinput = usernameField.getText();
            String passwordinput = new String(passwordField.getPassword());

            if (isValidLogin(usernameinput, passwordinput)) {
                JOptionPane.showMessageDialog(loginframe, "Login successful!");
                DataBaseConnector database = new DataBaseConnector();
                database.getConnection();
                loginframe.dispose();
                new MenuGUI();
            } else if (usernameinput.isEmpty()) {
                JOptionPane.showMessageDialog(loginframe, "Login failed. Enter valid username.");

            } else if (passwordinput.isEmpty()) {
                JOptionPane.showMessageDialog(loginframe, "Login failed. Enter valid password.");
            } else {
                JOptionPane.showMessageDialog(loginframe, "Login failed. Please try again.");
            }
        });
    }

    private boolean isValidLogin(String username, String password) {
        return username.equals("PDC") && password.equals("pdc");
    }

    public static void main(String[] args) {
        new LoginGUI();//PROGRAM START     
    }

}
