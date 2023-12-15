/**
 * Created by: LINLAN CAI
 * Created on: 5:05:48 PM, Dec 14, 2023
 * File: GuardPage_03.java
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
public class GuardPage_03 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuardPage_03 frame = new GuardPage_03();
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
	public GuardPage_03() {
		setTitle("Guard Page - LinlanCai");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel contentPanel = new JPanel(new BorderLayout());

        // 创建顶部面板
        JPanel topPanel = new JPanel(new BorderLayout());

        // 创建返回按钮
        JButton backButton = new JButton("Back");
        backButton.setPreferredSize(new Dimension(50, 20)); // 设置按钮大小
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 返回主页面
                dispose();
                MainPageFrame mainPage = new MainPageFrame();
                mainPage.setVisible(true);
            }
        });
        topPanel.add(backButton, BorderLayout.WEST);

        // 创建注销按钮
        JButton logoutButton = new JButton("LogOut");
        logoutButton.setPreferredSize(new Dimension(50, 20)); // 设置按钮大小
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 返回登录页面
                dispose();
                LoginFrame loginFrame = new LoginFrame();
                loginFrame.setVisible(true);
            }
        });
        topPanel.add(logoutButton, BorderLayout.EAST);

        contentPanel.add(topPanel, BorderLayout.NORTH);

        // 添加你的GuardPage_03页面内容，例如按钮和其他组件
        // 在这里添加你的GuardPage_03页面内容

        // 底部标签
        JLabel footerLabel = new JLabel("- Crime Management System - CS 608 -", JLabel.CENTER);
        footerLabel.setFont(new Font("Arial", Font.PLAIN, 12)); // 设置字体和大小
        contentPanel.add(footerLabel, BorderLayout.SOUTH);

        add(contentPanel);
	}

}
