package com.raf.example.view;

import com.raf.example.MainFrame;
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
    private JButton getAllUsersBtn = new JButton("GET ALL");
    private JButton updateAdminBtn = new JButton("UPDATE");
    private JButton getAllNotificationsBtn = new JButton("GET ALL");
    private JButton getAllNotificationTypesBtn = new JButton("GET ALL");
    private JButton changeNotificationTypeBtn = new JButton("CHANGE");
    private JButton deleteNotificationTypeBtn = new JButton("DELETE");

    private JTextArea blockUserTa = new JTextArea();
    private JTextArea unBlockUserTa = new JTextArea();
    private JTextArea addRankTa = new JTextArea();
    private JTextArea addAllRanksTa = new JTextArea();
    private JTextArea rankConfigurationTa = new JTextArea();
    private JTextArea updateAdminTa = new JTextArea();
    private JTextArea changeNotificationTypeTa = new JTextArea();
    private JTextArea deleteNotificationTypeTa = new JTextArea();


    public AdminView(){
        addListeners();

        JPanel jContentPane = new JPanel();
        jContentPane.setLayout(null);

        JPanel northPanel = new JPanel();

        northPanel.setBounds(61, 11, 81, 140);
        northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.X_AXIS));
        jContentPane.add(northPanel);
    }

    private void addListeners() {
        blockUserBtn.addActionListener(e -> {
            try{
                String[] str = blockUserTa.getText().split("[\n]");
                MainFrame.getInstance().getUserService().blockUser(str[0].split(":")[1].trim());
            }catch (Exception exception){
                exception.printStackTrace();
            }
        });
        unBlockUserBtn.addActionListener(e -> {
            try{
                String[] str = blockUserTa.getText().split("[\n]");
                MainFrame.getInstance().getUserService().unblockUser(str[0].split(":")[1].trim());
            }catch (Exception exception){
                exception.printStackTrace();
            }
        });
        addRankBtn.addActionListener(e -> {
            try{
                String[] str = blockUserTa.getText().split("[\n]");
                MainFrame.getInstance().getUserService()
                        .addRank(new RankDto(str[0].split(":")[1].trim(),
                                             Integer.valueOf(str[1].split(":")[1].trim())) );
            }catch (Exception exception){
                exception.printStackTrace();
            }
        });
        addAllRanksBtn.addActionListener(e -> {
            try{
                String text = addAllRanksTa.getText().split("[+]")[1];
                String[] str = text.split("#");
                List<RankDto> list = new ArrayList<>();
                for(String line : str) {
                    list.add(new RankDto(
                                str[0].split(":")[1].trim(),
                                Integer.valueOf(str[1].split(":")[1].trim())) );
                }
                MainFrame.getInstance().getUserService().addAllRanks(list);
            }
            catch(Exception exception){
                exception.printStackTrace();
            }
        });
        rankConfigurationBtn.addActionListener(e -> {
            try{
                String[] str = blockUserTa.getText().split("[\n]");
                MainFrame.getInstance().getUserService()
                        .rankConfiguration(new RankDto(
                                Long.valueOf(str[0].split(":")[1].trim()),
                                str[1].split(":")[1].trim(),
                                Integer.valueOf(str[2].split(":")[1].trim())) );
            }
            catch (Exception exception){
                exception.printStackTrace();
            }
        });
        updateAdminBtn.addActionListener(e -> {
            try{
                String[] str = updateAdminTa.getText().split("[\n]");
                MainFrame.getInstance().getUserService()
                        .updateAdmin( new UserDto(
                                str[0].split(":")[1].trim(),
                                str[1].split(":")[1].trim(),
                                str[2].split(":")[1].trim(),
                                str[3].split(":")[1].trim(),
                                str[4].split(":")[1].trim(),
                                Date.valueOf(str[5].split(":")[1].trim())) );
            }
            catch (Exception exception){
                exception.printStackTrace();
            }
        });
        changeNotificationTypeBtn.addActionListener(e -> {
            try{
                String[] str = changeNotificationTypeTa.getText().split("[\n]");
                MainFrame.getInstance().getNotificationService()
                        .changeNotificationType(new EmailNotificationDto(
                                Long.valueOf(str[0].split(":")[1].trim()),
                                str[1].split(":")[1].trim(),
                                str[2].split(":")[1].trim()) );
            }
            catch (Exception exception){
                exception.printStackTrace();
            }
        });
        deleteNotificationTypeBtn.addActionListener(e -> {
            try{
                String[] str = changeNotificationTypeTa.getText().split("[\n]");
                MainFrame.getInstance().getNotificationService()
                        .deleteNotificationType( Long.valueOf(str[0].split(":")[1].trim()) );
            }
            catch (Exception exception){
                exception.printStackTrace();
            }
        });
        getAllUsersBtn.addActionListener(e -> {

        });
        getAllNotificationsBtn.addActionListener(e -> {

        });
        getAllNotificationTypesBtn.addActionListener(e -> {

        });
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

    public JTextArea setChangeNotificationTypeTa() {
        sb.delete(0,sb.length());
        sb.append("Notification id (to apply changes on) : \n");
        sb.append("type name : \n");
        sb.append("text : \n");
        changeNotificationTypeTa.setText(sb.toString());
        return changeNotificationTypeTa;
    }
    public JTextArea setDeleteNotificationTypeTa() {
        sb.delete(0,sb.length());
        sb.append("notification id : \n");
        deleteNotificationTypeTa.setText(sb.toString());
        return deleteNotificationTypeTa;
    }
}
