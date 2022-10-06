package com.raf.example.controller;

import com.raf.example.MainFrame;
import com.raf.example.dto.HotelDto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateHotelAction  implements ActionListener {
    private JTextArea ta;

    public UpdateHotelAction(JTextArea ta) {
        this.ta = ta;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String[] str = ta.getText().split("[\n]");
            MainFrame.getInstance().getReservationService().updateHotel(new HotelDto(
                                                                    str[0].split(":")[1].trim(),
                                                                    str[1].split(":")[1].trim(),
                                                                    str[2].split(":")[1].trim()) );
            JOptionPane.showMessageDialog(null, "Hotel updated successfully!", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
        catch (Exception exception) {
            JOptionPane.showMessageDialog(null, "Error while updating hotel!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
