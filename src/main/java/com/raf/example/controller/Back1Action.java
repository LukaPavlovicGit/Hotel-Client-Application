package com.raf.example.controller;

import com.raf.example.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Back1Action implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            MainFrame.getInstance().showLogin();
        }catch (Exception exception){
            JOptionPane.showMessageDialog(null, "Error while doing back action!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
