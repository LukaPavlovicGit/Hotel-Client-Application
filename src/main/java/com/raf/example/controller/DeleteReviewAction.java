package com.raf.example.controller;

import com.raf.example.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteReviewAction implements ActionListener {
    private JTextArea ta;

    public DeleteReviewAction(JTextArea ta) {
        this.ta = ta;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String[] str = ta.getText().split("[\n]");
            MainFrame.getInstance().getReservationService().deleteReview( str[0].split(":")[1].trim() );

        } catch(Exception exception){
            JOptionPane.showMessageDialog(null, "Error while deleting review!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
