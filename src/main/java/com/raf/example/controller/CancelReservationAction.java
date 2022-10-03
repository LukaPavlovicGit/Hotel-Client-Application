package com.raf.example.controller;

import com.raf.example.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CancelReservationAction implements ActionListener {

    private JTextArea ta;

    public CancelReservationAction(JTextArea ta) {
        this.ta = ta;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String[] str = ta.getText().split("[\n]");
            MainFrame.getInstance().getReservationService().cancelReservation( str[0].split(":")[1].trim() );
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
