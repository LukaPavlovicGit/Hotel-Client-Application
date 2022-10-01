package com.raf.example.view;

import com.raf.example.MainFrame;
import com.raf.example.dto.HotelDto;
import com.raf.example.dto.ManagerDto;
import com.raf.example.dto.RoomDto;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.sql.Date;

public class ManagerView extends JPanel {

    private StringBuilder sb = new StringBuilder();
    private JTabbedPane tabs = new JTabbedPane(JTabbedPane.TOP);

    private JButton addHotelBtn = new JButton("ADD HOTEL");
    private JButton updateHotelBtn = new JButton("UPDATE HOTEL");
    private JButton addRoomBtn = new JButton("ADD ROOM");
    private JButton updateRoomBtn = new JButton("UPDATE ROOM");
    private JButton showReservations = new JButton("SHOW ALL");
    private JButton cancelReservation = new JButton("CANCEL RESERVATION");
    private JButton setRoomTypesBtn = new JButton("SET ROOM TYPES");                   //   NIJE IMPLEMENTIRANO
    private JButton listNotificationsSentToManagerBtn = new JButton("LIST NOTIFICATIONS");//   NIJE IMPLEMENTIRANO
    private JButton updateManagerBtn = new JButton("UPDATE MANAGER");
    private JButton getNotificationsBtn = new JButton("GET NOTIFICATIONS"); // NIJE ODRANJENO, OVO JE ZA ADMINA SAMO????

