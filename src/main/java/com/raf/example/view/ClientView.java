package com.raf.example.view;

import com.raf.example.MainFrame;
import com.raf.example.dto.*;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

public class ClientView extends JPanel {
    private StringBuilder sb = new StringBuilder();
    private JTabbedPane tabs = new JTabbedPane(JTabbedPane.TOP);

    private JButton listAvailableRoomsBtn = new JButton("LIST AVAILABLE ROOMS");
    private JButton reservationBtn = new JButton("RESERVATION");
    private JButton cancelReservationBtn = new JButton("CANCEL RESERVATION");
    private JButton addReviewBtn = new JButton("ADD REVIEW");
    private JButton listReviewsBtn = new JButton("LIST REVIEWS");
    private JButton updateReviewBtn = new JButton("UPDATE REVIEW");
    private JButton deleteReviewBtn = new JButton("DELETE REVIEW");
    private JButton updateClientBtn = new JButton("UPDATE CLIENT");
    private JButton bestHotelsBtn = new JButton("BEST HOTELS");
    private JButton listNotificationsBtn = new JButton("LIST NOTIFICATIONS");

    private JTextArea listAvailableRoomsTa = new JTextArea();
    private JTextArea reservationTa = new JTextArea();
    private JTextArea cancelReservationTa = new JTextArea();
    private JTextArea addReviewTa = new JTextArea();
    private JTextArea listReviewsTa = new JTextArea();
    private JTextArea updateReviewTa = new JTextArea();
    private JTextArea deleteReviewTa = new JTextArea();
    private JTextArea updateClientTa = new JTextArea();
    private JTextArea bestHotelsTa = new JTextArea();
    private JTextArea listNotificationsTa = new JTextArea();

