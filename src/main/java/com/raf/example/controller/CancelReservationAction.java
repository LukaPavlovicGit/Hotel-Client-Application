package com.raf.example.controller;

import com.raf.example.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CancelReservationAction implements ActionListener {

    private String text;

    public CancelReservationAction(String text) {
        this.text = text;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String[] str = text.split("[\n]");
            MainFrame.getInstance().getReservationService().cancelReservation( str[0].split(":")[1].trim() );
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
