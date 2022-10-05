package com.raf.example.controller;

import com.raf.example.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GetAllUsersAction implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            List list = MainFrame.getInstance().getUserService().getAllUsers();
            JOptionPane.showMessageDialog(null, list);
        }
        catch (Exception exception){
            JOptionPane.showMessageDialog(null, "Error while getting all users!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
