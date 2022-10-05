package com.raf.example.controller;

import com.raf.example.MainFrame;
import com.raf.example.dto.AvailableRoomsFilterDto;

import javax.swing.*;
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
            List list = MainFrame.getInstance().getReservationService()
                    .getAvailableRooms(new AvailableRoomsFilterDto(
                            str[0].split(":")[1].trim(),
                            str[1].split(":")[1].trim(),
                            LocalDate.parse(str[2].split(":")[1].trim()),
                            LocalDate.parse(str[3].split(":")[1].trim()),
                            str[4].split(":")[1].trim())  );

            JOptionPane.showMessageDialog(null, list);
        }
        catch (Exception exception) {
            JOptionPane.showMessageDialog(null, "Error while getting available rooms!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
