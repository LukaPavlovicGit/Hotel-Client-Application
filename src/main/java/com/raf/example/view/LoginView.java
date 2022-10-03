package com.raf.example.view;

import com.raf.example.MainFrame;
import com.raf.example.controller.BackAction;
import com.raf.example.controller.ChangePasswordAction;
import com.raf.example.controller.LonginAction;
import com.raf.example.dto.TokenRequestDto;
import com.raf.example.tokenDecoder.TokenDecoder;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class LoginView extends JPanel {
    private StringBuilder sb = new StringBuilder();
    private JTabbedPane tabs = new JTabbedPane(JTabbedPane.TOP);

    private JButton loginButton = new JButton("Login");
    private JButton changePasswordBtn = new JButton("Change password");
    private JButton  backBtn = new JButton("Back");

    private JTextArea loginTa = new JTextArea();
    private JTextArea changePasswordTa = new JTextArea();


    public LoginView(){
        loginButton.addActionListener(new LonginAction(loginTa));
        backBtn.addActionListener(new BackAction());
        changePasswordBtn.addActionListener(new ChangePasswordAction());

        JPanel jContentPane = new JPanel();
        jContentPane.setLayout(null);

        JPanel northPanel = new JPanel();

        northPanel.setBounds(61, 11, 81, 140);
        northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.X_AXIS));
        jContentPane.add(northPanel);

        northPanel.add(backBtn);
        northPanel.add(changePasswordBtn);

        addNewTab("LOGIN", setLoginTa(), loginButton);

        BorderLayout bl = new BorderLayout();
        bl.setHgap(20);
        bl.setVgap(20);
        this.setLayout(bl);
        this.add("North", northPanel);
        this.add("Center",tabs);
    }

    private void addNewTab(String tabName, JTextArea ta, JButton button){
        JPanel pan = new JPanel();
        pan.setLayout(new BorderLayout());
        pan.add("Center", ta);
        pan.add("South", button);
        tabs.addTab(tabName, pan);
    }

    private JTextArea setLoginTa(){
        sb.delete(0,sb.length());
        sb.append("username : \n");
        sb.append("password : \n");
        loginTa.setText(sb.toString());
        return loginTa;
    }
}
