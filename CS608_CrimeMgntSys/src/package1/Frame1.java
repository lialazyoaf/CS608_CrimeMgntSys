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

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JFormattedTextField;

/**
 * 
 */
public class Frame1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField passwordField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame1 frame = new Frame1();
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
	public Frame1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Log In");
		btnNewButton.setBounds(183, 215, 83, 29);
		contentPane.add(btnNewButton);
		
		JTextPane txtpnCsCrime = new JTextPane();
		txtpnCsCrime.setBounds(86, 250, 278, 16);
		txtpnCsCrime.setText("CS 608 - Crime Record Management System");
		txtpnCsCrime.setOpaque(false);// Set the background color to transparent
		contentPane.add(txtpnCsCrime);
		
		JLabel lblNewLabel = new JLabel("User Name");
		lblNewLabel.setBounds(103, 117, 68, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password ");
		lblNewLabel_1.setBounds(103, 154, 63, 16);
		contentPane.add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(193, 149, 153, 26);
		contentPane.add(passwordField);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(193, 112, 153, 26);
		contentPane.add(formattedTextField);
	}
}
