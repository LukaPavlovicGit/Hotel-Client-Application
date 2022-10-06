package com.raf.example.controller;

import com.raf.example.MainFrame;
import com.raf.example.dto.EmailNotificationDto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateNotificationTypeAction implements ActionListener {
    private JTextArea ta;

    public UpdateNotificationTypeAction(JTextArea ta) {
        this.ta = ta;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            String[] str = ta.getText().split("[\n]");
            MainFrame.getInstance().getNotificationService()
                    .changeNotificationType(new EmailNotificationDto(
                            Long.valueOf(str[0].split(":")[1].trim()),
                            str[1].split(":")[1].trim(),
                            str[2].split(":")[1].trim()) );
            JOptionPane.showMessageDialog(null, "Notification type updated successfully!", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
        catch (Exception exception){
            JOptionPane.showMessageDialog(null, "Error while updating notification type!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
