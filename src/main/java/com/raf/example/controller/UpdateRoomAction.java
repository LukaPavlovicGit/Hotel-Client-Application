package com.raf.example.controller;

import com.raf.example.MainFrame;
import com.raf.example.dto.RoomDto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class UpdateRoomAction  implements ActionListener {
    private JTextArea ta;

    public UpdateRoomAction(JTextArea ta) {
        this.ta = ta;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String[] str = ta.getText().split("[\n]");
            MainFrame.getInstance().getReservationService()
                    .editRoom(new RoomDto(
                            Long.valueOf(str[0].split(":")[1].trim()),
                            Long.valueOf(str[1].split(":")[1].trim()),
                            Integer.valueOf(str[2].split(":")[1].trim()),
                            str[3].split(":")[1].trim()));
            JOptionPane.showMessageDialog(null, "Room updated successfully!", "Error", JOptionPane.INFORMATION_MESSAGE);

        }
        catch (IOException ioException) {
            JOptionPane.showMessageDialog(null, "Error while updating room!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
