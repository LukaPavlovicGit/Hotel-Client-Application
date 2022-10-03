package com.raf.example.controller;

import com.raf.example.MainFrame;
import com.raf.example.dto.UserDto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

public class UpdateAdminAction implements ActionListener {
    private JTextArea ta;

    public UpdateAdminAction(JTextArea ta) {
        this.ta = ta;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            String[] str = ta.getText().split("[\n]");
            MainFrame.getInstance().getUserService()
                    .updateAdmin( new UserDto(
                            str[0].split(":")[1].trim(),
                            str[1].split(":")[1].trim(),
                            str[2].split(":")[1].trim(),
                            str[3].split(":")[1].trim(),
                            str[4].split(":")[1].trim(),
                            Date.valueOf(str[5].split(":")[1].trim())) );
        }
        catch (Exception exception){
            exception.printStackTrace();
        }
    }
}
