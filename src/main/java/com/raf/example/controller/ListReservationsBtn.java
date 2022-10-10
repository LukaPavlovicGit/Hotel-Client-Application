package com.raf.example.controller;

import com.raf.example.MainFrame;
import com.raf.example.dto.ReservationDto;
import com.raf.example.dto.ReservationsListDto;

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

            Object [][] data = new Object[50][50];
            int k=0;
            for (ReservationDto dto : content)
                data[k++] = new Object[]{dto.getClientEmail(), dto.getStartDate(), dto.getEndDate(), dto.getPrice()};

            String[] header = {"city", "name", "description"};
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
            JOptionPane.showMessageDialog(null, "Error while getting reservations!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
