/**
 * Created by: LINLAN CAI
 * Created on: 2:59:13 PM, Nov 3, 2023
 * File: Frame2.java
 * 
 * Description: This file is subject to the terms and conditions of the MIT License.
 * See https://opensource.org/licenses/MIT for details.
 * Copyright (c) 2023 LINLAN CAI
 */
package package1;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 */
public class Frame2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame2 frame = new Frame2();
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
	public Frame2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(9, 2));
		getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("Crime ID:");
		lblNewLabel.setBounds(6, 27, 99, 16);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Crime Type:");
		lblNewLabel_1.setBounds(6, 68, 99, 16);
		getContentPane().add(lblNewLabel_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JLabel lblNewLabel_2 = new JLabel("Criminal ID:");
		lblNewLabel_2.setBounds(6, 109, 99, 16);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Victim ID:");
		lblNewLabel_3.setBounds(6, 150, 76, 16);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Crime Date:");//(yyyy-MM-dd)
		lblNewLabel_4.setBounds(6, 191, 88, 16);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Crime Time:");//HH:mm:ss
		lblNewLabel_5.setBounds(6, 232, 99, 16);
		getContentPane().add(lblNewLabel_5);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Weapon Used");
		chckbxNewCheckBox.setBounds(262, 23, 128, 23);
		getContentPane().add(chckbxNewCheckBox);
		
		JLabel lblNewLabel_6 = new JLabel("Weapon Type:");
		lblNewLabel_6.setBounds(224, 58, 99, 23);
		getContentPane().add(lblNewLabel_6);
		
		JButton btnNewButton = new JButton("Add Record");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(327, 237, 117, 29);
		getContentPane().add(btnNewButton);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(79, 22, 88, 23);
		getContentPane().add(formattedTextField);
		
		JFormattedTextField formattedTextField_1 = new JFormattedTextField();
		formattedTextField_1.setBounds(89, 63, 88, 23);
		getContentPane().add(formattedTextField_1);
		
		JFormattedTextField formattedTextField_2 = new JFormattedTextField();
		formattedTextField_2.setBounds(99, 104, 88, 23);
		getContentPane().add(formattedTextField_2);
		
		JFormattedTextField formattedTextField_3 = new JFormattedTextField();
		formattedTextField_3.setBounds(94, 145, 88, 23);
		getContentPane().add(formattedTextField_3);
		
		JFormattedTextField formattedTextField_4 = new JFormattedTextField();
		formattedTextField_4.setBounds(106, 186, 88, 23);
		getContentPane().add(formattedTextField_4);
		
		JFormattedTextField formattedTextField_5 = new JFormattedTextField();
		formattedTextField_5.setBounds(99, 227, 88, 23);
		getContentPane().add(formattedTextField_5);
		
		JFormattedTextField formattedTextField_6 = new JFormattedTextField();
		formattedTextField_6.setBounds(322, 61, 88, 23);
		getContentPane().add(formattedTextField_6);
	     
		
		
        
	}
}
