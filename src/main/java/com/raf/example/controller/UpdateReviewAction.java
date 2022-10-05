package com.raf.example.controller;

import com.raf.example.MainFrame;
import com.raf.example.dto.ReviewDto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateReviewAction implements ActionListener {
    private JTextArea ta;

    public UpdateReviewAction(JTextArea ta) {
        this.ta = ta;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String[] str = ta.getText().split("[\n]");
            MainFrame.getInstance().getReservationService()
                    .updateReview(str[0].split(":")[1].trim(), new ReviewDto(Long.valueOf(
                            str[1].split(":")[1].trim()),
                            Long.valueOf(str[2].split(":")[1].trim()),
                            Integer.valueOf(str[3].split(":")[1].trim()),
                            str[4].split(":")[1].trim()));
        } catch(Exception exception){
            JOptionPane.showMessageDialog(null, "Error while updating review!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
