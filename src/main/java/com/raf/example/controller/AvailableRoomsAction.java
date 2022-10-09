package com.raf.example.controller;

import com.raf.example.MainFrame;
import com.raf.example.dto.AvailableRoomsFilterDto;
import com.raf.example.dto.AvailableRoomsListDto;
import com.raf.example.dto.RoomDto;
import com.raf.example.model.UserTableModel;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;

public class AvailableRoomsAction implements ActionListener {
    private JTextArea ta;

    public AvailableRoomsAction(JTextArea ta) {
        this.ta = ta;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String[] str = ta.getText().split("[\n]");

            AvailableRoomsListDto list = MainFrame.getInstance().getReservationService()
                    .getAvailableRooms(new AvailableRoomsFilterDto(
                            str[0].split(":")[1].trim(),
                            str[1].split(":")[1].trim(),
                            LocalDate.parse(str[2].split(":")[1].trim()),
                            LocalDate.parse(str[3].split(":")[1].trim()),
                            str[4].split(":")[1].trim())  );

            UserTableModel tableModel = new UserTableModel();
            List<RoomDto> content = list.getContent();
            Object [][] data = new Object[50][50];
            int k=0;
            for (RoomDto dto : content) {
                data[k++] = new Object[]{dto.getHotelId(), dto.getRoomNumber(), dto.getTypeName()};
                tableModel.addRow(new Object[]{dto.getHotelId(), dto.getRoomNumber(), dto.getTypeName()});
            }
            JTable table = new JTable(data, new String[]{"Hotel id", "room number", "Type"});

            JPanel panel = new JPanel();
            panel.add(table);

            JDialog jDialog = new JDialog();
            jDialog.setSize(new Dimension(800, 500));
            jDialog.setLocationRelativeTo(MainFrame.getInstance());
            jDialog.add(panel);
            jDialog.setVisible(true);
        }
        catch (Exception exception) {
            JOptionPane.showMessageDialog(null, "Error while getting available rooms!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
