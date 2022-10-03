package com.raf.example.view;

import com.raf.example.MainFrame;
import com.raf.example.controller.*;
import com.raf.example.dto.EmailNotificationDto;
import com.raf.example.dto.RankDto;
import com.raf.example.dto.UserDto;

import javax.swing.*;
import java.awt.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class AdminView extends JPanel {
    private StringBuilder sb = new StringBuilder();
    private JTabbedPane tabs = new JTabbedPane(JTabbedPane.TOP);

    private JButton blockUserBtn = new JButton("BLOCK");
    private JButton unBlockUserBtn = new JButton("UNBLOCK");
    private JButton addRankBtn = new JButton("ADD");
    private JButton addAllRanksBtn = new JButton("ADD ALL");
    private JButton rankConfigurationBtn = new JButton("CONFIGURE");
    private JButton getAllUsersBtn = new JButton("GET ALL USERS");
    private JButton updateAdminBtn = new JButton("UPDATE");
    private JButton getAllNotificationsBtn = new JButton("GET ALL NOTIFICATION");
    private JButton getAllNotificationTypesBtn = new JButton("GET ALL NOTIFICATION TYPES");
    private JButton updateNotificationTypeBtn = new JButton("CHANGE");
    private JButton deleteNotificationTypeBtn = new JButton("DELETE");

    private JTextArea blockUserTa = new JTextArea();
    private JTextArea unBlockUserTa = new JTextArea();
    private JTextArea addRankTa = new JTextArea();
    private JTextArea addAllRanksTa = new JTextArea();
    private JTextArea rankConfigurationTa = new JTextArea();
    private JTextArea updateAdminTa = new JTextArea();
    private JTextArea updateNotificationTypeTa = new JTextArea();
    private JTextArea deleteNotificationTypeTa = new JTextArea();


    public AdminView(){

        blockUserBtn.addActionListener(new BlockUserAction(blockUserTa));
        unBlockUserBtn.addActionListener(new UnblockUserAction(unBlockUserTa));
        addRankBtn.addActionListener(new AddRankAction(addRankTa));
        addAllRanksBtn.addActionListener(new AddAllRanksAction(addAllRanksTa));
        rankConfigurationBtn.addActionListener(new RankConfigurationAction(rankConfigurationTa));
        updateAdminBtn.addActionListener(new UpdateAdminAction(updateAdminTa));
        updateNotificationTypeBtn.addActionListener(new UpdateNotificationTypeAction(updateNotificationTypeTa));
        deleteNotificationTypeBtn.addActionListener(new DeleteNotificationType(deleteNotificationTypeTa));
        getAllUsersBtn.addActionListener(new GetAllUsersAction());
        getAllNotificationsBtn.addActionListener(new GetAllNotificationsAction());
        getAllNotificationTypesBtn.addActionListener(new GetAllNotificationTypesAction());

        addNewTab("BLOCK USER", setBlockUserTa(), blockUserBtn);
        addNewTab("UNBLOCK USER", setUnBlockUserTa(), unBlockUserBtn);
        addNewTab("ADD RANK", setAddRankTa(), addRankBtn);
        addNewTab("add all ranks", setAddAllRanksTa(), addAllRanksBtn);
        addNewTab("RANK CONFIG", setRankConfigurationTa(), rankConfigurationBtn);
        addNewTab("UPDATE ADMIN", setUpdateAdminTa(), updateAdminBtn);
        addNewTab("notif type config", setUpdateNotificationTypeTa(), updateNotificationTypeBtn);
        addNewTab("delete notif type", setBlockUserTa(), blockUserBtn);


        JPanel jContentPane = new JPanel();
        jContentPane.setLayout(null);

        JPanel northPanel = new JPanel();

        northPanel.setBounds(61, 11, 81, 140);
        northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.X_AXIS));
        jContentPane.add(northPanel);

        northPanel.add(getAllNotificationsBtn);
        northPanel.add(getAllNotificationsBtn);
        northPanel.add(getAllNotificationTypesBtn);
    }

    private void addNewTab(String tabName, JTextArea ta, JButton button){
        JPanel pan = new JPanel();
        pan.setLayout(new BorderLayout());
        pan.add("Center", ta);
        pan.add("South", button);
        tabs.addTab(tabName, pan);
    }

    public JTextArea setBlockUserTa() {
        sb.delete(0,sb.length());
        sb.append("user id : \n");
        blockUserTa.setText(sb.toString());
        return blockUserTa;
    }

    public JTextArea setUnBlockUserTa() {
        sb.delete(0,sb.length());
        sb.append("user id : \n");
        unBlockUserTa.setText(sb.toString());
        return unBlockUserTa;
    }
    public JTextArea setAddRankTa() {
        sb.delete(0,sb.length());
        sb.append("name : \n");
        sb.append("reach : \n");
        addRankTa.setText(sb.toString());
        return addRankTa;
    }

    public JTextArea setAddAllRanksTa() {
        sb.delete(0,sb.length());
        sb.append("YOU CAN ADD AS MANY AS YOU WANT RANK TYPES! \n\n");
        sb.append("example:\n\n");
        sb.append("name: BRONZE, reach: 5 #\n");
        sb.append("name: SILVER, reach: 10 #\n");
        sb.append("name: GOLD, reach: 20 #\n");
        sb.append("name: GOLDPREMIUM, reach: 40 #\n");
        sb.append("=================================+\n");
        addRankTa.setText(sb.toString());
        return addAllRanksTa;
    }

    public JTextArea setRankConfigurationTa() {
        sb.delete(0,sb.length());
        sb.append("rank id (to apply changes on): \n");
        sb.append("name : \n");
        sb.append("reach : \n");
        rankConfigurationTa.setText(sb.toString());
        return rankConfigurationTa;
    }

    public JTextArea setUpdateAdminTa() {
        sb.delete(0,sb.length());
        sb.append("username : \n");
        sb.append("fistName : \n");
        sb.append("lastName : \n");
        sb.append("email : \n");
        sb.append("phoneNumber : \n");
        sb.append("birthdate : \n");
        updateAdminTa.setText(sb.toString());
        return updateAdminTa;
    }

    public JTextArea setUpdateNotificationTypeTa() {
        sb.delete(0,sb.length());
        sb.append("Notification id (to apply changes on) : \n");
        sb.append("type name : \n");
        sb.append("text : \n");
        updateNotificationTypeTa.setText(sb.toString());
        return updateNotificationTypeTa;
    }
    public JTextArea setDeleteNotificationTypeTa() {
        sb.delete(0,sb.length());
        sb.append("notification id : \n");
        deleteNotificationTypeTa.setText(sb.toString());
        return deleteNotificationTypeTa;
    }
}
