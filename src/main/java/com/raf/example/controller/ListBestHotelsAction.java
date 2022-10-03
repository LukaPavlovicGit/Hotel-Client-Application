package com.raf.example.controller;

import com.raf.example.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ListBestHotelsAction implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            List list = (List) MainFrame.getInstance().getReservationService().getTopRatedHotels();
            JOptionPane.showMessageDialog(null, list);
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
