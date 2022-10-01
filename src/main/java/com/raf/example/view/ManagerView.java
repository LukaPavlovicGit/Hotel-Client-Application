package com.raf.example.view;

import com.raf.example.MainFrame;
import com.raf.example.dto.HotelDto;
import com.raf.example.dto.ManagerDto;
import com.raf.example.dto.RoomDto;

import javax.swing.*;
import java.io.IOException;
import java.sql.Date;

public class ManagerView extends JPanel {
    // add new hotel
    private JTextField newHotelCity = new JTextField("city");
    private JTextField newHotelName = new JTextField("hotel name");
    private JTextField newHotelDescription = new JTextField("description");
    private JButton addHotelBtn = new JButton("ADD HOTEL");
    private JPanel panel1 = new JPanel();

    // update hotel
    private JTextField updateHotelCity = new JTextField("city");
    private JTextField updateHotelName = new JTextField("hotel name");
    private JTextField updateHotelDescription = new JTextField("description");
    private JButton updateHotelBtn = new JButton("UPDATE HOTEL");
    private JPanel panel2 = new JPanel();

    // add new room
    private JTextField newRoomNumber = new JTextField("room number");
    private JTextField newRoomType = new JTextField("room type");
    private JButton addRoomBtn = new JButton("ADD ROOM");
    private JPanel panel3 = new JPanel();

    // edit room
    private JTextField currentRoomNumber = new JTextField("room number");
    private JTextField updateRoomNumber = new JTextField("room type");
    private JTextField updateRoomType = new JTextField("price per day");
    private JTextField updateRoomPrice= new JTextField("room number");
    private JButton updateRoomBtn = new JButton("UPDATE ROOM");
    private JPanel panel4 = new JPanel();

    /*  IMPLEMENTIRAJ ZA ROOMTYPECONTROLER FUNCKIONALNOSTI

    private JTextField startPrice = new JTextField("start price");
    private JTextField endPrice = new JTextField("end price");
    private JTextField newType = new JTextField("new type");
    private JButton setTypes = new JButton("SET TYPE");
    private JPanel panel5 = new JPanel();
    */

    // cancel reservation
    private JTextField reservationId = new JTextField("reservation id");
    private JButton showReservations = new JButton("SHOW ALL");
    private JButton cancelReservation = new JButton("CANCEL RESERV");
    private JPanel panel6 = new JPanel();

    /*   NIJE IMPLEMENTIRANO
    // list notifications sent to manager
    private JButton listNotifications = new JButton("LIST NOTIFS");
    private JPanel panel7 = new JPanel();;


     */

    // update parameters
    private JTextField usernameChange = new JTextField("username"),
                       passChange = new JTextField("passwords"),
                       emailChange = new JTextField("email"),
                       pNoChange = new JTextField("phone no."),
                       dateChange = new JTextField("date of birth"),
                       dateEmpChange = new JTextField("hire date"),
                       fNameChange = new JTextField("name"),
                       lNameChange = new JTextField("lastname"),
                       psChange = new JTextField("passport");
    private JButton btnChange = new JButton("UPDATE USER");
    private JPanel panel8= new JPanel();;

    //list notifications
    private JTextField notifTypeFilterField = new JTextField("");
    private JTextField notifDateAfterField = new JTextField("");;
    private JButton getNotifsBtn = new JButton("GET NOTIFICATIONS");
    private JPanel panel11= new JPanel();

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

        panel3.add(newRoomNumber);
        panel3.add(newRoomType);
        panel3.add(addRoomBtn);

        panel4.add(currentRoomNumber);
        panel4.add(updateRoomNumber);
        panel4.add(updateRoomType);
        panel4.add(updateRoomPrice);
        panel4.add(updateRoomBtn);

        panel6.add(showReservations);
        panel6.add(reservationId);
        panel6.add(cancelReservation);

        panel8.add(usernameChange);
        panel8.add(passChange);
        panel8.add(emailChange);
        panel8.add(pNoChange);
        panel8.add(dateChange);
        panel8.add(dateEmpChange);
        panel8.add(fNameChange);
        panel8.add(lNameChange);
        panel8.add(psChange);
        panel8.add(btnChange);

        panel11.add(notifTypeFilterField);
        panel11.add(notifDateAfterField);
        panel11.add(getNotifsBtn);


        this.removeAll();
        this.add(panel1);
        this.add(panel2);
        this.add(panel3);
        this.add(panel4);
        //this.add(panel5);
        this.add(panel6);
        //this.add(panel7);
        this.add(panel8);
      //  this.add(panel10);
        this.add(panel11);
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

        updateHotelBtn.addActionListener(e -> {
            try {
                HotelDto hotelDto = new HotelDto(updateHotelCity.getText(), updateHotelName.getText(), updateHotelDescription.getText());
                MainFrame.getInstance().getReservationService().updateHotel(hotelDto);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        addRoomBtn.addActionListener(e -> {
            try {
                MainFrame.getInstance().getReservationService().addRoom(newRoomType.getText(), Integer.valueOf(newRoomNumber.getText()));
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        updateRoomBtn.addActionListener(e -> {
            try {
                RoomDto roomDto = new RoomDto(Integer.parseInt(currentRoomNumber.getText()), updateRoomType.getText(), Double.parseDouble(updateRoomPrice.getText()));
                MainFrame.getInstance().getReservationService().editRoom(roomDto);
            }
            catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        cancelReservation.addActionListener(e -> {
            try {
                MainFrame.getInstance().getReservationService().cancelReservation(reservationId.getText());
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        // String username, String fistName, String lastName, String email, String phoneNumber, Date birthdate, String hotelName, Date hireDate
        btnChange.addActionListener(e -> {
            ManagerDto dto = new ManagerDto();
            //dto.set(MainFrame.getInstance().getCurrentUser().getId());
            if(!usernameChange.getText().equals("") && !usernameChange.getText().equals("username"))
                dto.setUsername(usernameChange.getText());
            if(!fNameChange.getText().equals("") && !fNameChange.getText().equals("first name"))
                dto.setFistName(fNameChange.getText());
            if(!lNameChange.getText().equals("") && !lNameChange.getText().equals("last name"))
                dto.setLastName(lNameChange.getText());
            if(!emailChange.getText().equals("") && !emailChange.getText().equals("email"))
                dto.setEmail(emailChange.getText());
            if(!pNoChange.getText().equals("") && !pNoChange.getText().equals("phone no."))
                dto.setPhoneNumber(pNoChange.getText());
            if(!dateChange.getText().equals("") && !dateChange.getText().equals("date of birth"))
                dto.setBirthdate(Date.valueOf(dateChange.getText()));
            if(!dateEmpChange.getText().equals("") && !dateEmpChange.getText().equals("date of employment"))
                dto.setHireDate(Date.valueOf(dateEmpChange.getText()));

            try {
                //MainFrame.getInstance().getUserServiceRestClient().changeUser(dto);

                if (dto.getEmail() != null && !dto.getEmail().equals(""))
                    MainFrame.getInstance().getCurrentUser().setEmail(dto.getEmail());
                if (dto.getFistName() != null && !dto.getFistName().equals(""))
                    MainFrame.getInstance().getCurrentUser().setFirstName(dto.getFistName());
                if (dto.getLastName() != null && !dto.getLastName().equals(""))
                    MainFrame.getInstance().getCurrentUser().setLastName(dto.getLastName());
                if (dto.getUsername() != null && !dto.getUsername().equals(""))
                    MainFrame.getInstance().getCurrentUser().setUsername(dto.getUsername());
            }
            catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error while changing user", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });


    }
}