    public ClientView(){
        addListeners();

        JPanel jContentPane = new JPanel();
        jContentPane.setLayout(null);

        JPanel northPanel = new JPanel();

        northPanel.setBounds(61, 11, 81, 140);
        northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.X_AXIS));
        jContentPane.add(northPanel);

        northPanel.add(bestHotelsBtn);

        addNewTab("LIST AVAILABLE ROOMS", setListAvailableRoomsTa(), listNotificationsBtn);
        addNewTab("RESERVATION", setReservationTa(), reservationBtn);
        addNewTab("CANCEL RESERVATION", setCancelReservationTa(), cancelReservationBtn);
        addNewTab("LIST REVIEWS", setListReviewsTa(), listReviewsBtn);
        addNewTab("UPDATE REVIEW", setUpdateReviewTa(), updateReviewBtn);
        addNewTab("DELETE REVIEW", setDeleteReviewTa(), deleteReviewBtn);
        addNewTab("UPDATE CLIENT", setUpdateClientTa(), updateClientBtn);
        addNewTab("LIST NOTIFICATIONS", setListNotificationsTa(), listNotificationsBtn);

        BorderLayout bl = new BorderLayout();
        bl.setHgap(20);
        bl.setVgap(20);
        this.setLayout(bl);
        this.add("North", northPanel);
        this.add("Center",tabs);
    }

    private void addListeners() {
        listAvailableRoomsBtn.addActionListener(e -> {
            try {
                String[] str = listAvailableRoomsTa.getText().split("[\n]");
                MainFrame.getInstance().getReservationService()
                        .getAvailableRooms(new AvailableRoomsFilterDto(
                            str[0].split(":")[1].trim(),
                            str[1].split(":")[1].trim(),
                            LocalDate.parse(str[2].split(":")[1].trim()),
                            LocalDate.parse(str[3].split(":")[1].trim()),
                            str[4].split(":")[1].trim())  );
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        reservationBtn.addActionListener(e -> {
            try {
                String[] str = listAvailableRoomsTa.getText().split("[\n]");
                MainFrame.getInstance().getReservationService()
                                        .createReservation(
                                                str[0].split(":")[1].trim(),
                                                str[1].split(":")[1].trim(),
                                                str[2].split(":")[1].trim() );

            }catch (Exception exception){
                exception.printStackTrace();
            }
        });
        cancelReservationBtn.addActionListener(e -> {
            try {
                String[] str = listAvailableRoomsTa.getText().split("[\n]");
                MainFrame.getInstance().getReservationService().cancelReservation( str[0].split(":")[1].trim() );
            }catch (Exception exception){
                exception.printStackTrace();
            }
        });
        addReviewBtn.addActionListener(e -> {
            try {
                String[] str = listAvailableRoomsTa.getText().split("[\n]");
                MainFrame.getInstance().getReservationService()
                                        .addReview(new ReviewDto(Long.valueOf(
                                                    str[0].split(":")[1].trim()),
                                                    Long.valueOf(str[1].split(":")[1].trim()),
                                                    Integer.valueOf(str[2].split(":")[1].trim()),
                                                    str[3].split(":")[1].trim()) );
            }catch (Exception exception){
                exception.printStackTrace();
            }
        });
        listReviewsBtn.addActionListener(e -> {
            try { // String hotelName, String city
                String[] str = listAvailableRoomsTa.getText().split("[\n]");
                List reviews = (List) MainFrame.getInstance().getReservationService()
                        .getAllReviews(str[0].split(":")[1].trim(),
                                       str[1].split(":")[1].trim() );

                JOptionPane.showMessageDialog(null, reviews);
            }catch (Exception exception){
                exception.printStackTrace();
            }
        });
        updateReviewBtn.addActionListener(e -> {
            try {
                String[] str = listAvailableRoomsTa.getText().split("[\n]");
                MainFrame.getInstance().getReservationService()
                        .updateReview(str[0].split(":")[1].trim(), new ReviewDto(Long.valueOf(
                                str[1].split(":")[1].trim()),
                                Long.valueOf(str[2].split(":")[1].trim()),
                                Integer.valueOf(str[3].split(":")[1].trim()),
                                str[4].split(":")[1].trim()));
            } catch(Exception exception){
                exception.printStackTrace();
            }

        });
        deleteReviewBtn.addActionListener(e -> {
            try {
                String[] str = listAvailableRoomsTa.getText().split("[\n]");
                MainFrame.getInstance().getReservationService().deleteReview( str[0].split(":")[1].trim() );

            } catch(Exception exception){
                exception.printStackTrace();
            }
        });
        updateClientBtn.addActionListener(e -> {
            try {
                String[] str = updateClientTa.getText().split("[\n]");
                MainFrame.getInstance().getUserService()
                        .updateClient( new ClientDto(
                                    str[0].split(":")[1].trim(),
                                    str[1].split(":")[1].trim(),
                                    str[2].split(":")[1].trim(),
                                    str[3].split(":")[1].trim(),
                                    str[4].split(":")[1].trim(),
                                    Date.valueOf(str[5].split(":")[1].trim()),
                                    str[6].split(":")[1].trim() ));
            }
            catch (Exception ex) {
                JOptionPane.showMessageDialog(
                        null, "Error while updating manager in managerView", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        bestHotelsBtn.addActionListener(e -> {
            try {
                List list = (List) MainFrame.getInstance().getReservationService().getTopRatedHotels();
                JOptionPane.showMessageDialog(null, list);
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        listNotificationsBtn.addActionListener(e -> {
            try {
                String[] str = updateClientTa.getText().split("[\n]");
                java.util.List<SentEmailDto> list =  MainFrame.getInstance().getNotificationService().getAllNotificationsByCurrentUserEmail();
                JOptionPane.showMessageDialog(null, list);
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        });
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
    private JTextArea setCancelReservationTa(){
        sb.delete(0,sb.length());
        sb.append("reservation id : \n");
        cancelReservationTa.setText(sb.toString());
        return cancelReservationTa;
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
    private JTextArea setBestHotelsTa(){
        sb.delete(0,sb.length());
        bestHotelsTa.setText(sb.toString());
        return bestHotelsTa;
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
