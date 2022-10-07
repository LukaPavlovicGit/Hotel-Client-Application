package com.raf.example.controller;

import com.raf.example.MainFrame;
import com.raf.example.dto.NotificationTypesListDto;
import com.raf.example.dto.NotificationTypeDto;
import com.raf.example.model.NotificationTypeTableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GetNotificationTypesAction implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            NotificationTypeTableModel tableModel = new NotificationTypeTableModel();
            JTable table;
            NotificationTypesListDto list = MainFrame.getInstance().getNotificationService().getAllNotificationTypes();
            List<NotificationTypeDto> content = list.getContent();

            for(NotificationTypeDto type : content)
                tableModel.addRow(new Object[]{type.getId(), type.getType(), type.getText()});

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
