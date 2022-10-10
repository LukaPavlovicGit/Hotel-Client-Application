package com.raf.example.controller;

import com.raf.example.MainFrame;
import com.raf.example.dto.NotificationTypesListDto;
import com.raf.example.dto.NotificationTypeDto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GetNotificationTypesAction implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            NotificationTypesListDto list = MainFrame.getInstance().getNotificationService().getAllNotificationTypes();
            List<NotificationTypeDto> content = list.getContent();

            Object [][] data = new Object[50][50];
            int k=0;
            for(NotificationTypeDto type : content)
                data[k++] = new Object[]{type.getId(), type.getType(), type.getText()};

            String[] header = {"Notification id", "Notification type", "Text"};
            JTable table = new JTable(data,header);

            JPanel panel = new JPanel(new BorderLayout());
            panel.add(table.getTableHeader(), BorderLayout.NORTH);
            panel.add(table, BorderLayout.CENTER);

            JDialog jDialog = new JDialog();
            jDialog.setSize(new Dimension(1200, 500));
            jDialog.setLocationRelativeTo(MainFrame.getInstance());
            jDialog.add(panel);
            jDialog.setVisible(true);

        }
        catch (Exception exception){
            JOptionPane.showMessageDialog(null, "Error while getting all notification types!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
