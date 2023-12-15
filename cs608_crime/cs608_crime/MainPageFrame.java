/**
 * Created by: LINLAN CAI
 * Created on: 5:22:41 AM, Dec 14, 2023
 * File: MainPage.java
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

/**
 * 
 */
public class MainPageFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainPageFrame mainPage = new MainPageFrame();
                mainPage.setVisible(true);
            }
        });
	}
	/**
	 * Create the frame.
	 */
	public MainPageFrame() {
        setTitle("MainPage - LinlanCai");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600); // 设置窗口大小
        setLocationRelativeTo(null);

        JPanel buttonPanel = new JPanel(new GridLayout(3, 2, 10, 10)); // 3行2列的GridLayout
     
        // 添加按钮，点击后跳转到新页面
        JButton courtButton = new JButton("Court");
        courtButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	// 在此处添加跳转到CourtPage_01页面的代码
                dispose(); // 关闭当前窗口
                CourtPage_01 courtPage = new CourtPage_01();
                courtPage.setVisible(true); // 显示CourtPage_01页面
            }
        });
        
        JButton guardButton = new JButton("Guard");
        guardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //跳转到Guard页面
            	dispose(); // 关闭当前窗口
                GuardPage_03 guardPage = new GuardPage_03();
                guardPage.setVisible(true); // 显示GuardPage_03页面
            }
        });
        
        JButton crimeButton = new JButton("Crime Record");
        crimeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	// 在此处添加跳转到CrimePage_02页面的代码
                dispose(); // 关闭当前窗口
                CrimePage_02 crimePage = new CrimePage_02();
                crimePage.setVisible(true); // 显示CrimePage_02页面
            }
        });
        
        JButton judgeButton = new JButton("Judge");
        judgeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 在此处添加跳转到Judge页面的代码
            	dispose();
            	Judge_04 judgePage = new Judge_04();
            	judgePage.setVisible(true);
            }
        });
        
        JButton offenderButton = new JButton("Offender");
        offenderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	dispose(); // Close the current window
                Offender_05 offenderPage = new Offender_05();
                offenderPage.setVisible(true); // Display the Offender_05 page
            }
        });
        
        JButton punishmentButton = new JButton("Punishment");
        punishmentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	// Navigate to the Punishment_06 page here
                dispose(); // Close the current window
                Punishment_06 punishmentPage = new Punishment_06();
                punishmentPage.setVisible(true); // Display the Punishment_06 page
            }
        });
        
        JButton victimButton = new JButton("Victim");
        victimButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	dispose(); // Close the current window
            	Victim_07 victimPage = new Victim_07();
            	victimPage.setVisible(true);
            }
        });
        JButton prisonButton = new JButton("Prison");
        prisonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Navigate to the Prison_8 page here
                dispose(); // Close the current window
                Prison_08 prisonPage = new Prison_08();
                prisonPage.setVisible(true); // Display the Prison_8 page
            }
        });

        buttonPanel.add(courtButton);
        buttonPanel.add(crimeButton);
        buttonPanel.add(guardButton);
        buttonPanel.add(judgeButton);
        buttonPanel.add(offenderButton);
        buttonPanel.add(punishmentButton);
        buttonPanel.add(victimButton);
        buttonPanel.add(prisonButton);


        
        // 添加注销按钮
        JButton logoutButton = new JButton("Log Out");
        
        JPanel logoutPanel = new JPanel(new BorderLayout());
        logoutPanel.add(logoutButton, BorderLayout.EAST);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        mainPanel.add(logoutPanel, BorderLayout.NORTH);
        
        //slogan
        JLabel footerLabel = new JLabel("- Crime Management System - CS 608 -", JLabel.CENTER);
        footerLabel.setFont(new Font("Arial", Font.PLAIN, 12)); // 设置字体和大小
        mainPanel.add(footerLabel, BorderLayout.SOUTH);
        
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 关闭当前主页面，返回登录页面
                dispose();
                LoginFrame loginFrame = new LoginFrame();
                loginFrame.setVisible(true);
            }
        });

        add(mainPanel);
	}

}
