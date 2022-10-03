package com.raf.example.view;

import com.raf.example.controller.*;

import javax.swing.*;
import java.awt.*;

public class ManagerView extends JPanel {

    private StringBuilder sb = new StringBuilder();
    private JTabbedPane tabs = new JTabbedPane(JTabbedPane.TOP);

    private JButton addHotelBtn = new JButton("ADD HOTEL");
    private JButton updateHotelBtn = new JButton("UPDATE HOTEL");
    private JButton addRoomBtn = new JButton("ADD ROOM");
    private JButton updateRoomBtn = new JButton("UPDATE ROOM");
    private JButton listReservations = new JButton("LIST ALL RESERVATIONS");
    private JButton cancelReservation = new JButton("CANCEL RESERVATION");
    private JButton listNotificationsBtn = new JButton("LIST NOTIFICATIONS"); // NIJE IMPLEMENTIRANO
    private JButton updateManagerBtn = new JButton("UPDATE MANAGER");
    private JButton getNotificationsBtn = new JButton("GET NOTIFICATIONS"); // NIJE ODRANJENO, OVO JE ZA ADMINA SAMO????
    private JButton addRoomTypesBtn = new JButton("SET ROOM TYPES"); // NIJE IMPLEMENTIRANO
    private JButton updateRoomTypeBtn = new JButton("UPDATE TYPE");

    private JTextArea addHotelTa = new JTextArea();
    private JTextArea updateHotelTa = new JTextArea();
    private JTextArea addRoomTa = new JTextArea();
    private JTextArea updateRoomTa = new JTextArea();
    private JTextArea getAllReservationsTa = new JTextArea();
    private JTextArea cancelReservationTa = new JTextArea();
    private JTextArea updateManagerTa = new JTextArea();
    private JTextArea listNotificationsTa = new JTextArea();
    private JTextArea setRoomTypesTa = new JTextArea();
    private JTextArea updateRoomTypeTa = new JTextArea();

    public ManagerView(){

        addHotelBtn.addActionListener(new AddHotelAction(addHotelTa));
        updateHotelBtn.addActionListener(new UpdateHotelAction(updateHotelTa));
        addRoomBtn.addActionListener(new AddRoomAction(addRoomTa));
        updateRoomBtn.addActionListener(new UpdateRoomAction(updateRoomTa));
        cancelReservation.addActionListener(new CancelReservationAction(cancelReservationTa));
        updateManagerBtn.addActionListener(new UpdateRoomTypeAction(updateHotelTa));
        updateRoomTypeBtn.addActionListener(new UpdateManagerAction(updateRoomTypeTa));
        listNotificationsBtn.addActionListener(new ListNotificationsAction());
        listReservations.addActionListener(new ListReservationsBtn());

        JPanel jContentPane = new JPanel();
        jContentPane.setLayout(null);

        JPanel northPanel = new JPanel();

        northPanel.setBounds(61, 11, 81, 140);
        northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.X_AXIS));
        jContentPane.add(northPanel);

        northPanel.add(listNotificationsBtn);
        northPanel.add(listReservations);

        addNewTab("ADD HOTEL", setAddHotelTextArea(), addHotelBtn);
        addNewTab("UPDATE HOTEL", setUpdateHotelTa(), updateHotelBtn);
        addNewTab("ADD ROOM", setAddRoomTa(), addRoomBtn);
        addNewTab("UPDATE ROOM", setUpdateRoomTa(), updateRoomBtn);
        addNewTab("CANCEL RESERVATION", setCancelReservationTa(), cancelReservation);
        addNewTab("UPDATE MANAGER", setUpdateManagerTa(), updateManagerBtn);
        addNewTab("ADD ROOM TYPES", setAddRoomTypesTa(), addRoomTypesBtn);
        addNewTab("UPDATE ROOM TYPE", setUpdateRoomTa(), updateRoomTypeBtn);

        BorderLayout bl = new BorderLayout();
        bl.setHgap(20);
        bl.setVgap(20);
        this.setLayout(bl);
        this.add("North", northPanel);
        this.add("Center",tabs);

    }

    private void addNewTab(String tabName, JTextArea ta, JButton button){
        JPanel pan = new JPanel();
        pan.setLayout(new BorderLayout());
        pan.add("Center", ta);
        pan.add("South", button);
        tabs.addTab(tabName, pan);
    }

    private JTextArea setAddHotelTextArea(){
        sb.delete(0,sb.length());
        sb.append("city : \n");
        sb.append("hotel name : \n");
        sb.append("description : \n");
        addHotelTa.setText(sb.toString());
        return addHotelTa;
    }

    public JTextArea setUpdateHotelTa(){
        sb.delete(0,sb.length());
        sb.append("city : \n");
        sb.append("hotel name : \n");
        sb.append("description : \n");
        updateHotelTa.setText(sb.toString());
        return updateHotelTa;
    }

    public JTextArea setAddRoomTa(){
        sb.delete(0,sb.length());
        sb.append("room number : \n");
        sb.append("room type : \n");
        addRoomTa.setText(sb.toString());
        return addRoomTa;
    }
    public JTextArea setUpdateRoomTa(){
        sb.delete(0,sb.length());
        sb.append("room number : \n");
        sb.append("room type : \n");
        sb.append("price : \n");
        updateRoomTa.setText(sb.toString());
        return updateRoomTa;
    }
    public JTextArea setCancelReservationTa(){
        sb.delete(0,sb.length());
        sb.append("reservation id : \n");
        cancelReservationTa.setText(sb.toString());
        return cancelReservationTa;
    }
    public JTextArea setUpdateManagerTa(){
        sb.delete(0,sb.length());
        sb.append("username : \n");
        sb.append("fistName : \n");
        sb.append("lastName : \n");
        sb.append("email : \n");
        sb.append("phoneNumber : \n");
        sb.append("birthdate : \n");
        sb.append("hireDate : \n");
        updateManagerTa.setText(sb.toString());
        return updateManagerTa;
    }

    public JTextArea setAddRoomTypesTa(){
        sb.delete(0,sb.length());
        sb.append("YOU CAN ADD AS MANY AS YOU WANT ROOM TYPES FOR THE HOTEL! \n\n");
        sb.append("example:\n\n");
        sb.append("typeName: D, pricePerDay: 20.0 #\n");
        sb.append("typeName: C, pricePerDay: 40.0 #\n");
        sb.append("typeName: B, pricePerDay: 80.0 #\n");
        sb.append("typeName: A, pricePerDay: 150.0 #\n");
        sb.append("=================================+\n");
        listNotificationsTa.setText(sb.toString());
        return listNotificationsTa;
    }
    public JTextArea updateRoomTypeTa(){
        sb.delete(0,sb.length());
        sb.append("type name : ");
        sb.append("price per day : ");
        listNotificationsTa.setText(sb.toString());
        return listNotificationsTa;
    }
}
