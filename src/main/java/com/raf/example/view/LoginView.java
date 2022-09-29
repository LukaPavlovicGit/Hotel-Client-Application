package com.raf.example.view;

import com.raf.example.MainFrame;
import com.raf.example.dto.TokenRequestDto;
import com.raf.example.tokenDecoder.TokenDecoder;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class LoginView extends JPanel {
    private JTextField emailField = new JTextField("email", 14);
    private JPasswordField passwordField = new JPasswordField("password", 14);
    private JPanel panel = new JPanel();
    private JButton loginButton = new JButton("Login");
    private JOptionPane  optionPane = new JOptionPane();
    private JButton  backBtn = new JButton("Back");
    private JButton changePasswordBtn = new JButton("Change password");

    public LoginView(){
        addListeners();

        panel.add(emailField);
        panel.add(passwordField);
        this.add(panel, BorderLayout.CENTER);

        JPanel optionsPanel = new JPanel(new FlowLayout());
        optionsPanel.add(backBtn);
        optionsPanel.add(loginButton);
        optionsPanel.add(changePasswordBtn);
        this.add(optionsPanel, BorderLayout.SOUTH);
    }

    private void addListeners() {
        loginButton.addActionListener(e -> {//emailField.getText().toString(), String.valueOf(passwordField.getPassword())
            try {
                String token = MainFrame.getInstance().getUserServiceRestClient()
                        .login(new TokenRequestDto(emailField.getText().toString(), String.valueOf(passwordField.getPassword())));
                MainFrame.getInstance().setToken(token);
                System.out.println("token: " + token);

                MainFrame.getInstance().setCurrentUser(TokenDecoder.decodeToken(token));
                String role = MainFrame.getInstance().getCurrentUser().getRole();
                if (role.equals("ROLE_MANAGER"))
                    MainFrame.getInstance().showManagerView();
                else if (role.equals("ROLE_CLIENT"))
                    MainFrame.getInstance().showClientView();
                else
                    MainFrame.getInstance().showAdminView();

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Incorrect email or password", "Error", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        });

        backBtn.addActionListener((event)->{
            try{
                MainFrame.getInstance().showMainView();
            }catch (Exception e){
                e.printStackTrace();
            }
        });

        changePasswordBtn.addActionListener((event)->{
            try{
                MainFrame.getInstance().showForgotPasswordView();
            }catch (Exception e){
                e.printStackTrace();
            }
        });
    }
}
