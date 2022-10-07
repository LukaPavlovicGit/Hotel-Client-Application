package com.raf.example.view;

import com.raf.example.controller.*;

import javax.swing.*;
import java.awt.*;

public class ClientView extends JPanel {
    private StringBuilder sb = new StringBuilder();
    private JTabbedPane tabs = new JTabbedPane(JTabbedPane.TOP);

    private JButton listAvailableRoomsBtn = new JButton("LIST AVAILABLE ROOMS");
    private JButton reservationBtn = new JButton("RESERVATION");
    private JButton deleteReservationBtn = new JButton("DELETE");
    private JButton addReviewBtn = new JButton("ADD");
    private JButton listReviewsBtn = new JButton("LIST");
    private JButton updateReviewBtn = new JButton("UPDATE");
    private JButton deleteReviewBtn = new JButton("DELETE");
    private JButton updateClientBtn = new JButton("UPDATE");
    private JButton listBestHotelsBtn = new JButton("BEST HOTELS");
    private JButton listNotificationsBtn = new JButton("LIST NOTIFICATIONS");
    private JButton backBtn = new JButton("BACK");

    private JTextArea listAvailableRoomsTa = new JTextArea();
    private JTextArea reservationTa = new JTextArea();
    private JTextArea deleteReservationTa = new JTextArea();
    private JTextArea addReviewTa = new JTextArea();
    private JTextArea listReviewsTa = new JTextArea();
    private JTextArea updateReviewTa = new JTextArea();
    private JTextArea deleteReviewTa = new JTextArea();
    private JTextArea updateClientTa = new JTextArea();
    private JTextArea listNotificationsTa = new JTextArea();

    public ClientView(){

        listAvailableRoomsBtn.addActionListener(new AvailableRoomsAction(listAvailableRoomsTa));
        reservationBtn.addActionListener(new ReservationAction(reservationTa));
        deleteReservationBtn.addActionListener(new DeleteReservationAction(deleteReservationTa));
        addReviewBtn.addActionListener(new AddReviewAction(addReviewTa));
        listReviewsBtn.addActionListener(new ListReviewsAction(listReviewsTa));
        updateReviewBtn.addActionListener(new UpdateReviewAction(updateReviewTa));
        deleteReviewBtn.addActionListener(new DeleteReviewAction(deleteReviewTa));
        updateClientBtn.addActionListener(new UpdateClientAction(updateClientTa));
        listBestHotelsBtn.addActionListener(new ListBestHotelsAction());
        listNotificationsBtn.addActionListener(new ListNotificationsAction());
        backBtn.addActionListener(new Back1Action());

        addNewTab("LIST AVAILABLE ROOMS", setListAvailableRoomsTa(), listAvailableRoomsBtn);
        addNewTab("RESERVATION", setReservationTa(), reservationBtn);
        addNewTab("DELETE RESERVATION", setDeleteReservationTa(), deleteReservationBtn);
        addNewTab("LIST REVIEWS", setListReviewsTa(), listReviewsBtn);
        addNewTab("UPDATE REVIEW", setUpdateReviewTa(), updateReviewBtn);
        addNewTab("DELETE REVIEW", setDeleteReviewTa(), deleteReviewBtn);
        addNewTab("UPDATE CLIENT", setUpdateClientTa(), updateClientBtn);
        addNewTab("LIST NOTIFICATIONS", setListNotificationsTa(), listNotificationsBtn);

        JPanel jContentPane = new JPanel();
        jContentPane.setLayout(null);

        JPanel northPanel = new JPanel();

        northPanel.setBounds(61, 11, 81, 140);
        northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.X_AXIS));
        jContentPane.add(northPanel);

        northPanel.add(listBestHotelsBtn);
        northPanel.add(listNotificationsBtn);
        northPanel.add(backBtn);

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
    private JTextArea setListAvailableRoomsTa(){
        sb.delete(0,sb.length());
        sb.append("hotel name : \n");
        sb.append("city : \n");
        sb.append("start date (yyyy-MM-dd) : \n");
        sb.append("end date (yyyy-MM-dd) : \n");
        sb.append("sort (ASC/DESC) : \n");
        listAvailableRoomsTa.setText(sb.toString());
        return listAvailableRoomsTa;
    }
    private JTextArea setReservationTa(){
        sb.delete(0,sb.length());
        sb.append("room id : \n");
        sb.append("start date (yyyy-MM-dd) : \n");
        sb.append("end date (yyyy-MM-dd) : \n");
        reservationTa.setText(sb.toString());
        return reservationTa;
    }
    private JTextArea setDeleteReservationTa(){
        sb.delete(0,sb.length());
        sb.append("reservation id : \n");
        deleteReservationTa.setText(sb.toString());
        return deleteReservationTa;
    }
    private JTextArea setListReviewsTa(){
        sb.delete(0,sb.length());
        sb.append("hotel name (optional) : \n");
        sb.append("city (optional) : \n");
        listReviewsTa.setText(sb.toString());
        return listReviewsTa;
    }
    private JTextArea setAddReviewTa(){
        sb.delete(0,sb.length());
        sb.append("reservation id : \n");
        sb.append("client id : \n");
        sb.append("rating (1-5) : \n");
        sb.append("comment : \n");
        addReviewTa.setText(sb.toString());
        return addReviewTa;
    }
    private JTextArea setUpdateReviewTa(){
        sb.delete(0,sb.length());
        sb.append("reservation id : \n");
        sb.append("client id : \n");
        sb.append("rating (1-5) : \n");
        sb.append("comment : \n");
        updateReviewTa.setText(sb.toString());
        return updateReviewTa;
    }
    private JTextArea setDeleteReviewTa(){
        sb.delete(0,sb.length());
        sb.append("review id : \n");
        deleteReviewTa.setText(sb.toString());
        return deleteReviewTa;
    }
    private JTextArea setUpdateClientTa(){
        sb.delete(0,sb.length());
        sb.append("username : \n");
        sb.append("fistName : \n");
        sb.append("lastName : \n");
        sb.append("email : \n");
        sb.append("phoneNumber : \n");
        sb.append("birthdate : \n");
        sb.append("numOfPassport : \n");
        updateClientTa.setText(sb.toString());
        return updateClientTa;
    }
    private JTextArea setListNotificationsTa(){
        sb.delete(0,sb.length());
        sb.append("city : \n");
        sb.append("hotel name : \n");
        sb.append("description : \n");
        listNotificationsTa.setText(sb.toString());
        return listNotificationsTa;
    }

}
