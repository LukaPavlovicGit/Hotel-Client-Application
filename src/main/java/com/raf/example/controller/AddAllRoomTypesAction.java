package com.raf.example.controller;

import com.raf.example.MainFrame;
import com.raf.example.dto.RoomTypeDto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class AddAllRoomTypesAction implements ActionListener {
    private JTextArea ta;

    public AddAllRoomTypesAction(JTextArea ta) {
        this.ta = ta;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            String text = ta.getText().split("[+]")[1];
            String[] str = text.split("#");
            List<RoomTypeDto> list = new ArrayList<>();
            for(String line : str) {//String typeName, Double pricePerDay
                list.add(new RoomTypeDto(
                        str[0].split(":")[1].trim(),
                        Double.valueOf(str[1].split(":")[1].trim())) );
            }
            MainFrame.getInstance().getReservationService().addAllRoomTypes(list);

        }catch(Exception exception){
            exception.printStackTrace();
        }
    }
}
