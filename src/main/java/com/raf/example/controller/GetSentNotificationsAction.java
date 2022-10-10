package com.raf.example.controller;

import com.raf.example.MainFrame;
import com.raf.example.dto.SentNotificationDto;
import com.raf.example.dto.SentNotificationListDto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GetSentNotificationsAction implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            SentNotificationListDto sentNotificationListDto = MainFrame.getInstance().getNotificationService()
                    .getSentNotifications();
            List<SentNotificationDto> content = sentNotificationListDto.getContent();

            Object [][] data = new Object[50][50];
            int k=0;
            for(SentNotificationDto dto : content)
                data[k++] = new Object[]{dto.getEmail(), dto.getText(), dto.getType(), dto.getDateSent()};

            String[] header = {"Email", "Text", "Type", "Date"};
            JTable table = new JTable(data, header);

            JPanel panel = new JPanel(new BorderLayout());
            panel.add(table.getTableHeader(), BorderLayout.NORTH);
            panel.add(table, BorderLayout.CENTER);

            JDialog jDialog = new JDialog();
            jDialog.setSize(new Dimension(700, 500));
            jDialog.setLocationRelativeTo(MainFrame.getInstance());
            jDialog.add(panel);
            jDialog.setVisible(true);
        }
        catch (Exception exception){
            exception.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error while getting all notifications!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
