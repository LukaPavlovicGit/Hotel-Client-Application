package com.raf.example.view;

import com.raf.example.MainFrame;
import com.raf.example.dto.HotelDto;

import javax.swing.*;

public class ManagerView extends JPanel {
    // add new hotel
    private JTextField newHotelCity = new JTextField("city");
    private JTextField newHotelName = new JTextField("hotel name");
    private JTextField newHotelDescription = new JTextField("description");
    private JButton addHotelBtn = new JButton("ADD");
    private JPanel panel1 = new JPanel();

    // update hotel
    private JTextField updateHotelCity = new JTextField("city");
    private JTextField updateHotelName = new JTextField("hotel name");
    private JTextField updateHotelDescription = new JTextField("description");
    private JButton updateHotelBtn = new JButton("UPDATE");
    private JPanel panel2 = new JPanel();

    public ManagerView(){
        addListeners();

        panel1.add(newHotelCity);
        panel1.add(newHotelName);
        panel1.add(newHotelDescription);
        panel1.add(addHotelBtn);

        panel2.add(updateHotelCity);
        panel2.add(updateHotelName);
        panel2.add(updateHotelDescription);
        panel2.add(updateHotelBtn);

        this.removeAll();
        this.add(panel1);
    }

    private void addListeners() {
        addHotelBtn.addActionListener(e -> {
            try {
                MainFrame.getInstance().getReservationService().addNewHotel(new HotelDto(newHotelCity.getText(), newHotelName.getText(), newHotelDescription.getText()));
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        });

    }
}
