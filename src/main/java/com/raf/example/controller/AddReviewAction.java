package com.raf.example.controller;

import com.raf.example.MainFrame;
import com.raf.example.dto.ReviewDto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddReviewAction implements ActionListener {
    private JTextArea ta;

    public AddReviewAction(JTextArea ta) {
        this.ta = ta;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String[] str = ta.getText().split("[\n]");
            MainFrame.getInstance().getReservationService()
                    .addReview(new ReviewDto(
                            Long.valueOf(str[0].split(":")[1].trim()),
                            null,
                            Integer.valueOf(str[1].split(":")[1].trim()),
                            str[2].split(":")[1].trim()) );
        }catch (Exception exception){
            JOptionPane.showMessageDialog(
                    null,
                    "Error while adding review!\n" +
                            "Possible causes:\n" +
                            "-Reservation does not exist.\n" +
                            "-Client is making multiple reviews on a one single reservation.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
