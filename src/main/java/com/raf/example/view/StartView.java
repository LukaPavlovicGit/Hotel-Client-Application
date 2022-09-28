package com.raf.example.view;

import com.raf.example.MainFrame;

import javax.swing.*;
import java.awt.*;

public class StartView extends JPanel {

    private JPanel panel = new JPanel();
    private JButton loginBtn = new JButton("Login");
    private JButton regClientBtn = new JButton("Register Client");
    private JButton regManagerBtn = new JButton("Register Manager");

    public StartView(){

        loginBtn.addActionListener((e) -> MainFrame.getInstance().showLogin());
        regClientBtn.addActionListener((e) -> MainFrame.getInstance().showRegisterClient());
        regManagerBtn.addActionListener((e)->MainFrame.getInstance().showRegisterManager());

        panel.add(loginBtn, BorderLayout.CENTER);
        panel.add(regClientBtn, BorderLayout.CENTER);
        panel.add(regManagerBtn, BorderLayout.CENTER);

        this.add(panel);
    }
}
