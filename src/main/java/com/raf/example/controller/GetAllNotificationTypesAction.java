package com.raf.example.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.raf.example.MainFrame;
import com.raf.example.dto.AllNotificationTypesListDto;
import com.raf.example.dto.EmailNotificationDto;
import com.raf.example.model.NotificationTypeTableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GetAllNotificationTypesAction implements ActionListener {
    private NotificationTypeTableModel tableModel = new NotificationTypeTableModel();
    private JTable table;
    private ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            AllNotificationTypesListDto list = MainFrame.getInstance().getNotificationService().getAllNotificationTypes();
            List<EmailNotificationDto> content = list.getContent();

            for(EmailNotificationDto type : content){
                tableModel.addRow(new Object[]{type.getId(), type.getType(), type.getText()});
            }

            table = new JTable(tableModel);
            JDialog jDialog = new JDialog();
            jDialog.setSize(new Dimension(1500, 500));
            jDialog.setLocationRelativeTo(MainFrame.getInstance());
            jDialog.add(table);
            jDialog.setVisible(true);


        }
        catch (Exception exception){
            JOptionPane.showMessageDialog(null, "Error while getting all notification types!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
