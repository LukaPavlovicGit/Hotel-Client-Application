package com.raf.example.view;

import com.raf.example.controller.*;

import javax.swing.*;
import java.awt.*;

public class ManagerView extends JPanel {

    private StringBuilder sb = new StringBuilder();
    private JTabbedPane tabs = new JTabbedPane(JTabbedPane.TOP);

    private JButton addHotelBtn = new JButton("ADD HOTEL");
    private JButton updateHotelBtn = new JButton("UPDATE HOTEL");
    private JButton deleteHotelBtn = new JButton("DELETE");
    private JButton addRoomBtn = new JButton("ADD ROOM");
    private JButton updateRoomBtn = new JButton("UPDATE ROOM");
    private JButton listReservations = new JButton("LIST ALL RESERVATIONS");
    private JButton deleteReservation = new JButton("DELETE");
    private JButton listNotificationsBtn = new JButton("LIST NOTIFICATIONS"); // NIJE IMPLEMENTIRANO
    private JButton updateManagerBtn = new JButton("UPDATE MANAGER");
    private JButton getNotificationsBtn = new JButton("GET NOTIFICATIONS"); // NIJE ODRANJENO, OVO JE ZA ADMINA SAMO????
    private JButton addRoomTypeBtn = new JButton("ADD");
    private JButton addAllRoomTypesBtn = new JButton("ADD ALL");
    private JButton updateRoomTypeBtn = new JButton("UPDATE TYPE");
    private JButton deleteRoomTypeBtn = new JButton("DELETE");
    private JButton listReviewsBtn = new JButton("LIST");
    private JButton deleteReviewBtn = new JButton("REMOVE");
    private JButton listBestHotelsBtn = new JButton("BEST HOTELS");
    private JButton listAvailableRoomsBtn = new JButton("LIST AVAILABLE ROOMS");
    private JButton getAllUsersBtn = new JButton("GET ALL USERS");
    private JButton getUserByIdBtn = new JButton("GET");

    private JTextArea addHotelTa = new JTextArea();
    private JTextArea updateHotelTa = new JTextArea();
    private JTextArea deleteHotelTa = new JTextArea();
    private JTextArea addRoomTa = new JTextArea();
    private JTextArea updateRoomTa = new JTextArea();
    private JTextArea getAllReservationsTa = new JTextArea();
    private JTextArea deleteReservationTa = new JTextArea();
    private JTextArea updateManagerTa = new JTextArea();
    private JTextArea listNotificationsTa = new JTextArea();
    private JTextArea addRoomTypeTa = new JTextArea();
    private JTextArea addAllRoomTypesTa = new JTextArea();
    private JTextArea updateRoomTypeTa = new JTextArea();
    private JTextArea deleteRoomTypeTa = new JTextArea();
    private JTextArea listReviewsTa = new JTextArea();
    private JTextArea deleteReviewTa = new JTextArea();
    private JTextArea listBestHotelsTa = new JTextArea();
    private JTextArea listAvailableRoomsTa = new JTextArea();
    private JTextArea getUserByIdTa = new JTextArea();

