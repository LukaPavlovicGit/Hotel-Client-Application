package com.raf.example.controller;

import com.raf.example.MainFrame;
import com.raf.example.dto.ClientCreateDto;
import com.raf.example.dto.ManagerCreateDto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

public class RegisterManagerAction implements ActionListener {
    private JTextArea ta;

    public RegisterManagerAction(JTextArea ta) {
        this.ta = ta;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {// String username, String password, String fistName, String lastName, String email, String phoneNumber, Date birthdate, Date hireDate
            String[] str = ta.getText().split("[\n]");
            MainFrame.getInstance().getUserService()
                    .registerManager( new ManagerCreateDto(
                            str[0].split(":")[1].trim(),
                            str[1].split(":")[1].trim(),
                            str[2].split(":")[1].trim(),
                            str[3].split(":")[1].trim(),
                            str[4].split(":")[1].trim(),
                            str[5].split(":")[1].trim(),
                            Date.valueOf(str[6].split(":")[1].trim()),
                            Date.valueOf(str[7].split(":")[1].trim())) );
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(
                    null, "Error while creating manager", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}