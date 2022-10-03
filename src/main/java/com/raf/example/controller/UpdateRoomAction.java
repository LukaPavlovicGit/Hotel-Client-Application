package com.raf.example.controller;

import com.raf.example.MainFrame;
import com.raf.example.dto.RoomDto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class UpdateRoomAction  implements ActionListener {
    private String text;

    public UpdateRoomAction(String text) {
        this.text = text;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String[] str = text.split("[\n]");
            MainFrame.getInstance().getReservationService()
                    .editRoom(new RoomDto(Integer.valueOf(str[0].split(":")[1].trim()),str[1].split(":")[1].trim()));

        }
        catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
