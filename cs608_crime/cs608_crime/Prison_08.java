/**
 * Created by: LINLAN CAI
 * Created on: 6:03:22 PM, Dec 14, 2023
 * File: Prison_08.java
 * 
 * Description: This file is subject to the terms and conditions of the MIT License.
 * See https://opensource.org/licenses/MIT for details.
 * Copyright (c) 2023 LINLAN CAI
 */
package cs608_crime;

import java.awt.EventQueue;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * 
 */
public class Prison_08 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Prison_08 frame = new Prison_08();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public Prison_08() {
		setTitle("Prison Page - LinlanCai");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel contentPanel = new JPanel(new BorderLayout());

        // Create the top panel
        JPanel topPanel = new JPanel(new BorderLayout());

        // Create the Back button
        JButton backButton = new JButton("Back");
        backButton.setPreferredSize(new Dimension(50, 20)); // Set button size
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Go back to the main page
                dispose();
                MainPageFrame mainPage = new MainPageFrame();
                mainPage.setVisible(true);
            }
        });
        topPanel.add(backButton, BorderLayout.WEST);

        // Create the Log Out button
        JButton logoutButton = new JButton("LogOut");
        logoutButton.setPreferredSize(new Dimension(50, 20)); // Set button size
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Return to the login page
                dispose();
                LoginFrame loginFrame = new LoginFrame();
                loginFrame.setVisible(true);
            }
        });
        topPanel.add(logoutButton, BorderLayout.EAST);

        contentPanel.add(topPanel, BorderLayout.NORTH);

        // Add your Prison_8 page content, such as buttons and other components
        // Add your Prison_8 page content here

        // Footer label
        JLabel footerLabel = new JLabel("- Crime Management System - CS 608 -", JLabel.CENTER);
        footerLabel.setFont(new Font("Arial", Font.PLAIN, 12)); // Set font and size
        contentPanel.add(footerLabel, BorderLayout.SOUTH);

        add(contentPanel);
	}

}
