package com.raf.example.controller;

import com.raf.example.MainFrame;
import com.raf.example.dto.ReviewDto;
import com.raf.example.dto.ReviewsListDto;

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
                    .getReviews( str[0].split(":")[1].trim(), str[1].split(":")[1].trim() );

            List<ReviewDto> content = reviews.getContent();
            Object [][] data = new Object[50][50];
            int k=0;
            for (ReviewDto dto : content)
                data[k++] = new Object[]{dto.getReservationId(), dto.getClientId(), dto.getRating(), dto.getComment()};

            String[] header = {"Reservation id", "Client id", "Rating", "Comment"};
            JTable table = new JTable(data,header);

            JPanel panel = new JPanel(new BorderLayout());
            panel.add(table.getTableHeader(), BorderLayout.NORTH);
            panel.add(table, BorderLayout.CENTER);

            JDialog jDialog = new JDialog();
            jDialog.setSize(new Dimension(700, 500));
            jDialog.setLocationRelativeTo(MainFrame.getInstance());
            jDialog.add(panel);
            jDialog.setVisible(true);

        }catch (Exception exception){
            exception.printStackTrace();
            JOptionPane.showMessageDialog(null, "There could be no any review!", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
