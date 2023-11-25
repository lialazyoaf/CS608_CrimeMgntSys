/**
 * Created by: LINLAN CAI
 * Created on: 2:52:17 PM, Nov 3, 2023
 * File: J_frame1.java
 * 
 * Description: This file is subject to the terms and conditions of the MIT License.
 * See https://opensource.org/licenses/MIT for details.
 * Copyright (c) 2023 LINLAN CAI
 */
package package1;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 */
//... [package and imports]

public class Frame1_login extends JFrame {

 private static final long serialVersionUID = 1L;
 private JPanel contentPane;
 private JPasswordField passwordField;
 private JTextField usernameField;

 public static void main(String[] args) {
	 String url = "jdbc:mysql://localhost:3306/cs608CrimeSys";
     String username = "linlancai";
     String password = "cs608";

     EventQueue.invokeLater(new Runnable() {
         public void run() {
             try {
                 Frame1_login frame = new Frame1_login();
                 frame.setVisible(true);

					Connection connection = DriverManager.getConnection(url, username, password);
		            System.out.println("Connected to the database!");
		            // Perform database operations here
		            // Don't forget to close the connection when done
		            connection.close();
		            
             } catch (Exception e) {
                 e.printStackTrace();
             }
         }
     });
 }

public Frame1_login() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 450, 300);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    
    // Use GridBagLayout for precise control of components
    GridBagLayout gbl_contentPane = new GridBagLayout();
    contentPane.setLayout(gbl_contentPane);

    JLabel lblUsername = new JLabel("User Name");
    GridBagConstraints gbc_lblUsername = new GridBagConstraints();
    gbc_lblUsername.anchor = GridBagConstraints.EAST;
    gbc_lblUsername.insets = new Insets(0, 0, 5, 5);
    gbc_lblUsername.gridx = 0;
    gbc_lblUsername.gridy = 0;
    contentPane.add(lblUsername, gbc_lblUsername);

    usernameField = new JTextField();
    GridBagConstraints gbc_usernameField = new GridBagConstraints();
    gbc_usernameField.anchor = GridBagConstraints.WEST;
    gbc_usernameField.insets = new Insets(0, 0, 5, 0);
    gbc_usernameField.gridx = 1;
    gbc_usernameField.gridy = 0;
    contentPane.add(usernameField, gbc_usernameField);
    usernameField.setColumns(10);

    JLabel lblPassword = new JLabel("Password");
    GridBagConstraints gbc_lblPassword = new GridBagConstraints();
    gbc_lblPassword.anchor = GridBagConstraints.EAST;
    gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
    gbc_lblPassword.gridx = 0;
    gbc_lblPassword.gridy = 1;
    contentPane.add(lblPassword, gbc_lblPassword);

    passwordField = new JPasswordField();
    GridBagConstraints gbc_passwordField = new GridBagConstraints();
    gbc_passwordField.anchor = GridBagConstraints.WEST;
    gbc_passwordField.insets = new Insets(0, 0, 5, 0);
    gbc_passwordField.gridx = 1;
    gbc_passwordField.gridy = 1;
    contentPane.add(passwordField, gbc_passwordField);
    passwordField.setColumns(10);

    JButton btnLogin = new JButton("Log In");
    GridBagConstraints gbc_btnLogin = new GridBagConstraints();
    gbc_btnLogin.anchor = GridBagConstraints.CENTER;
    gbc_btnLogin.insets = new Insets(0, 0, 5, 5);
    gbc_btnLogin.gridx = 0;
    gbc_btnLogin.gridy = 2;
    gbc_btnLogin.gridwidth = 2; // Span across two columns
    contentPane.add(btnLogin, gbc_btnLogin);

    JTextPane textPane = new JTextPane();
    textPane.setText("CS 608 - Crime Record Management System");
    textPane.setOpaque(false);
    GridBagConstraints gbc_textPane = new GridBagConstraints();
    gbc_textPane.anchor = GridBagConstraints.SOUTH;
    gbc_textPane.gridx = 0;
    gbc_textPane.gridy = 3;
    gbc_textPane.gridwidth = 2; // Span across two columns
    gbc_textPane.insets = new Insets(0, 0, 0, 5);
    contentPane.add(textPane, gbc_textPane);

    
	}
}

