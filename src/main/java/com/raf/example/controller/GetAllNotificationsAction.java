package com.raf.example.controller;

import com.raf.example.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GetAllNotificationsAction implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            List list = MainFrame.getInstance().getNotificationService()
                    .getAllNotifications();
            JOptionPane.showMessageDialog(null, list);
        }
        catch (Exception exception){
            exception.printStackTrace();
        }
    }
}
