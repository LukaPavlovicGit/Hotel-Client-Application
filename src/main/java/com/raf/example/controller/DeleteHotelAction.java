package com.raf.example.controller;

import com.raf.example.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteHotelAction implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            MainFrame.getInstance().getReservationService().deleteHotel();
        } catch (Exception exception){
            exception.printStackTrace();
        }
    }
}
