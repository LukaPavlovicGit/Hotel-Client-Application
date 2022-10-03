package com.raf.example.controller;

import com.raf.example.MainFrame;
import com.raf.example.dto.ClientCreateDto;
import com.raf.example.dto.ClientDto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

public class RegisterClientAction implements ActionListener {
    private JTextArea ta;

    public RegisterClientAction(JTextArea ta) {
        this.ta = ta;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {//String username, String password, String fistName, String lastName, String email, String phoneNumber, Date birthdate, String numOfPassport
            String[] str = ta.getText().split("[\n]");
            MainFrame.getInstance().getUserService()
                    .registerClient( new ClientCreateDto(
                            str[0].split(":")[1].trim(),
                            str[1].split(":")[1].trim(),
                            str[2].split(":")[1].trim(),
                            str[3].split(":")[1].trim(),
                            str[4].split(":")[1].trim(),
                            str[5].split(":")[1].trim(),
                            Date.valueOf(str[6].split(":")[1].trim()),
                            str[7].split(":")[1].trim()) );
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(
                    null, "Error while creating client", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
