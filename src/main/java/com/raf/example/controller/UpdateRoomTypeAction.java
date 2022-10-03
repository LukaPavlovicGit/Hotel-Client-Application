package com.raf.example.controller;

import com.raf.example.MainFrame;
import com.raf.example.dto.RoomDto;
import com.raf.example.dto.RoomTypeDto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class UpdateRoomTypeAction implements ActionListener {
    private String text;

    public UpdateRoomTypeAction(String text) {
        this.text = text;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String[] str = text.split("[\n]");
            MainFrame.getInstance().getReservationService()
                    .updateRoomType( new RoomTypeDto(
                                        str[0].split(":")[1].trim(),
                                        Double.valueOf(str[1].split(":")[1].trim())) );

        }
        catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
