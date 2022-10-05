package com.raf.example.controller;

import com.raf.example.MainFrame;
import com.raf.example.dto.RoomTypeDto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class AddRoomTypeAction implements ActionListener {
    private JTextArea ta;

    public AddRoomTypeAction(JTextArea ta) {
        this.ta = ta;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            String[] str = ta.getText().split("[\n]");
            MainFrame.getInstance().getReservationService().addRoomType(new RoomTypeDto(
                                                    str[0].split(":")[1].trim(),
                                                    Double.valueOf(str[1].split(":")[1].trim())) );
        }catch(Exception exception){
            JOptionPane.showMessageDialog(null, "Error while adding room type!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
