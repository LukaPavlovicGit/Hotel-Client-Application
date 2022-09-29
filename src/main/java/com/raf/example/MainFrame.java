package com.raf.example;

import com.raf.example.dto.UserDto;
import com.raf.example.resetClient.UserServiceRestClient;
import com.raf.example.view.LoginView;
import com.raf.example.view.RegisterClientView;
import com.raf.example.view.RegisterManagerView;
import com.raf.example.view.StartView;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private static MainFrame instance = null;
    private String token;
    private UserDto currentUser;
    private StartView startView;
    private RegisterClientView registerClientView;
    private RegisterManagerView registerManagerView;
    private LoginView loginView;
    private UserServiceRestClient userServiceRestClient;


    public static MainFrame getInstance() {
        if (instance == null) {
            instance = new MainFrame();
        }
        return instance;
    }
    private MainFrame(){
        this.setResizable(false);
        this.setPreferredSize(new Dimension(900, 700));
        this.setLocationRelativeTo(null);

        startView = new StartView();
        registerClientView = new RegisterClientView();
        registerManagerView = new RegisterManagerView();
        loginView = new LoginView();

        userServiceRestClient = new UserServiceRestClient();

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
    public void showRegisterClient() {
        this.getContentPane().setVisible(false);
        this.getContentPane().removeAll();
        this.getContentPane().add(registerClientView);
        this.getContentPane().setVisible(true);
    }

    public void showRegisterManager(){
        this.getContentPane().setVisible(false);
        this.getContentPane().removeAll();
        this.getContentPane().add(registerManagerView);
        this.getContentPane().setVisible(true);
    }

    public void showLogin() {
        this.getContentPane().setVisible(false);
        this.getContentPane().removeAll();
        this.getContentPane().add(loginView);
        this.getContentPane().setVisible(true);
    }

    public void showManagerView() {
    }

    public void showClientView() {
    }

    public void showAdminView() {
    }



    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserServiceRestClient getUserServiceRestClient() {
        return userServiceRestClient;
    }

    public void setCurrentUser(UserDto userDto) { this.currentUser = userDto; }

    public UserDto getCurrentUser() { return currentUser; }

    public void showForgotPasswordView() {
    }
}
