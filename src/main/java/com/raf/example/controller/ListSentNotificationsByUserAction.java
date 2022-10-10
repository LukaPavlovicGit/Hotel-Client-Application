package com.raf.example.controller;

import com.raf.example.MainFrame;
import com.raf.example.dto.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ListSentNotificationsByUserAction implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            SentNotificationListDto list = MainFrame.getInstance().getNotificationService().getNotificationsByCurrentUserEmail();
            List<SentNotificationDto> content = list.getContent();

            Object [][] data = new Object[50][50];
            int k=0;
            for (SentNotificationDto dto : content)
                data[k++] = new Object[]{dto.getEmail(), dto.getText(), dto.getType(), dto.getDateSent()};

            String[] header = {"Email", "Text", "Type", "Date"};
            JTable table = new JTable(data,header);

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
            JOptionPane.showMessageDialog(null, "Error while getting all user's notifications!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
