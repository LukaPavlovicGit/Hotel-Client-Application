package com.raf.example.controller;

import com.raf.example.MainFrame;
import com.raf.example.dto.RoomTypeDto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteRoomTypeAction implements ActionListener {
    private JTextArea ta;

    public DeleteRoomTypeAction(JTextArea ta) {
        this.ta = ta;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            String[] str = ta.getText().split("[\n]");
            MainFrame.getInstance().getReservationService().deleteRoomType( str[0].split(":")[1].trim() );
        }catch(Exception exception){
            exception.printStackTrace();
        }
    }
}
