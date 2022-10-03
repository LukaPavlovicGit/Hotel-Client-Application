package com.raf.example.controller;

import com.raf.example.MainFrame;
import com.raf.example.dto.ManagerDto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

public class UpdateManagerAction  implements ActionListener {
    private String text;

    public UpdateManagerAction(String text) {
        this.text = text;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String[] str = text.split("[\n]");
            MainFrame.getInstance().getUserService()
                    .updateManager(new ManagerDto(
                            str[0].split(":")[1].trim(),
                            str[1].split(":")[1].trim(),
                            str[2].split(":")[1].trim(),
                            str[3].split(":")[1].trim(),
                            str[4].split(":")[1].trim(),
                            Date.valueOf(str[5].split(":")[1].trim()),
                            null,
                            Date.valueOf(str[6].split(":")[1].trim())   ));
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(
                    null, "Error while updating manager in managerView", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
