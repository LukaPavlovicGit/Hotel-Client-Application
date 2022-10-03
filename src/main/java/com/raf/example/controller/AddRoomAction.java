package com.raf.example.controller;

import com.raf.example.MainFrame;
import com.raf.example.dto.HotelDto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class AddRoomAction implements ActionListener {
    private JTextArea ta;

    public AddRoomAction(JTextArea ta) {
        this.ta = ta;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String[] str = ta.getText().split("[\n]");
            MainFrame.getInstance().getReservationService().addRoom( str[0].split(":")[1].trim(), str[1].split(":")[1].trim() );
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
