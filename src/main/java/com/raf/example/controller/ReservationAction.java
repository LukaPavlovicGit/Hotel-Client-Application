package com.raf.example.controller;

import com.raf.example.MainFrame;
import com.raf.example.dto.ReservationDto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class ReservationAction implements ActionListener {
    private JTextArea ta;

    public ReservationAction(JTextArea ta) {
        this.ta = ta;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String[] str = ta.getText().split("[\n]");
            MainFrame.getInstance().getReservationService()
                    .createReservation(new ReservationDto(
                            Long.valueOf(str[0].split(":")[1].trim()),
                            LocalDate.parse(str[1].split(":")[1].trim()),
                            LocalDate.parse(str[2].split(":")[1].trim())));

        }catch (Exception exception){
            exception.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error while making reservation!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
