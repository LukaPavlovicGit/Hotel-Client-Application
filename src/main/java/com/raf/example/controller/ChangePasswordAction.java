package com.raf.example.controller;

import com.raf.example.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangePasswordAction implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            MainFrame.getInstance().showForgotPasswordView();
        }catch (Exception exception){
            JOptionPane.showMessageDialog(null, "Error while changing password!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
