package com.raf.example;

import com.raf.example.dto.UserDto;
import com.raf.example.view.StartView;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private static MainFrame instance = null;
    private String token;
    private UserDto currentUser;
    private StartView startView;


    public static MainFrame getInstance() {
        if (instance == null) {
            instance = new MainFrame();
            instance.initialize();
        }
        return instance;
    }
    private void initialize(){
        this.setResizable(false);
        this.setPreferredSize(new Dimension(900, 700));
        this.setLocationRelativeTo(null);

        startView = new StartView();

        this.setTitle("Client GUI application");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        this.setSize(toolkit.getScreenSize().width / 2, toolkit.getScreenSize().height / 2);
        this.setLocationRelativeTo(null);

        showMainView();
    }
    public void showMainView(){
        this.getContentPane().setVisible(false);
        this.getContentPane().removeAll();
        this.getContentPane().add(startView);
        this.getContentPane().setVisible(true);
    }

    public void showLogin() {
    }

    public void showRegisterClient() {
    }

    public void showRegisterManager() {
    }
}
