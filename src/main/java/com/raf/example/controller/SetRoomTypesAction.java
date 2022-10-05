package com.raf.example.controller;

import com.raf.example.MainFrame;
import com.raf.example.dto.RankDto;
import com.raf.example.dto.RoomTypeDto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class SetRoomTypesAction implements ActionListener {
    private JTextArea ta;

    public SetRoomTypesAction(JTextArea ta) {
        this.ta = ta;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            String s = ta.getText().split("[+]")[1];
            String[] str = s.split("#");
            List<RoomTypeDto> list = new ArrayList<>();
            for(String line : str) {
                list.add(new RoomTypeDto(
                        str[0].split(":")[1].trim(),
                        Double.valueOf(Integer.valueOf(str[1].split(":")[1].trim()))) );
            }
            MainFrame.getInstance().getReservationService().addAllRoomTypes(list);
        }
        catch(Exception exception){
            JOptionPane.showMessageDialog(null, "Error while setting room types!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
