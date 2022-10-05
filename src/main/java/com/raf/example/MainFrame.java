package com.raf.example;

import com.raf.example.dto.UserDto;
import com.raf.example.rest.NotificationService;
import com.raf.example.rest.UserService;
import com.raf.example.rest.ReservationService;
import com.raf.example.view.*;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private static MainFrame instance = null;
    private String token; // "eyJhbGciOiJIUzUxMiJ9.eyJpZCI6MSwicm9sZSI6IlJPTEVfQURNSU4iLCJlbWFpbCI6ImFkbWluQGdtYWlsLmNvbSJ9.vXa85a1bQXs7DWdYjyDedSo3iKFwIBuIMDV3JwqB-iol7wc5iCDQzywzb7Uyev3Te5nVeTmDR8wZyymlDv4xTA"
    private UserDto currentUser;
    private StartView startView;
    private RegisterClientView registerClientView;
    private RegisterManagerView registerManagerView;
    private LoginView loginView;
    private ManagerView managerView;
    private ClientView clientView;
    private AdminView adminView;

    private UserService userService;
    private ReservationService reservationService;
    private NotificationService notificationService;


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
        managerView = new ManagerView();
        clientView = new ClientView();
        adminView = new AdminView();

        userService = new UserService();
        reservationService = new ReservationService();
        notificationService = new NotificationService();

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
        this.getContentPane().setVisible(false);
        this.getContentPane().removeAll();
        this.getContentPane().add(managerView);
        this.getContentPane().setVisible(true);
    }

    public void showClientView() {
        this.getContentPane().setVisible(false);
        this.getContentPane().removeAll();
        this.getContentPane().add(clientView);
        this.getContentPane().setVisible(true);
    }

    public void showAdminView() {
        this.getContentPane().setVisible(false);
        this.getContentPane().removeAll();
        this.getContentPane().add(adminView);
        this.getContentPane().setVisible(true);
    }



    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setCurrentUser(UserDto userDto) { this.currentUser = userDto; }

    public UserDto getCurrentUser() { return currentUser; }

    public void showForgotPasswordView() {
    }

    public UserService getUserService() {
        return userService;
    }

    public ReservationService getReservationService() {
        return reservationService;
    }

    public NotificationService getNotificationService() {
        return notificationService;
    }
}
