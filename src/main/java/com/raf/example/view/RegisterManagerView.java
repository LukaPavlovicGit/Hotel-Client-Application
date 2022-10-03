package com.raf.example.view;

import com.raf.example.controller.BackAction;
import com.raf.example.controller.RegisterClientAction;
import com.raf.example.controller.RegisterManagerAction;

import javax.swing.*;
import java.awt.*;

public class RegisterManagerView extends JPanel {

    private StringBuilder sb = new StringBuilder();
    private JTabbedPane tabs = new JTabbedPane(JTabbedPane.TOP);

    private JButton registerBtn = new JButton("REGISTER");
    private JButton backBtn = new JButton("BACK");

    private JTextArea registerTa = new JTextArea();

    public RegisterManagerView(){

        registerBtn.addActionListener(new RegisterManagerAction(registerTa));
        backBtn.addActionListener(new BackAction());

        JPanel jContentPane = new JPanel();
        jContentPane.setLayout(null);

        JPanel northPanel = new JPanel();

        northPanel.setBounds(61, 11, 81, 140);
        northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.X_AXIS));
        jContentPane.add(northPanel);

        northPanel.add(backBtn);

        addNewTab("REGISTER MANAGER", setRegisterTa(), registerBtn);

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
    private JTextArea setRegisterTa(){
        sb.delete(0,sb.length());
        sb.append("username : \n");
        sb.append("password : \n");
        sb.append("fistName : \n");
        sb.append("lastName : \n");
        sb.append("email : \n");
        sb.append("phoneNumber : \n");
        sb.append("birthdate : \n");
        sb.append("hireDate : \n");
        registerTa.setText(sb.toString());
        return registerTa;
    }
}