    private TextArea addHotelTa = new TextArea();
    private TextArea updateHotelTa = new TextArea();
    private TextArea addRoomTa = new TextArea();
    private TextArea updateRoomTa = new TextArea();
    private TextArea getAllReservationsTa = new TextArea();
    private TextArea cancelReservationTa = new TextArea();
    private TextArea updateUserTa = new TextArea();
    private TextArea getNotificationsTa = new TextArea();
    private TextArea setRoomTypesTa = new TextArea();
    public ManagerView(){
        addListeners();

        JPanel jContentPane = new JPanel();
        jContentPane.setLayout(null);

        JPanel northPanel = new JPanel();

        northPanel.setBounds(61, 11, 81, 140);
        northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.X_AXIS));
        jContentPane.add(northPanel);

        northPanel.add(listNotificationsSentToManagerBtn);
        northPanel.add(getNotificationsBtn);
        northPanel.add(showReservations);


        addNewTab("ADD HOTEL", setAddHotelTextArea(), addHotelBtn);
        addNewTab("UPDATE HOTEL", setUpdateHotelTa(), updateHotelBtn);
        addNewTab("ADD ROOM", setAddRoomTa(), addRoomBtn);
        addNewTab("UPDATE ROOM", setUpdateRoomTa(), updateRoomBtn);
        addNewTab("CANCEL RESERVATION", setCancelReservationTa(), cancelReservation);
        addNewTab("UPDATE MANAGER", setUpdateUserTa(), updateManagerBtn);
        addNewTab("ADD ROOM TYPES", setSetRoomTypesTa(), setRoomTypesBtn);

        this.setLayout(new BorderLayout());
        this.add("Center",tabs);

    }

    private void addListeners() {
        addHotelBtn.addActionListener(e -> {
            try {
                String[] str = addHotelTa.getText().split("[\n]");
                MainFrame.getInstance().getReservationService().addNewHotel(new HotelDto(str[0], str[1], str[2]));
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        updateHotelBtn.addActionListener(e -> {
            try {
                String[] str = updateHotelTa.getText().split("[\n]");
                MainFrame.getInstance().getReservationService().updateHotel(new HotelDto(str[0], str[1], str[2]));
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        addRoomBtn.addActionListener(e -> {
            try {
                String[] str = addRoomTa.getText().split("[\n]");
                MainFrame.getInstance().getReservationService()
                        .addRoom(str[0].split(":")[1].trim(), Integer.valueOf(str[1].split(":")[1].trim()));
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        updateRoomBtn.addActionListener(e -> {
            try {
                String[] str = addRoomTa.getText().split("[\n]");
                MainFrame.getInstance().getReservationService()
                        .editRoom(new RoomDto(Integer.valueOf(str[0].split(":")[1].trim()),str[1].split(":")[1].trim()));

            }
            catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        cancelReservation.addActionListener(e -> {
            try {
                String[] str = addRoomTa.getText().split("[\n]");
                MainFrame.getInstance().getReservationService().cancelReservation(str[0].split(":")[1].trim());
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        updateManagerBtn.addActionListener(e -> {
            try {
                String[] str = addRoomTa.getText().split("[\n]");
                ManagerDto managerDto = new ManagerDto(
                                            str[0].split(":")[1].trim(),
                                            str[1].split(":")[1].trim(),
                                            str[2].split(":")[1].trim(),
                                            str[3].split(":")[1].trim(),
                                            str[4].split(":")[1].trim(),
                                            Date.valueOf(str[4].split(":")[1].trim()),
                                            null,
                                            Date.valueOf(str[5].split(":")[1].trim())
                                         );

                MainFrame.getInstance().getUserService().updateManager(managerDto);
            }
            catch (Exception ex) {
                JOptionPane.showMessageDialog(
                        null, "Error while updating manager in managerView", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
    private void addNewTab(String tabName, TextArea ta, JButton button){
        JPanel pan = new JPanel();
        pan.setLayout(new BorderLayout());
        pan.add("Center", ta);
        pan.add("South", button);
        tabs.addTab(tabName, pan);
    }

    private TextArea setAddHotelTextArea(){
        sb.delete(0,sb.length());
        sb.append("city : \n");
        sb.append("hotel name : \n");
        sb.append("description : \n");
        addHotelTa.setText(sb.toString());
        return addHotelTa;
    }

    public TextArea setUpdateHotelTa(){
        sb.delete(0,sb.length());
        sb.append("city : \n");
        sb.append("hotel name : \n");
        sb.append("description : \n");
        updateHotelTa.setText(sb.toString());
        return updateHotelTa;
    }

    public TextArea setAddRoomTa(){
        sb.delete(0,sb.length());
        sb.append("room number : \n");
        sb.append("room type : \n");
        addRoomTa.setText(sb.toString());
        return addRoomTa;
    }
    public TextArea setUpdateRoomTa(){
        sb.delete(0,sb.length());
        sb.append("room number : \n");
        sb.append("room type : \n");
        sb.append("price : \n");
        updateRoomTa.setText(sb.toString());
        return updateRoomTa;
    }
    public TextArea setGetAllReservationsTa(){
        sb.delete(0,sb.length());
        sb.append("[ ]");
        getAllReservationsTa.setText(sb.toString());
        return getAllReservationsTa;
    }
    public TextArea setCancelReservationTa(){
        sb.delete(0,sb.length());
        sb.append("reservation id : \n");
        cancelReservationTa.setText(sb.toString());
        return cancelReservationTa;
    }
    public TextArea setUpdateUserTa(){
        sb.delete(0,sb.length());
        sb.append("username : \n");
        sb.append("fistName : \n");
        sb.append("lastName : \n");
        sb.append("email : \n");
        sb.append("phoneNumber : \n");
        sb.append("birthdate : \n");
        sb.append("hireDate : \n");
        updateUserTa.setText(sb.toString());
        return updateUserTa;
    }

    public TextArea setGetNotificationsTa(){
        sb.delete(0,sb.length());
        sb.append("[ ]");
        getNotificationsTa.setText(sb.toString());
        return getNotificationsTa;
    }

    public TextArea setSetRoomTypesTa(){
        sb.delete(0,sb.length());
        sb.append("YOU CAN ADD AS MANY AS YOU WANT ROOM TYPES FOR THE HOTEL! \n\n");
        sb.append("example:\n\n");
        sb.append("typeName: D, pricePerDay: 20.0\n");
        sb.append("typeName: C, pricePerDay: 40.0\n");
        sb.append("typeName: B, pricePerDay: 80.0\n");
        sb.append("typeName: A, pricePerDay: 150.0\n");
        sb.append("=================================\n");
        getNotificationsTa.setText(sb.toString());
        return getNotificationsTa;
    }
}
