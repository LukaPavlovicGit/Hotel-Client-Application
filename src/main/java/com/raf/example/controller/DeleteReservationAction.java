package com.raf.example.controller;

import com.raf.example.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteReservationAction implements ActionListener {

    private JTextArea ta;

    public DeleteReservationAction(JTextArea ta) {
        this.ta = ta;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String[] str = ta.getText().split("[\n]");
            MainFrame.getInstance().getReservationService().deleteReservation( str[0].split(":")[1].trim() );
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
