package com.raf.example.controller;

import com.raf.example.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListReviewsAction implements ActionListener {
    private JTextArea ta;

    public ListReviewsAction(JTextArea ta) {
        this.ta = ta;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try { // String hotelName, String city
            String[] str = ta.getText().split("[\n]");
            List reviews = (List) MainFrame.getInstance().getReservationService()
                    .getAllReviews( str[0].split(":")[1].trim(), str[1].split(":")[1].trim() );

            JOptionPane.showMessageDialog(null, reviews);
        }catch (Exception exception){
            JOptionPane.showMessageDialog(null, "Error while getting reviews!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
