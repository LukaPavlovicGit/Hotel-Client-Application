package com.raf.example.controller;

import com.raf.example.MainFrame;
import com.raf.example.dto.BestHotelsListDto;
import com.raf.example.dto.HotelDto;

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

            Object [][] data = new Object[50][50];
            int k=0;
            for (HotelDto dto : content)
                data[k++] = new Object[]{dto.getCity(), dto.getName(), dto.getDescription()};

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
        catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error while getting best hotels!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
