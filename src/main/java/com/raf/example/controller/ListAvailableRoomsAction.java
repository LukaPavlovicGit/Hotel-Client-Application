package com.raf.example.controller;

import com.raf.example.MainFrame;
import com.raf.example.dto.AvailableRoomsFilterDto;
import com.raf.example.dto.AvailableRoomsListDto;
import com.raf.example.dto.RoomDto;
import com.raf.example.model.UserTableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;

public class ListAvailableRoomsAction implements ActionListener {
    private JTextArea ta;

    public ListAvailableRoomsAction(JTextArea ta) {
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
            for (RoomDto dto : content)
                tableModel.addRow(new Object[]{dto.getHotelId(), dto.getRoomNumber(), dto.getType()});

            JTable table = new JTable(tableModel);;
            JDialog jDialog = new JDialog();
            jDialog.setSize(new Dimension(1500, 500));
            jDialog.setLocationRelativeTo(MainFrame.getInstance());
            jDialog.add(table);
            jDialog.setVisible(true);

        }
        catch (Exception exception) {
            JOptionPane.showMessageDialog(null, "Error while getting available rooms!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
