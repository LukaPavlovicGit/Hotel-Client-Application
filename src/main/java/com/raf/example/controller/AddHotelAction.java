package com.raf.example.controller;

import com.raf.example.MainFrame;
import com.raf.example.dto.HotelDto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class AddHotelAction implements ActionListener {
    private String text;

    public AddHotelAction(String text) {
        this.text = text;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String[] str = text.split("[\n]");
            MainFrame.getInstance().getReservationService().addNewHotel(new HotelDto(
                    str[0].split(":")[1].trim(),
                    str[1].split(":")[1].trim(),
                    str[2].split(":")[1].trim()
            ));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

    }
}
