package com.raf.example.controller;

import com.raf.example.MainFrame;
import com.raf.example.dto.ReservationDto;
import com.raf.example.dto.ReservationsListDto;
import com.raf.example.model.SentNotificationTableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ListReservationsBtn implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            ReservationsListDto list = MainFrame.getInstance().getReservationService().getAllReservations();
            List<ReservationDto> content = list.getContent();

            SentNotificationTableModel tableModel = new SentNotificationTableModel();
            for (ReservationDto dto : content)
                tableModel.addRow(new Object[]{dto.getClientEmail(), dto.getStartDate(), dto.getEndDate(), dto.getPrice()});

            JTable table = new JTable(tableModel);
            JDialog jDialog = new JDialog();
            jDialog.setSize(new Dimension(1500, 500));
            jDialog.setLocationRelativeTo(MainFrame.getInstance());
            jDialog.add(table);
            jDialog.setVisible(true);
        }
        catch (Exception exception){
            JOptionPane.showMessageDialog(null, "Error while getting reservations!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
