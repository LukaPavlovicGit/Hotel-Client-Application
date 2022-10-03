package com.raf.example.controller;

import com.raf.example.MainFrame;
import com.raf.example.dto.HotelDto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateHotelAction  implements ActionListener {
    private String text;

    public UpdateHotelAction(String text) {
        this.text = text;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String[] str = text.split("[\n]");
            MainFrame.getInstance().getReservationService().updateHotel(new HotelDto(str[0], str[1], str[2]));
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
