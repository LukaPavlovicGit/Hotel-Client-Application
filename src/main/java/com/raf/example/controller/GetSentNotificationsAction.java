package com.raf.example.controller;

import com.raf.example.MainFrame;
import com.raf.example.dto.SentNotificationDto;
import com.raf.example.model.SentNotificationTableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GetSentNotificationsAction implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            List list = MainFrame.getInstance().getNotificationService()
                    .getSentNotifications();

            SentNotificationTableModel tableModel = new SentNotificationTableModel();
            List<SentNotificationDto> content = tableModel.getContent();
            for(SentNotificationDto dto : content)
                tableModel.addRow(new Object[]{dto.getEmail(), dto.getText(), dto.getType(), dto.getDateSent()});

            JTable table = new JTable(tableModel);;
            JDialog jDialog = new JDialog();
            jDialog.setSize(new Dimension(1500, 500));
            jDialog.setLocationRelativeTo(MainFrame.getInstance());
            jDialog.add(table);
            jDialog.setVisible(true);
        }
        catch (Exception exception){
            exception.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error while getting all notifications!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
