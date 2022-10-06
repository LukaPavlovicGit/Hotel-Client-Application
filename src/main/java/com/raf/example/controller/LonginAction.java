package com.raf.example.controller;

import com.raf.example.MainFrame;
import com.raf.example.dto.TokenRequestDto;
import com.raf.example.tokenDecoder.TokenDecoder;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class LonginAction implements ActionListener {
    private JTextArea ta;

    public LonginAction(JTextArea ta) {
        this.ta = ta;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String[] str = ta.getText().split("[\n]");
            String token = MainFrame.getInstance().getUserService().login(new TokenRequestDto(
                                                                            str[0].split(":")[1].trim(),
                                                                            str[1].split(":")[1].trim())    );
            MainFrame.getInstance().setToken(token);
            MainFrame.getInstance().setCurrentUser(TokenDecoder.decodeToken(token));

            String role = MainFrame.getInstance().getCurrentUser().getRoleName();

            if (role.equals("ROLE_MANAGER"))
                MainFrame.getInstance().showManagerView();
            else if (role.equals("ROLE_CLIENT"))
                MainFrame.getInstance().showClientView();
            else if(role.equals("ROLE_ADMIN"))
                MainFrame.getInstance().showAdminView();

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Incorrect email or password", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}