    public ManagerView(){

        addHotelBtn.addActionListener(new AddHotelAction(addHotelTa));
        updateHotelBtn.addActionListener(new UpdateHotelAction(updateHotelTa));
        deleteHotelBtn.addActionListener(new DeleteHotelAction());
        addRoomBtn.addActionListener(new AddRoomAction(addRoomTa));
        updateRoomBtn.addActionListener(new UpdateRoomAction(updateRoomTa));
        deleteReservation.addActionListener(new DeleteReservationAction(deleteReservationTa));
        updateManagerBtn.addActionListener(new UpdateRoomTypeAction(updateHotelTa));
        addRoomTypeBtn.addActionListener(new AddRoomTypeAction(addRoomTypeTa));
        addAllRoomTypesBtn.addActionListener(new AddAllRoomTypesAction(addAllRoomTypesTa));
        updateRoomTypeBtn.addActionListener(new UpdateManagerAction(updateRoomTypeTa));
        deleteHotelBtn.addActionListener(new DeleteRoomTypeAction(deleteHotelTa));
        listNotificationsBtn.addActionListener(new ListNotificationsAction());
        listReservations.addActionListener(new ListReservationsBtn());
        listReviewsBtn.addActionListener(new ListReviewsAction(listReviewsTa));
        deleteReviewBtn.addActionListener(new DeleteReviewAction(deleteReviewTa));
        listAvailableRoomsBtn.addActionListener(new ListAvailableRoomsAction(listAvailableRoomsTa));
        getAllUsersBtn.addActionListener(new GetAllUsersAction());
        getUserByIdBtn.addActionListener(new GetUserByIdAction(getUserByIdTa));
        listBestHotelsBtn.addActionListener(new ListBestHotelsAction());


        addNewTab("ADD HOTEL", setAddHotelTextArea(), addHotelBtn);
        addNewTab("UPDATE HOTEL", setUpdateHotelTa(), updateHotelBtn);
        addNewTab("DELETE HOTEL", setDeleteHotelTa(), deleteHotelBtn);
        addNewTab("ADD ROOM", setAddRoomTa(), addRoomBtn);
        addNewTab("UPDATE ROOM", setUpdateRoomTa(), updateRoomBtn);
        addNewTab("CANCEL RESERVATION", setDeleteReservationTa(), deleteReservation);
        addNewTab("UPDATE MANAGER", setUpdateManagerTa(), updateManagerBtn);
        addNewTab("ADD ROOM TYPE", setAddRoomTypeTa(), addRoomTypeBtn);
        addNewTab("ADD ALL ROOM TYPES", setAddAllRoomTypesTa(), addAllRoomTypesBtn);
        addNewTab("UPDATE ROOM TYPE", setUpdateRoomTa(), updateRoomTypeBtn);
        addNewTab("DELETE ROOM TYPE", setDeleteHotelTa(), deleteRoomTypeBtn);
        addNewTab("LIST REVIEWS", setListReviewsTa(), listReviewsBtn);
        addNewTab("DELETE REVIEW", setRemoveReviewTa(), deleteReviewBtn);
        addNewTab("LIST AVAILABLE ROOMS", setListAvailableRoomsTa(), listAvailableRoomsBtn);
        addNewTab("GET USER", setGetUserByIdTa(), getUserByIdBtn);


        JPanel jContentPane = new JPanel();
        jContentPane.setLayout(null);

        JPanel northPanel = new JPanel();

        northPanel.setBounds(61, 11, 81, 140);
        northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.X_AXIS));
        jContentPane.add(northPanel);

        northPanel.add(listNotificationsBtn);
        northPanel.add(listReservations);
        northPanel.add(listBestHotelsBtn);

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

    public JTextArea setDeleteHotelTa(){
        sb.delete(0,sb.length());
        sb.append("Hotel whose manager is currently connected will be deleted!\n");
        deleteHotelTa.setText(sb.toString());
        return deleteHotelTa;
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

    public JTextArea setDeleteRoomTypeTa(){
        sb.delete(0,sb.length());
        sb.append("room type id : \n");
        deleteRoomTypeTa.setText(sb.toString());
        return deleteRoomTypeTa;
    }
    public JTextArea setDeleteReservationTa(){
        sb.delete(0,sb.length());
        sb.append("reservation id : \n");
        deleteReservationTa.setText(sb.toString());
        return deleteReservationTa;
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

    public JTextArea setAddRoomTypeTa(){
        sb.delete(0,sb.length());
        sb.append("typeName: \n");
        sb.append("pricePerDay: \n");
        addRoomTypeTa.setText(sb.toString());
        return addRoomTa;
    }

    public JTextArea setAddAllRoomTypesTa(){
        sb.delete(0,sb.length());
        sb.append("YOU CAN ADD AS MANY AS YOU WANT ROOM TYPES FOR THE HOTEL! \n\n");
        sb.append("example:\n\n");
        sb.append("typeName: D, pricePerDay: 20.0 #\n");
        sb.append("typeName: C, pricePerDay: 40.0 #\n");
        sb.append("typeName: B, pricePerDay: 80.0 #\n");
        sb.append("typeName: A, pricePerDay: 150.0 #\n");
        sb.append("=================================+\n");
        addAllRoomTypesTa.setText(sb.toString());
        return addAllRoomTypesTa;
    }
    public JTextArea updateRoomTypeTa(){
        sb.delete(0,sb.length());
        sb.append("type name : ");
        sb.append("price per day : ");
        listNotificationsTa.setText(sb.toString());
        return listNotificationsTa;
    }
    public JTextArea deleteRoomTypeTa(){
        sb.delete(0,sb.length());
        sb.append("room type id : ");
        deleteRoomTypeTa.setText(sb.toString());
        return deleteRoomTypeTa;
    }
    private JTextArea setListReviewsTa(){
        sb.delete(0,sb.length());
        sb.append("hotel name (optional) : \n");
        sb.append("city (optional) : \n");
        listReviewsTa.setText(sb.toString());
        return listReviewsTa;
    }
    private JTextArea setRemoveReviewTa(){
        sb.delete(0,sb.length());
        sb.append("review id : \n");
        deleteReviewTa.setText(sb.toString());
        return deleteReviewTa;
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

    public JTextArea setGetUserByIdTa(){
        sb.delete(0,sb.length());
        sb.append("room type id : \n");
        getUserByIdTa.setText(sb.toString());
        return getUserByIdTa;
    }
}
