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
                            Integer.valueOf(str[1].split(":")[1].trim()),
                            str[2].split(":")[1].trim()) );
        }catch (Exception exception){
            exception.printStackTrace();
            JOptionPane.showMessageDialog(
                    null,
                    "Error while adding review!\nPossible causes:\n-Reservation does not exist\n",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
