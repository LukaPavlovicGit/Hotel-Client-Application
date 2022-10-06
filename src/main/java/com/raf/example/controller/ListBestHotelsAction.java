package com.raf.example.controller;

import com.raf.example.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

public class ListBestHotelsAction implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            List list = MainFrame.getInstance().getReservationService().getTopRatedHotels();
            if(list.isEmpty())
                JOptionPane.showMessageDialog(null, "There are no hotels yet!","",JOptionPane.INFORMATION_MESSAGE);
            else
                JOptionPane.showMessageDialog(null, list);
        }
        catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error while getting best hotels!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
