package com.raf.example.controller;

import com.raf.example.MainFrame;
import com.raf.example.dto.BestHotelsListDto;
import com.raf.example.dto.HotelDto;
import com.raf.example.dto.UserDto;
import com.raf.example.model.UserTableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

public class ListBestHotelsAction implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            BestHotelsListDto list = MainFrame.getInstance().getReservationService().getTopRatedHotels();
            List<HotelDto> content = list.getContent();

            UserTableModel tableModel = new UserTableModel();
            for (HotelDto dto : content)
                tableModel.addRow(new Object[]{dto.getCity(), dto.getName(), dto.getDescription()});

            JTable table = new JTable(tableModel);
            JDialog jDialog = new JDialog();
            jDialog.setSize(new Dimension(1500, 500));
            jDialog.setLocationRelativeTo(MainFrame.getInstance());
            jDialog.add(table);
            jDialog.setVisible(true);
        }
        catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error while getting best hotels!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
