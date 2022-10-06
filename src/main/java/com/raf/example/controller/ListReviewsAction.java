package com.raf.example.controller;

import com.raf.example.MainFrame;
import com.raf.example.dto.ReservationDto;
import com.raf.example.dto.ReservationsListDto;
import com.raf.example.dto.ReviewDto;
import com.raf.example.dto.ReviewsListDto;
import com.raf.example.model.NotificationTableModel;
import com.raf.example.model.ReviewTableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ListReviewsAction implements ActionListener {
    private JTextArea ta;

    public ListReviewsAction(JTextArea ta) {
        this.ta = ta;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try { // String hotelName, String city
            String[] str = ta.getText().split("[\n]");
            ReviewsListDto reviews = MainFrame.getInstance().getReservationService()
                    .getAllReviews( str[0].split(":")[1].trim(), str[1].split(":")[1].trim() );

            List<ReviewDto> content = reviews.getContent();

            ReviewTableModel tableModel = new ReviewTableModel();
            for (ReviewDto dto : content)
                tableModel.addRow(new Object[]{dto.getReservationId(), dto.getClientId(), dto.getRating(), dto.getComment()});

            JTable table = new JTable(tableModel);
            JDialog jDialog = new JDialog();
            jDialog.setSize(new Dimension(1500, 500));
            jDialog.setLocationRelativeTo(MainFrame.getInstance());
            jDialog.add(table);
            jDialog.setVisible(true);

        }catch (Exception exception){
            JOptionPane.showMessageDialog(null, "Error while getting reviews!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
